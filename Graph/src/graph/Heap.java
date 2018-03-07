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
    
    Set<Heuristic> heuristics;
    PriorityQueue list;
    
    public Heap(){
        super();
        list = new PriorityQueue();
        super.type = "heap";
        super.size = 0;
        this.heuristics=null;
        super.maxSize = 0;
    }

    Heap(Set<Heuristic> heuristics) {
        super();
        list = new PriorityQueue();
        super.type = "heap";
        super.size = 0;
        this.heuristics=heuristics;
    }
    
    @Override
    public Heap add(MyQueue<Node> queue, Set<Node> nodes) {
        Heap heap = (Heap)queue;
        if(nodes==null){return heap;}
        for(Node n: nodes){
            heap.add(queue, n);
        }
        return heap;
    }

    @Override
    public Heap add(MyQueue<Node> queue,Node node){
        Heap heap = (Heap) queue;
        if(node==null){return heap;}
        //System.out.append(Algorithm.heuristic.size()+" num of heuristics");
        for(Heuristic h: Algorithm.heuristic){
            if(!h.type.equals("pathcost")){
                node.setPATH_COST(node.DEPTH+h.calculate(node.STATE));
                System.out.println("manhatan distance"+h.calculate(node.STATE));
            }
        }
        System.out.println("node depth: "+node.DEPTH);
        //System.out.println("value: "+node.DEPTH);
        System.out.println("node total cost: "+node.PATH_COST);
        heap.list.add(node);
        super.size+=1;
        if(super.size>super.maxSize){
            super.maxSize=super.size;}
        return heap;
    }
    
    @Override
    public String toString(){
        System.out.println("printing queue\n");
        String result ="";
        for(Object obj:this.list){
            Node node = (Node)obj;
            result+= Node.result(node);
            result+="\ncost:"+node.PATH_COST+"\n";
        }
        return result;
    }
    
}
