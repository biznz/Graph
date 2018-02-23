/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author user
 */
public class Algorithm {
    
    static Integer maxDepth=null;
    static Integer currentDepth;
    static Lifo<Node> Path;
    //private State finalState;
    //private Node Initial;
    
    //Heap min para busca informada
    static Set<Move> moves = new HashSet<Move>(
            Arrays.asList(
                    new Move("up"),
                    new Move("down"),
                    new Move("left"),
                    new Move("right") 
            ));
    
    protected static String GENERAL_SEARCH(Problem initialProblem,Problem finalProblem, MyQueue<Node> QUEUEING_FN){
        
        if(!SOLVABLE(initialProblem,finalProblem)){return "It is impossible to reach a solution" ;}
        //Node n = MAKE_NODE(INITIAL_STATE(initialProblem));
        //System.out.println(Node.result(n));
        MyQueue<Node> nodes = MAKE_QUEUE(QUEUEING_FN,MAKE_NODE(INITIAL_STATE(initialProblem)));
        //System.out.println(nodes.toString());
        System.out.println("FINISHED\n");
        while(!EMPTY(nodes)){
            //if(EMPTY(nodes)){return null;}
            Node node = REMOVE_FRONT(nodes);
            System.out.println(Node.result(node));
            System.out.println("THE GOAL NODE:");
            
            //System.out.println(Node.result(new Node (GOAL_TEST(finalProblem))));
            if (STATE(node) == GOAL_TEST(finalProblem) || currentDepth == 3){
                Path = new Lifo<Node>();
                //Path.build(node);
                //return Path.pathPrint();
                return Node.result(node);
            }
            Set<Node> new_nodes = EXPAND(node,OPERATORS());
            nodes = QUEUEING_FN.add(nodes,new_nodes);
        }
        return "solution not found";
    }
    
    //method implements iterative depth search
    private static Node ITERATIVE_DEEPENING_SEARCH(Problem problem){
        
       while(true){
       }
        
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
                //blank = s/numRows+1;
                blank = numRows-(s/numRows);
            }
            for(int h=position;h<problem.input.length;h++){
                //System.out.println(" checking: "+problem.input[s]+"against: "+problem.input[h]+"\n");
                if(problem.input[s]>problem.input[h] && problem.input[s]!=0 && problem.input[h]!=0){
                    inversions+=1;
                }
            }
            //System.out.println("the "+problem.input[s] +" gives us "+inversions+" inversions"+"\n");
            position+=1;
            totalInversions+=inversions;
        }
        //System.out.println("counter:"+totalInversions +" blank:"+blank+" numRows:"+numRows+"\n");
        if(((problem.input.length%2!=0 && totalInversions%2==0)) || ((problem.input.length%2==0) && ((blank%2==1) == (totalInversions%2==0)))){
            return true;
        }
        return false;
    }
    
    //method does a depth dependent search
    private static String DEPTH_LIMITED_SEARCH(Problem initial1, Problem final1, int depth){
        maxDepth = new Integer(depth);
        return GENERAL_SEARCH(initial1,final1, new Fifo());
        
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
        return node.STATE;
    }
    
    //method finds possible children of a node with all valid movements
    private static Set<Node> EXPAND(Node node,Set<Move> movements){
        Set<Node> childNodes = new HashSet<Node>();
        for(Move m:movements){
            if(Move.test(node.STATE, m)){
                State newState = Move.execute(node.STATE, m);
                Node newNode = new Node(node,newState,m,node.getDEPTH()+1,0);
                childNodes.add(newNode);
            }
            //Node newNode = new Node();
            
        }
        currentDepth = new Integer(node.getDEPTH()+1);
        return childNodes;
    }
    
    //returns the movements available
    private static Set<Move> OPERATORS(){
        return moves;
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
        return queue;
    }
    
    //
    private static boolean EMPTY(MyQueue<Node> nodes){
        if(nodes.size==0){return true;}
        return false;
    }
    
    private static Node REMOVE_FRONT(MyQueue<Node> nodes){
        Node node = null;
        if(nodes.size==0){return node;}
        System.out.println(nodes.type+"\n");
        switch(nodes.type){
            case "fifo":{
                Fifo fifo = (Fifo)nodes;
                System.out.println("Removing the following node");
                node = (Node)fifo.list.remove();
                fifo.size--;
                //System.out.println("queue current size:" +fifo.size);
                //System.out.println("REMOVED THE NODE: "+Node.result(node));
                break;
            }
            case "lifo":{
                Lifo lifo = (Lifo) nodes;
                node = (Node)lifo.list.pop();
                lifo.size--;
                System.out.println("queue current size:" +lifo.size);
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
