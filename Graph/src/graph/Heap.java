/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author up200506204
 */
public class Heap<T> extends MyQueue<T> {
    
    PriorityQueue list;
    
    public Heap(){
        super();
        list = new PriorityQueue();
        super.type = "heap";
        super.size = 0;
    }
    
    @Override
    public Heap add(MyQueue<Node> queue, Set<Node> nodes) {
        Heap heap = (Heap)queue;
        if(nodes==null){return heap;}
        for(Node n: nodes){
            heap.list.add(n);
            super.size+=nodes.size();
        }
        return heap;
    }

    @Override
    public Heap add(MyQueue<Node> queue,Node node){
        Heap heap = (Heap) queue;
        if(node==null){return heap;}
        heap.list.add(node);
        super.size+=1;
        return heap;
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
    
}
