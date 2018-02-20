/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author user
 */
public class Fifo<T> extends MyQueue<T>{
    LinkedList list;
    public Fifo(){
        super();
        this.list = new LinkedList();
    }
    @Override
    public Fifo add(MyQueue<Node> queue, Set<Node> nodes) {
        //Fifo fifo = (Fifo)queue;
        this.list.addAll(queue.list);
        this.list.addAll(nodes);
        return this;
    }
}
