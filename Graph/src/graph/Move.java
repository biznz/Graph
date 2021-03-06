package graph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author b1z
 */

public class Move {
    public String direction;
    
    public Move(String direction){
        this.direction = direction;
    }
    
    public static boolean test(State state,Move move){
        //System.out.println(" blank index X:"+state.getxBlankIndex());
        //System.out.println(" blank index Y:"+state.getyBlankIndex());
        switch(move.direction){
            case "down":{
                if (state.getxBlankIndex()+1>=state.getPuzzle().length){return false;}
                break;
            }
            case "up":{
                if (state.getxBlankIndex()-1<0){return false;}
                break;
            }
            case "left":{
                if (state.getyBlankIndex()-1<0){return false;}
                break;
            }
            case "right":{
                if (state.getyBlankIndex()+1>=state.getPuzzle().length){return false;}
                break;
            }
        }
        return true;
    }
    
    public static State execute(State state,Move move){
        State newState = state;
        int tempVal,x,y;
        x = state.getxBlankIndex();
        y = state.getyBlankIndex();
        newState.setPuzzle(state.getPuzzle());
        if(!test(state,move)){return null;}
        switch(move.direction){
            case "down":{
                //if (state.getxBlankIndex()-1<0){return null;}
                tempVal = state.getPuzzle()[x+1][y];
                newState.getPuzzle()[x+1][y]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x+1);
                newState.setyBlankIndex(y);
                break;
            }
            case "up":{
                tempVal = state.getPuzzle()[x-1][y];
                newState.getPuzzle()[x-1][y]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x-1);
                newState.setyBlankIndex(y);
                break;
            }
            case "left":{
                //if (state.getyBlankIndex()-1<0){return null;}
                tempVal = state.getPuzzle()[x][y-1];
                newState.getPuzzle()[x][y-1]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x);
                newState.setyBlankIndex(y-1);
                break;
            }
            case "right":{
                //if (state.getyBlankIndex()+1>=state.getPuzzle().length){return null;}
                tempVal = state.getPuzzle()[x][y+1];
                newState.getPuzzle()[x][y+1]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x);
                newState.setyBlankIndex(y+1);
                break;
            }
        }
        return newState;
    }
    
}
