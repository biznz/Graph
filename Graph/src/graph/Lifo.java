/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author user
 */
public class Lifo<T> extends MyQueue<T>{
    
    /** TODO **
    Confirm if I should be using a stack or dequeue
    need to remove element from the front of a list
    fifo vs lifo
    **/
    Stack list; 

    public Lifo(){
        super();
        list = new Stack<>();
        super.type = "lifo";
        super.size = 0;
    }
    @Override
    public Lifo add(MyQueue<Node> queue, Set<Node> nodes) {
        Lifo lifo = (Lifo)queue;
        if(nodes==null){return lifo;}
        for(Node n: nodes){
            lifo.list.push(n);
            super.size+=1;
        }
        return lifo;
    }

    @Override
    public Lifo add(MyQueue<Node> queue,Node node){
        Lifo lifo = (Lifo) queue;
        if(node==null){return lifo;}
        lifo.list.push(node);
        super.size+=1;
        return lifo;
    }
    
    @Override
    public String toString(){
        System.out.println("printing queue\n");
        String result ="";
        for(Object obj:this.list){
            Node node = (Node)obj;
            result+= Node.result(node);
            result+="\n\n";
        }
        return result;
    }
    //method builds resulting path from search algorithm output
    public Lifo build(Node current){
        if(current!=null){
            this.list.push(current);
            return build(current.getPARENT_NODE());
        }
        return this;
    }
    
    public String pathPrint(){
        String result = "";
        while(this.list.size()!=0){
            Node node =(Node)this.list.pop();
            if(node.OPERATOR!=null){
                result+="move to: ";
                result+=node.printMovement()+"\n\n";
            }
            else{
                result+="Printing movements made \n\n";
            }
            result+=Node.result(node)+"\n";
        }
        return result;
    }
}
