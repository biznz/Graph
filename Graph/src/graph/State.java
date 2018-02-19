/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author b1z
 */
public class State {
    
    private int[][] puzzle;
    
    public State(Problem problem) {
        int s = (puzzle.length+1)%4;
        for(int i=0;i<s;i++){
            for(int h=0;h<s;h++){
                this.puzzle[h][i] = problem.input[i*s+h];
            }
        }
    }

    public int[][] getPuzzle() {
        return puzzle;
    }
    
}
