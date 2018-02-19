package graph;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Node implements Abstract_Node{
    
    private Node parent;
    private State state;
    private Move move;
    private int depth;
    private int cost;

    public Node(Node parent, State state, Move move, int depth, int cost) {
        this.parent = parent;
        this.state = state;
        this.move = move;
        this.depth = depth;
        this.cost = cost;
    }
    
    
}
