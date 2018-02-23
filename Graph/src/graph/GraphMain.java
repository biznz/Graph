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
        String movement2 = "1 2 3 4 5 6 7 8 9 10 0 12 13 14 11 15";
        String inicial1 = "12 1 10 2 7 11 4 14 5 0 9 15 8 13 6 3"; // this one is solvable
        String inicial2 = "1 2 3 4 13 6 8 12 5 9 0 7 14 11 10 15"; // this one is unsolvable
        String inicial3 = "1 2 3 4 5 6 7 8 9 10 11 12 13 1 4 15 0";
        String final1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0"; // this one is a final state
        //String teste = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15"; // this one is unsolvable
        String input1 = movement2;
        Scanner in = new Scanner(System.in);
        int selectedOption=-1;
        System.out.println("Select method to solve given puzzles");
        while(selectedOption==-1){
            System.out.println("1. Depth First Search");
            System.out.println("2. Breadth First Search");
            System.out.println("3. Iterative Deepening Search");
            System.out.println("4. A* ");
            System.out.println("5. Greedy\n");
            if(in.hasNext()){
                String option = in.next();
                try{
                    selectedOption = Integer.parseInt(option);
                }
                catch(NumberFormatException exp){
                    System.out.println("Please insert a number between 1 and 5");
                }
            }
        }
        switch(selectedOption){
            case 1:{
                System.out.println(Algorithm.GENERAL_SEARCH(new Problem(input1), new Problem(final1), new Lifo()));
                break;
            }
            case 2:{
                System.out.println(Algorithm.GENERAL_SEARCH(new Problem(input1), new Problem(final1), new Fifo()));
                break;
            }
            case 3:{
                System.out.println("Not yet implemented");
                //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
                break;
            }
            case 4:{
                System.out.println("Not yet implemented");
                //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
                break;
            }
            case 5:{
                System.out.println("Not yet implemented");
                //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
                break;
            }
        }
        //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
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
