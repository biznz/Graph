/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author user
 */
public class Problem {
    
    public int[] input;
    
    public Problem(String input){
        String[] parts = input.split(" ");
        for(int i=0;i<parts.length;i++){
            this.input[i] = Integer.parseInt(parts[i]);
        }
    }
    public int[] getInput(){
        return this.input;
    }
}
