
package graph;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Tree {
    
    public Node root;
    public Tree[] children;

    public Tree(Node root) {
        this.root = root;
    }
    
    /*
    public void setChildren(Set<Node> expanded){
    	int s = 0;
    	for(Node n : expanded){
    		this.children[s] = new Tree(n);
    		s++;
    	}
    }

    public Tree[] getChildren(){
    	return this.children;
    }*/
}
