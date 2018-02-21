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
public class Node implements AbstractNode{
    
    private Node PARENT_NODE;
    public State STATE;
    private Move OPERATOR;
    private int DEPTH;
    private int PATH_COST;

    public Node(State state) {
        this.STATE = state;
        this.PARENT_NODE = null;
        this.OPERATOR = null;
        this.DEPTH = 0;
        this.PATH_COST = 0;
    }
    
    public Node(Node parent, State state, Move move, int depth, int cost) {
        this.PARENT_NODE = parent;
        this.STATE = state;
        this.OPERATOR = move;
        this.DEPTH = depth;
        this.PATH_COST = cost;
    }
    
    public static String result(Node node){
        int[][] puzzle = node.STATE.getPuzzle();
        String toPrint ="";
        for(int i=0;i<puzzle[i].length;i++){
            for(int s=0;s<puzzle[s].length;s++){
                toPrint+=" "+puzzle[i][s];
            }
            toPrint+="\n";
        }
        return toPrint;
    }

    public Node getPARENT_NODE() {
        return PARENT_NODE;
    }

    public State getSTATE() {
        return STATE;
    }

    public Move getOPERATOR() {
        return OPERATOR;
    }

    public int getDEPTH() {
        return DEPTH;
    }

    public int getPATH_COST() {
        return PATH_COST;
    }
    
    
}
