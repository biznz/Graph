/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
/**
 *
 * @author user
 */
public class Algorithm {
    
    static Integer maxDepth=null;
    static Integer currentDepth;
    static Lifo<Node> Path;
    static int[][] base15Matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    //Heap min para busca informada
    static Heuristic heuristic=null;
    static boolean check_in_path=false;
    static Set<Move> moves = new HashSet<Move>(
            Arrays.asList(
                    new Move("up"),
                    new Move("down"),
                    new Move("left"),
                    new Move("right") 
            ));
    
    protected static String GENERAL_SEARCH(Problem initialProblem,Problem finalProblem, MyQueue<Node> QUEUEING_FN){
        //System.out.println("current max depth is:"+maxDepth);
        int visitedNodes=0;
        if(!SOLVABLE(initialProblem,finalProblem)){return "It is impossible to reach a solution" ;}
        //Node n = MAKE_NODE(INITIAL_STATE(initialProblem));
        //System.out.println(Node.result(n));
        MyQueue<Node> nodes = MAKE_QUEUE(QUEUEING_FN,MAKE_NODE(INITIAL_STATE(initialProblem)));
        //System.out.println(nodes.toString());
        while(!EMPTY(nodes)){
            //if(EMPTY(nodes)){return null;}
            Node node = REMOVE_FRONT(nodes);
            if(node!=null){
                visitedNodes+=1;
            }
            //System.out.println("Removing the node: ");
            //System.out.println(Node.result(node));
            if (STATE(node).equals(GOAL_TEST(finalProblem))){
                //System.out.println("REACHED A RESULT");
                //System.out.println("printing movement path:");
                Path = new Lifo<Node>();
                Path.build(node);
                //System.out.println(Path.pathPrint());
                //return Path.pathPrint();
                System.out.println("visited "+visitedNodes+" nodes");
                System.out.println("Solution found @ depth:"+node.DEPTH);
                return Path.pathPrint();
            }
            Set<Node> new_nodes = EXPAND(node,OPERATORS());
            //if(new_nodes==null){System.out.println("NOT EXPANDING\n");}
            nodes = QUEUEING_FN.add(nodes,new_nodes);
            //System.out.println("current depth: "+currentDepth);
        }
        System.out.println("visited "+visitedNodes+" nodes");
        return "solution not found";
    }
    //method checks if both initalProblem and finalProblem are both solvable
    private static boolean SOLVABLE(Problem initialProblem, Problem finalProblem){
        if(checkSolvable(initialProblem) && checkSolvable(finalProblem)){return true;}
        return false;
    }
    
    
    //method checks if problem is solvable
    public static boolean checkSolvable(Problem problem){
        int totalInversions=0;
        int blank=-1;
        int numRows = (int) Math.sqrt(problem.input.length);
        int position=0;
        for(int s=0;s<problem.input.length;s++){
            int inversions=0;
            if(problem.input[s]==0){
                blank = numRows-(s/numRows);
            }
            for(int h=position;h<problem.input.length;h++){
                if(problem.input[s]>problem.input[h] && problem.input[s]!=0 && problem.input[h]!=0){
                    inversions+=1;
                }
            }
            position+=1;
            totalInversions+=inversions;
        }
        if(((problem.input.length%2!=0 && totalInversions%2==0)) || ((problem.input.length%2==0) && ((blank%2==1) == (totalInversions%2==0)))){
            return true;
        }
        return false;
    }
    
    
    //method implements iterative depth search
    protected static String ITERATIVE_DEEPENING_SEARCH(Problem problem,Problem final1){
       int depth=1;
       String result;
       while(true){
           result = DEPTH_LIMITED_SEARCH(problem,final1,depth);
           if(result.equals("solution not found")){
               System.out.println("solution not found at depth: "+depth);
               depth+=1;}
           else{break;}
       }
       return result;
    }
    
    //method does a depth dependent search
    protected static String DEPTH_LIMITED_SEARCH(Problem initial1, Problem final1, int depth){
        currentDepth=0;
        maxDepth = depth;
        return GENERAL_SEARCH(initial1,final1, new Lifo());
        
    }
    
    //method implements a best first search
    // used by greedy and A*
    private static String BEST_FIRST_SEARCH(Problem initial1,Problem final1, Eval EVAL_FN){
        MyQueue<Node> queue = EVAL_FN.run(initial1);
        return GENERAL_SEARCH(initial1,final1,queue);
    }
    
    //method implements greedy search
    private static String GREEDY_SEARCH(Problem initial1,Problem final1){
        return BEST_FIRST_SEARCH(initial1,final1,null);
    }
    
    //method returns a state from a node
    private static State STATE(Node node){
        if(node==null){return null;}
        return node.STATE;
    }
    
    //method finds possible children of a node with all valid movements
    private static Set<Node> EXPAND(Node node,Set<Move> movements){
        //System.out.println("expanding to Depth: "+(node.getDEPTH()+1));
        //System.out.println("maximum depth is: "+maxDepth);
        Set<Node> childNodes = new HashSet<Node>();
        if(maxDepth!=null && node.getDEPTH()+1>maxDepth){
            //System.out.println("ENTERED DEPTH LIMIT IN NODE EXPANSION");
            return null;
        }
        currentDepth = new Integer(node.getDEPTH()+1);
        for(Move m:movements){
            if(Move.test(node.STATE, m)){
                State newState = new State(node.getSTATE().getPuzzle());
                newState = Move.execute(newState, m);
                if(newState!=null){
                    Node newNode = new Node(node,newState,m,currentDepth,0);
                    /*System.out.println("newly created node with movement: "+m.direction);
                    System.out.println(Node.result(newNode));
                    
                    System.out.println("QEUEING THE FOLLOWING NODE:");
                    System.out.println(Node.result(newNode));
                    System.out.println(newNode.printMovement());
                    System.out.println("-----------------------");*/
                    if(check_in_path){
                        if(!is_in_path(newNode.getPARENT_NODE(),newNode)){
                            childNodes.add(newNode);
                        }
                    }
                    else{
                        childNodes.add(newNode);
                    }
                }
                else{
                    System.out.println("Cannot do: "+m.direction+"\non"+Node.result(node));
                }
            }
            //Node newNode = new Node();
            
        }
        return childNodes;
    }
    
    //returns the movements available
    private static Set<Move> OPERATORS(){
        return moves;
    }
    
    
    private static boolean is_in_path(Node new_Node,Node check){
        if(check.equals(new_Node)){
            return true;
        }
        if(new_Node!=null){
            return is_in_path(new_Node.getPARENT_NODE(),check);
        }
        return false;
    }
    
    //builds a node from a state
    //adds it to a tree of nodes;
    private static Node MAKE_NODE(State state){
        Node node = new Node(state);
        //tree = new Tree(node);
        return node;
    }
    
    //creates an abstract queue from a node
    private static MyQueue<Node> MAKE_QUEUE(MyQueue<Node> queue,Node node){
        //MyQueue<Node> myQueue = queue;
        currentDepth = new Integer(0);
        queue.add(queue, node);
        //queue.size+=1;
        return queue;
    }
    
    //
    private static boolean EMPTY(MyQueue<Node> nodes){
        /*System.out.println("testing emptiness at loop start");        
        System.out.println("nodes queue size "+nodes.size);
        System.out.println("EMPTY TEST ||||||||||||||");
        System.out.println(nodes.toString());
        System.out.println("EMPTY TEST ||||||||||||||\n");*/
        if(nodes.size==0){return true;}
        return false;
    }
    
    private static Node REMOVE_FRONT(MyQueue<Node> nodes){
        Node node = null;
        if(nodes.size==0){return node;}
        //System.out.println(nodes.type+"\n");
        switch(nodes.type){
            case "fifo":{
                Fifo fifo = (Fifo)nodes;
                //System.out.println("Removing the following node");
                try{
                node = (Node)fifo.list.remove();
                fifo.size--;
                }
                catch(NoSuchElementException ex){
                    return null;
                }
                //System.out.println("queue current size:" +fifo.size);
                //System.out.println("REMOVED THE NODE: "+Node.result(node));
                break;
            }
            case "lifo":{
                Lifo lifo = (Lifo) nodes;
                try{
                node = (Node)lifo.list.pop();
                lifo.size--;
                }
                catch(EmptyStackException ex){
                    return null;
                }
                //System.out.println("queue current size:" +lifo.size);
                break;
            }
        }
        return node;
    }
    
    private static State GOAL_TEST(Problem problem){
        return new State(problem);
    }

    private static State INITIAL_STATE(Problem problem) {
        State state = new State(problem);
        //System.out.println(state.getPuzzle()+"");
        return state;
    }
    
    //private Set<Node> EXPAND(node,)
}
