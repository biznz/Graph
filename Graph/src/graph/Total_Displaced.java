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
public class Total_Displaced extends Heuristic{

    public Total_Displaced() {
        super();
        super.type = "displaced";
    }
    
    @Override
    int calculate(State state) {
        int total_displaced=0;
        int displaced=0;
        int indexes[] = new int[2];
        for(int h=0;h<state.getPuzzle().length;h++){
            displaced = 0;
            for(int s=0;s<state.getPuzzle().length;s++){
                if(state.getPuzzle()[h][s]!=Algorithm.base15Matrix[h][s] && state.getPuzzle()[h][s]!=0){
                    displaced+=1;
                }
            }
            total_displaced+=displaced;
        }
        return total_displaced;
    }
    
}
