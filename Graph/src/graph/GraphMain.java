/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set; 

/**
 *
 * @author up200506204
 */


public class GraphMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Node aa = new Node(new State(new Problem("1 2 3 4 5 6 7 8 9 10 11 12 13 14 0 15")));
        Node b = new Node(new State(new Problem("1 2 3 4 5 6 7 8 9 10 11 12 13 0 14 15")));
        Algorithm.heuristic = new HashSet<Heuristic>();
        Algorithm.heuristic.add(new Total_Displaced());
        System.out.println("comaparing"+aa.compareTo(b));*/
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
        if(main.getChosenOption()==main.options.size()){return ;}
        if(main.getChosenOption()==main.options.size()-1){
            main.subMenu.printMenu();
            boolean choseFirst = false;
            boolean choseSecond = false;
            String result="",result1;
            while(!choseFirst){
                //System.out.println("Initial State: ");
                if(in.hasNextLine()){
                    System.out.print("Initial State: "+in.nextLine());
                    result = in.nextLine();
                    main.setInput(result);
                    choseFirst=true;
                }
            }
            while(!choseSecond){
                //System.out.println("Final State: ");
                if(in.hasNextLine()){
                    System.out.print("Final State: "+in.nextLine());
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
                    if(secondary.getChosenOption()==secondary.options.size()){
                        return;
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("invalid input\n");
                }
            }
        }
        if(secondary.getChosenOption()==1){
            Menu menu = new Menu(3);
            menu.printMenu();
            if(in.hasNext()){
                String input = in.next();
                try{
                    menu.setChosenOption(Integer.parseInt(input), null);
                    if(menu.getChosenOption()==-1){
                        System.out.println("not an option, try again");
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("invalid input");
                }
            }
            
        }
        System.out.println("Testing initial state: "+Menu.getInput()+"\n"+"and goal state: "
                +Menu.getOutput());
        System.out.println("Selected action: "+secondary.getOptionString());
        System.out.println("\nInsert 0 to start");
        while(!start){
            String a = in.next();
            if(a.equals("0")){
                start=true;
            }
        }
        switch(secondary.getChosenOption()){
            case 1:{
                Algorithm.check_in_path=true;
                //Algorithm.maxDepth=5;
                System.out.println(Algorithm.GENERAL_SEARCH(new Problem(Menu.getInput()),
                        new Problem(Menu.getOutput()), new Lifo()));
                Algorithm.clearSettings();
                break;
            }
            case 2:{
                System.out.println(Algorithm.GENERAL_SEARCH(new Problem(Menu.getInput()),
                        new Problem(Menu.getOutput()), new Fifo()));
                Algorithm.clearSettings();
                break;
            }
            case 3:{
                System.out.println(Algorithm.ITERATIVE_DEEPENING_SEARCH(new Problem(Menu.getInput()),
                        new Problem(Menu.getOutput())));
                Algorithm.clearSettings();
                break;
            }
            case 4:{
                //System.out.println("Not yet implemented");
                //Algorithm.heuristic = new Heuristic();
                //System.out.println("manhatan distance is "+a.calculate(new State(new Problem(Menu.getInput()))));
                //System.out.println("total displaced is "+b.calculate(new State(new Problem(Menu.getInput()))));
                Algorithm.check_in_path=true;
                System.out.println(Algorithm.A_STAR_SEARCH(new Problem(Menu.getInput()), new Problem(Menu.getOutput())));
                Algorithm.clearSettings();
                //Algorithm.check_in_path=false;
                //System.out.println(Algorithm.GENERAL_SEARCH(new Problem(Menu.getInput()), new Problem(Menu.getOutput()), new Heap()));
                break;
            }
            case 5:{
                System.out.println(Algorithm.GREEDY_SEARCH(new Problem(Menu.getInput()), new Problem(Menu.getOutput())));
                Algorithm.clearSettings();
                break;
            }
            case 6:{
                System.out.println("Solvable: "+Algorithm.SOLVABLE(new Problem(Menu.getInput()), new Problem(Menu.getOutput())));
                Algorithm.clearSettings();
                break;
            }
            case 7:{
                break;
            }
            
        }
    }
    
}
