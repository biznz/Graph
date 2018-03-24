package graph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;

/**
 *
 * @author b1z
 */
public class State{
    
    private int[][] puzzle;
    private int xBlankIndex;
    private int yBlankIndex;
    
    
    public State(int[][] puzzle){
        int size = puzzle.length;
        this.puzzle = new int[size][size];
        int s = (puzzle.length+1)%4;
        for(int i=0;i<size;i++){
            for(int h=0;h<size;h++){
                if(puzzle[i][h] == 0){
                    this.xBlankIndex = i;
                    this.yBlankIndex = h;
                }
                this.puzzle[i][h] = puzzle[i][h];//problem.input[i*s+h];
            }
        }
    }
    
    public String printPuzzle(){
        String result="";
        for(int i=0;i<this.puzzle.length;i++){
            for( int s=0;s<this.puzzle.length;s++){
                result+=this.puzzle[i][s]+" ";
                if(s+1==this.puzzle.length){
                    result+="\n";
                }
            }
        }
        return result;
    }
    
    
    public State(Problem problem) {
        int size = (int)Math.sqrt(problem.input.length);
        this.puzzle = new int[size][size];
        int counter=0;
        int s = (puzzle.length+1)%4;
        for(int i=0;i<size;i++){
            for(int h=0;h<size;h++){
                if(problem.input[counter] == 0){
                    this.xBlankIndex = i;
                    this.yBlankIndex = h;
                }
                this.puzzle[i][h] = problem.input[counter];//problem.input[i*s+h];
                counter++;
            }
        }
    }

    public int[] getpiecePos(int piece){
        int result[] = new int[2];
        int size = this.getPuzzle().length;
        //System.out.println("  \n\n"+this.printPuzzle());
        for(int i=0;i<size;i++){
            for(int h=0;h<size;h++){
                if(piece==Algorithm.base15Matrix[i][h]){
                    //System.out.println("checking puzzle piece: "+piece);
                    //System.out.println("index x is: "+i+" index y is: "+h);
                    result[0]=i;
                    result[1]=h;
                }
            }
        }
        return result;
    }
    
    public void setxBlankIndex(int xBlankIndex) {
        this.xBlankIndex = xBlankIndex;
    }

    public void setyBlankIndex(int yBlankIndex) {
        this.yBlankIndex = yBlankIndex;
    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }
    
    public int[][] getPuzzle() {
        //System.out.println("puzzle length: "+puzzle.length+"\n");
        return puzzle;
    }

    public int getxBlankIndex() {
        return xBlankIndex;
    }

    public int getyBlankIndex() {
        return yBlankIndex;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Arrays.deepHashCode(this.puzzle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (!Arrays.deepEquals(this.puzzle, other.puzzle)) {
            return false;
        }
        return true;
    }

    
    
}
