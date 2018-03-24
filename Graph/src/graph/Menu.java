/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author b1z
 */
public class Menu {
    protected TreeMap<Integer,String> options;
    private int lvl;
    private int chosenOption;
    protected Menu subMenu;
    private String message="Select one of the following options\n";
    private static String option1="Depth First Search";
    private static String option2="Breadth First Search";
    private static String option3="Iterative Deepening Depth-First Search";
    private static String option4="A*";
    private static String option5="Greedy";
    private static String option6="Check if input is Solvable";
    private static String option7="exit";
    
    private static String input;
    private static String output;
    /** testes enviados pela dutra**/
    
    private HashMap<String,String> puzzles;
    private String teste1 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15"; //solution at depth 4
    private String final1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0";
    
    private String teste2 = "9 12 0 7 14 5 13 2 6 1 4 8 10 15 3 11"; //solution at depth 13
    private String final2 = "9 5 12 7 14 13 0 8 1 3 2 4 6 10 15 11";
    
    private String teste3 = "6 12 0 9 14 2 5 11 7 8 4 13 3 10 1 15"; //solution at depth 8
    private String final3 = "14 6 12 9 7 2 5 11 8 4 13 15 3 10 1 0";
    
    private String teste4 = "1 2 3 4 5 6 7 0 9 10 11 8 13 14 15 12"; //solution at depth 2
    private String final4 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0";
    
    private String depthLimit1="depth limit 15";
    private String depthLimit2="depth limit 20";
    private String depthLimit3="depth limit 30";
    private String depthLimit4="depth limit 40";
        
    /** testes enviados pela dutra**/
    
    /*private String teste4 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15";
    private String teste5 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15";
    private String final4 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0";*/
    
    
    
    public Menu(int level){
        options = new TreeMap<Integer,String>();
        this.lvl = level;
        switch(level){
            case 0:{
                puzzles = new HashMap<String,String>();
                puzzles.put("teste1", teste1);
                puzzles.put("final1", final1);
                puzzles.put("teste2", teste2);
                puzzles.put("final2", final2);
                puzzles.put("teste3", teste3);
                puzzles.put("final3", final3);
                puzzles.put("teste4", teste4);
                puzzles.put("final4", final4);
                options.put(1,"["+teste1+"]  solution at depth 4"+"\n   ["+final1+"]\n");
                options.put(2,"["+teste2+"] solution at depth 13"+"\n   ["+final2+"]\n");
                options.put(3,"["+teste3+"] solution at depth 8"+"\n   ["+final3+"]\n");
                options.put(4,"["+teste4+"] solution at depth 2"+"\n   ["+final4+"]\n");
                options.put(options.size()+1,"Insert a new puzzle and goal");
                options.put(options.size()+1, "exit");
                this.message = "Select a puzzle and goal state, or, give it your own puzzle \n";
                break;
            }
            case 1:{
                options.put(1, option1);
                options.put(2, option2);
                options.put(3, option3);
                options.put(4, option4);
                options.put(5, option5);
                options.put(6, option6);
                options.put(7, option7);
                this.message = "Select one of the following options\n";
                break;
            }
            case 2:{
                this.message = "Introduce puzzle initial state and goal state\n";
                break;
            }
            case 3:{
                this.message = "Please insert a depth limit";
                options.put(1,depthLimit1);
                options.put(2,depthLimit2);
                options.put(3,depthLimit3);
                options.put(4,depthLimit4);
                break;
            }
            
        }
        chosenOption=-1;
        subMenu = null;
    }
    
    public void insertNewPuzzle(String input,String goal){
        //this.puzzles.put(input, goal);
        //this.options.put(this.options.size(), input+"\n"+goal);
    }

    public void setChosenOption(int chosenOption,Menu menu) {
        if(this.options.keySet().contains(chosenOption)){
            this.chosenOption = chosenOption;
        }
        //System.out.println("Chosen the following option "+chosenOption);
        if(this.lvl==0){
            this.subMenu= new Menu(2);
            if(chosenOption!=this.options.size()-1){
                this.setInput(menu.puzzles.get("teste"+chosenOption));
                this.setOutput(menu.puzzles.get("final"+chosenOption));
            }
        }
    }
    
    public void setInput(String a){
        input = a;
    }
    
    public void setOutput(String b){
        output = b;
    }
    
    public static String getInput(){
        return input;
    }
    
    public static String getOutput(){
        return output;
    }
    
    public int getChosenOption() {
        return chosenOption;
    }
    
    public String getOptionString(){
        return this.options.get(this.chosenOption);
    }
    
    public void printMenu(){
        System.out.println(this.message);
        String result="";
        for(Integer t :this.options.keySet()){
            result+=t+". "+this.options.get(t)+"\n";
        }
        System.out.println(result);
    }
}
