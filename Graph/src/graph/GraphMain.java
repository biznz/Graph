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
        
        /** testes enviados pela dutra**/
        
        String teste1 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15"; //solution at depth 4
        String final1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0"; 
        
        String teste2 = "9 12 0 7 14 5 13 2 6 1 4 8 10 15 3 11"; //solution at depth 13
        String final2 = "9 5 12 7 14 13 0 8 1 3 2 4 6 10 15 11";
        
        String teste3 = "6 12 0 9 14 2 5 11 7 8 4 13 3 10 1 15"; //solution at depth 8
        String final3 = "14 6 12 9 7 2 5 11 8 4 13 15 3 10 1 0";
        
        /** testes enviados pela dutra**/
        
        String teste4 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15";
        String teste5 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15";
        String final4 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0"; // this one is a final state
        //String teste = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15"; // this one is unsolvable
        String input1=teste1;
        Scanner in = new Scanner(System.in);
        int selectedOption=-1;
        System.out.println("Select method to solve given puzzles");
        while(selectedOption==-1){
            System.out.println("1. Depth First Search");
            System.out.println("2. Breadth First Search");
            System.out.println("3. Limited Depth First Search");//Iterative Deepening Search");
            System.out.println("4. A* ");
            System.out.println("5. Greedy ");
            //System.out.println("6. Checks manhatan distances of a problem");
            //System.out.println("7. Checks total distances of a problem");
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
                //System.out.println("Not yet implemented");
                System.out.println(Algorithm.ITERATIVE_DEEPENING_SEARCH(new Problem(input1),new Problem(final1)));
                //System.out.println(Algorithm.DEPTH_LIMITED_SEARCH(new Problem(input1), new Problem(final1), 1));
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
            /*case 6:{
                State newState = new State(new Problem(input1));
                System.out.println("manhatan distances of a problem "+Algorithm.manhatan_distances(newState));
                //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
                break;
            }
            case 7:{
                State newState = new State(new Problem(input1));
                System.out.println("total distances of a problem "+Algorithm.total_pieces_displaced(newState));
                //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
                break;
            }*/
            
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
