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
    private LinkedList list;
    
    public Fifo(){
        super();
        list = new LinkedList();
    }
    @Override
    public Fifo add(MyQueue<T> queue, Set<T> nodes) {
        Fifo fifo = (Fifo)queue;
        fifo.list.addAll(nodes);
        return fifo;
    }
}
