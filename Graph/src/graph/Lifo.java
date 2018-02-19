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
    private Stack<T> list;
    
    public Lifo(){
        super();
        list = new Stack<T>();
    }
    @Override
    public Lifo add(MyQueue<T> queue, Set<T> nodes) {
        Lifo lifo = (Lifo)queue;
        for(T n: nodes){
            lifo.list.push(n);
        }
        return lifo;
    }
}