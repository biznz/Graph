/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Arrays;

/**
 *
 * @author b1z
 */
public class State {
    
    private int[][] puzzle;
    private int xBlankIndex;
    private int yBlankIndex;
    
    public State(Problem problem) {
        int s = (puzzle.length+1)%4;
        for(int i=0;i<s;i++){
            for(int h=0;h<s;h++){
                if(problem.input[i*s+h] == 0){
                    this.xBlankIndex = h;
                    this.xBlankIndex = i;
                }
                this.puzzle[h][i] = problem.input[i*s+h];
            }
        }
    }

    public int[][] getPuzzle() {
        return puzzle;
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
