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
    
    public Lifo(){
        super();
        list = new Stack<>();
    }
    @Override
    public Lifo add(MyQueue<T> queue, Set<T> nodes) {
        this.list = queue.list;
        for(T n: nodes){
            this.list.push(n);
        }
        return this;
    }
}
