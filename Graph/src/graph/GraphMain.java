/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Scanner;

/**
 *
 * @author up200506204
 */


public class GraphMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String teste = "12 1 10 2 7 11 4 14 5 0 9 15 8 13 6 3";
        Scanner in = new Scanner(System.in);
        int i=0;
        while(i<15){
        in.nextInt();
        i++;}
        Problem problem = new Problem(teste);
        //Algorithm.checkSolvable(problem);
    }
    
}
