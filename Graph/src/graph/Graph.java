
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Graph {
    private Set<Edge> E;
    private Set<Vertex> V;
    
    public Graph(){
        this.E = new HashSet<Edge>();
        this.V = new HashSet<Vertex>();
    }
    public Graph(HashSet<Edge> E,HashSet<Vertex> V){
        this.E = E;
        this.V = V;
    }
    
    private void addEdge(Edge E){
        this.E.add(E);
    }
    
    private void addVertex(Vertex V){
        this.V.add(V);
    }
    
    private int size(){
        return this.E.size();
    }
    
    private int order(){
        return this.V.size();
    }
    
}
