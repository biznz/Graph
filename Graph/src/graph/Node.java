package graph;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Node implements Comparable<Node>{
    
    protected Node PARENT_NODE;
    protected State STATE;
    protected Move OPERATOR;
    protected int DEPTH;
    protected int PATH_COST;

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
        for(int i=0;i<puzzle.length;i++){
            for(int s=0;s<puzzle.length;s++){
                toPrint+=" "+puzzle[i][s];
                //System.out.println(" "+puzzle[i][s]);
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
    
    public String printMovement(){
        return this.OPERATOR.direction;
    }
    
    public int getDEPTH() {
        return DEPTH;
    }

    public int getPATH_COST() {
        return PATH_COST;
    }
    
    
    @Override
    public int compareTo(Node o) {
        System.out.println("Comparing Node: ");
        System.out.println(Node.result(this));
        System.out.println("With: ");
        System.out.println(Node.result(o));
        if(Arrays.deepEquals(this.STATE.getPuzzle(),o.STATE.getPuzzle())){
            return 0;
        }
        else if (Algorithm.heuristic!=null){
            int totalA=0;
            int totalB=0;
            for(Heuristic h: Algorithm.heuristic){
                totalA +=h.calculate(this.STATE);
                //System.out.println("cost "+totalA);
                totalB +=h.calculate(o.STATE);
                //System.out.println("cost "+totalB);
                //System.out.println("");
            }
            this.PATH_COST=totalA;
            o.PATH_COST=totalB;
            if(totalA<totalB){
                return -1;
            }
        }
        return 1;
    }
    
}
