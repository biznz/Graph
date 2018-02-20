/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Queue;
import java.util.Set;
import java.lang.Math;
/**
 *
 * @author user
 */
public class Algorithm {
    
    static Integer maxDepth=null;
    static Integer currentDepth;
    static Tree tree;
    //private State finalState;
    //private Node Initial;
    
    //Heap min para busca informada
    
    /*
    private static String GENERAL_SEARCH(Problem initialProblem,Problem finalProblem, MyQueue<Node> QUEUEING_FN){
        if(!SOLVABLE(initialProblem,finalProblem)){return "It is impossible to reach a solution" ;}
        MyQueue<Node> nodes = MAKE_QUEUE(MAKE_NODE(INITIAL_STATE(initialProblem)));
        while(!EMPTY(nodes)){
            //if(EMPTY(nodes)){return null;}
            Node node = REMOVE_FRONT(nodes);
            if (STATE(node) == GOAL_TEST(finalProblem)) return Node.result(node);
            Set<Node> new_nodes = EXPAND(node,OPERATORS(finalProblem));
            nodes = QUEUEING_FN.add(nodes,new_nodes);
        }
        return "solution not found";
    }
    
    /*private static Node ITERATIVE_DEEPENING_SEARCH(Problem problem){
        
       while(true){
       }
        
    }*/
    
    private static boolean SOLVABLE(Problem initialProblem, Problem finalProblem){
        if(checkSolvable(initialProblem) && checkSolvable(finalProblem)){return true;}
        return false;
    }
    
    public static boolean checkSolvable(Problem problem){
        int counter=0;
        int blank=-1;
        int numRows = (int) Math.sqrt(problem.input.length);
        for(int s=0;s<problem.input.length;s++){
            if(problem.input[s]==0){
                blank = s/numRows+1;
            }
            for(int h=0;h<problem.input.length;h++)
                if(problem.input[s]>problem.input[h]){
                    counter+=1;
                }
        }
        System.out.println(" counter:"+counter +" blank:"+blank+" numRows:"+numRows+"\n");
        if(((problem.input.length%2!=0 && counter%2==0)) || ((problem.input.length%2==0) && ((blank%2==1) == (counter%2==0)))){
            return true;
        }
        return false;
    }
    
    /*private static Node DEPTH_LIMITED_SEARCH(Problem problem, int depth){
        maxDepth = new Integer(depth);
        return GENERAL_SEARCH(problem, new Fifo());
        
    }
    
    private static Node BEST_FIRST_SEARCH(Problem problem, Eval EVAL_FN){
        MyQueue<Node> queue = EVAL_FN.run(problem);
        return GENERAL_SEARCH(problem,queue);
    }
    
    private static Node GREEDY_SEARCH(Problem problem){
        return BEST_FIRST_SEARCH(problem,null);
    }*/
    
    private static State STATE(Node node){
        return node.STATE;
    }
    
    private static Set<Node> EXPAND(Node node,Set<Move> movements){
        currentDepth = new Integer(currentDepth.intValue()+1);
        return null;
    }
    
    private static Set<Move> OPERATORS(Problem problem){
        return null;
    }
            
    private static Node MAKE_NODE(State state){
        Node node = new Node(state);
        tree = new Tree(node);
        return node;
    }
    /*
    private static MyQueue<Node> MAKE_QUEUE(Node node){
        MyQueue<Node> myQueue = new MyQueue<Node>();
        myQueue.add(node); 
        return myQueue;
    }
    
    /*private static boolean EMPTY(MyQueue<Node> nodes){
        if(nodes.size==0){return true;}
        return false;
    }
    
    private static Node REMOVE_FRONT(MyQueue<Node> nodes){
        Node node = nodes.remove(0);
        return node;
    }*/
    
    private static State GOAL_TEST(Problem problem){
        return new State(problem);
    }

    private static State INITIAL_STATE(Problem problem) {
        return new State(problem);
    }
    
    //private Set<Node> EXPAND(node,)
}
