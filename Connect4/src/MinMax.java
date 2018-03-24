
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author b1z
 */
public class MinMax {
    //the algorithm generates all descendants
    // problemas de busca nao é sabido onde esta a soluçao
    // recursao rebenta pilhas
    
    //a maior profundidade maior a probabilidade de ter resultados
    // adversarial search nao procura soluçao
    public static int negativeInf = (int)Double.NEGATIVE_INFINITY;
    public static int positiveInf = (int)Double.POSITIVE_INFINITY;
    private static int[] win = {1,positiveInf};
    private static int[] defeat = {-1,negativeInf};
    private static int depthLimit;
    
    public static Move MINMAX_DECISION(State state){
        int v = MAX_VALUE(state);
        return getMove(v, state);
    }
    
    public static int MAX_VALUE(State state){
        //System.out.println("testing max value for"+ state);
        if(TERMINAL_TEST(state)){
            //System.out.println("Found a terminal state on min\n:"+state);
            return UTILITY(state);
        }
        if(SUCCESSOR(state).size()==0){
            return UTILITY(state);
        }
        int v = negativeInf;
        for(State s:SUCCESSOR(state)){
            v = Math.max(v, MIN_VALUE(s));
        }
        return v;
    }
    
    public static int MIN_VALUE(State state){
        //System.out.println("testing min value for"+ state);
        if(TERMINAL_TEST(state)){
            //System.out.println("Found a terminal state on min\n:"+state);
            return UTILITY(state);
        }
        if(SUCCESSOR(state).size()==0){
            return UTILITY(state);
        }
        int v = positiveInf;
        for(State s:SUCCESSOR(state)){
            v = Math.min(v, MAX_VALUE(s));
        }
        return v;
    }
    
    public static boolean TERMINAL_TEST(State state){
        if(state.isFull())return true;
        
        return false;
    }
    
    public static Set<State> SUCCESSOR(State state){
        return null;
    }
    
    public static int UTILITY(State state){
        return -1;
    }
    
    public static Move getMove(int v,State state){
        return null;
    }
}
