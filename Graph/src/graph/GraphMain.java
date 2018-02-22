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
        String movement1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 0 15";
        String inicial1 = "12 1 10 2 7 11 4 14 5 0 9 15 8 13 6 3"; // this one is solvable
        String inicial2 = "1 2 3 4 13 6 8 12 5 9 0 7 14 11 10 15"; // this one is unsolvable
        String inicial3 = "1 2 3 4 5 6 7 8 9 10 11 12 13 1 4 15 0";
        String final1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0"; // this one is a final state
        //String teste = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15"; // this one is unsolvable
        System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
        /*Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String line = in.nextLine();
            Problem problem = new Problem(movement1);
            System.out.println("Solvable?: "+Algorithm.checkSolvable(problem));
            if(line.equals("")){break;}
        }
        in.close();*/
    }
    
}
