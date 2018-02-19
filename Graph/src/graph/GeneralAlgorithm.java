/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Queue;
import java.util.Set;

/**
 *
 * @author user
 */
public class GeneralAlgorithm {
    
    //private State finalState;
    //private Node Initial;
    
    private static Node GeneralSearch(Problem problem, MyQueue<Node> QUEUEING_FN){
        MyQueue<Node> nodes = MAKE_QUEUE(MAKE_NODE(INITIAL_STATE(problem)));
        while(true){
            if(EMPTY(nodes)){return null;}
            Node node = REMOVE_FRONT(nodes);
            if (STATE(node) == GOAL_TEST(problem)) return node;
            Set<Node> new_nodes = EXPAND(node,OPERATORS(problem));
            nodes = QUEUEING_FN.add(nodes,new_nodes);
        }
        
    }
    
    private static State STATE(Node node){
        return node.STATE;
    }
    
    private static Set<Node> EXPAND(Node node,Set<Move> movements){
        return null;
    }
    
    private static Set<Move> OPERATORS(Problem problem){
        return null;
    }
            
    private static Node MAKE_NODE(State state){
        return new Node(state);
    }
    
    private static MyQueue<Node> MAKE_QUEUE(Node node){
        return new MyQueue<Node>(){};
    }
    
    private static boolean EMPTY(MyQueue<Node> nodes){
        //if(nodes.)
        return false;
    }
    
    private static Node REMOVE_FRONT(MyQueue<Node> nodes){
        return null;
    }
    
    private static State GOAL_TEST(Problem problem){
        return null;
    }

    private static State INITIAL_STATE(Problem problem) {
        return new State(problem);
    }
    
    //private Set<Node> EXPAND(node,)
}
