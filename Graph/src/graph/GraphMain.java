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
        
        Menu main = new Menu(0);
        Menu secondary = new Menu(1);
        Scanner in = new Scanner(System.in);
        boolean start = false;
        while(main.getChosenOption()==-1){
            main.printMenu();
            if(in.hasNext()){
                String input = in.next();
                try{
                    main.setChosenOption(Integer.parseInt(input),main);
                    if(main.getChosenOption()==-1){
                        System.out.println("Not an option, try again");
                    }
                }
                catch(Exception ex){
                    System.out.println("invalid input\n");
                }
            }
        }
        if(main.getChosenOption()==4){
            main.subMenu.printMenu();
            boolean choseFirst = false;
            boolean choseSecond = false;
            String result="",result1;
            while(!choseFirst){
                System.out.println("Initial State: ");
                if(in.hasNextLine()){
                    result = in.nextLine();
                    main.setInput(result);
                    choseFirst=true;
                }
            }
            while(!choseSecond){
                System.out.println("Final State: ");
                if(in.hasNextLine()){
                    result1 = in.nextLine();
                    main.setOutput(result1);
                    choseSecond = true;
                }
            }
        }
        while(secondary.getChosenOption()==-1){
            secondary.printMenu();
            if(in.hasNext()){
                String input = in.next();
                try{
                    secondary.setChosenOption(Integer.parseInt(input),null);
                    if(secondary.getChosenOption()==-1){
                        System.out.println("Not an option, try again");
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("invalid input\n");
                }
            }
        }
        System.out.println("Testing initial state: "+Menu.getInput()+"\n"+"and goal state: "
                +Menu.getOutput());
        System.out.println("Selected action: "+secondary.getOptionString());
        System.out.println("\nPress ENTER to start");
        in.nextLine();
        
        // TODO code application logic here
        /*String movement1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 0 15"; //solvable at depth 1
        String movement2 = "1 2 3 4 5 6 7 8 9 10 11 12 13 0 14 15"; //solvable at depth 2
        String movement3 = "1 2 3 4 5 6 7 8 9 0 11 12 13 10 14 15"; //solvable at depth 3
        String inicial1 = "12 1 10 2 7 11 4 14 5 0 9 15 8 13 6 3"; // this one is solvable
        String inicial2 = "1 2 3 4 13 6 8 12 5 9 0 7 14 11 10 15"; // this one is unsolvable
        String inicial3 = "1 2 3 4 5 6 7 8 9 10 11 12 13 1 4 15 0";
        
        /** testes enviados pela dutra**/
        
        /*String teste1 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15"; //solution at depth 4
        String final1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0"; 
        
        String teste2 = "9 12 0 7 14 5 13 2 6 1 4 8 10 15 3 11"; //solution at depth 13
        String final2 = "9 5 12 7 14 13 0 8 1 3 2 4 6 10 15 11";
        
        String teste3 = "6 12 0 9 14 2 5 11 7 8 4 13 3 10 1 15"; //solution at depth 8
        String final3 = "14 6 12 9 7 2 5 11 8 4 13 15 3 10 1 0";
        
        /** testes enviados pela dutra**/
        
        /*String teste4 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15";
        String teste5 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15";
        String final4 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0"; // this one is a final state
        //String teste = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15"; // this one is unsolvable
        String testeInput = teste1;
        String testeFinal = final1;
        Scanner in = new Scanner(System.in);
        int selectedOption=-1;
        int selectedOption2=-1;
        System.out.println("Select method to solve given puzzles");
        while(selectedOption==-1){
            System.out.println("1. Depth First Search");
            System.out.println("2. Breadth First Search");
            System.out.println("3. Limited Depth First Search");//Iterative Deepening Search");
            System.out.println("4. A*");
            System.out.println("5. Greedy");
            System.out.println("6. exit");
            //System.out.println("6. Checks manhatan distances of a problem");
            //System.out.println("7. Checks total distances of a problem");
            if(in.hasNext()){
                String option = in.next();
                try{
                    selectedOption = Integer.parseInt(option);
                    switch(selectedOption){
                        case 1:{
                            Algorithm.check_in_path=true;
                            System.out.println(Algorithm.GENERAL_SEARCH(new Problem(testeInput), new Problem(testeFinal), new Lifo()));
                            Algorithm.check_in_path=false;
                            break;
                        }
                        case 2:{
                            System.out.println(Algorithm.GENERAL_SEARCH(new Problem(testeInput), new Problem(testeFinal), new Fifo()));
                            break;
                        }
                        case 3:{
                            System.out.println(Algorithm.ITERATIVE_DEEPENING_SEARCH(new Problem(testeInput),new Problem(testeFinal)));
                            Algorithm.maxDepth=null;
                            break;
                        }
                        case 4:{
                            System.out.println("Not yet implemented");
                            //Algorithm.heuristic = new Heuristic();
                            //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
                            break;
                        }
                        case 5:{
                            System.out.println("Not yet implemented");
                            //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(movement1), new Problem(final1), new Fifo()));
                            break;
                        }
                        case 6:{
                              return;
                        }
                    }
                }
                catch(NumberFormatException exp){
                    System.out.println("Please insert a number between 1 and 5");
                }
            }
        }*/
    }
    
}
