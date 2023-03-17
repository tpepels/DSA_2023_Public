package tutorial_5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListGraph<T> implements Graph<T> {

    HashMap<T, List<EdgeNode<T>>> verteces;

    public AdjacencyListGraph(){
        verteces = new HashMap<T, List<EdgeNode<T>>>();
    }

    @Override
    public boolean adjacent(T x, T y) {
        if(!verteces.containsKey(x)){
            System.out.println("The vertex " + x + " is not in the Graph.");
            return false;
        }else if(!verteces.containsKey(y)){
            System.out.println("The vertex " + y + " is not in the Graph.");
            return false;
        }else{
            List<EdgeNode<T>> adjList = verteces.get(x);
            return adjList.contains(new EdgeNode<T>(y, 0));
        }
    }

    @Override
    public List<T> neighbors(T x) {
        List<T> neighboursElements = new LinkedList<T>();
        if(!verteces.containsKey(x)){
            System.out.println("The vertex " + x + " is not in the Graph.");
        }else{
            List<EdgeNode<T>> adjList = verteces.get(x);
            for(EdgeNode<T> edge : adjList){
                neighboursElements.add(edge.getElement());
            }
        }
        return neighboursElements;
    }

    @Override
    public void addVertex(T x) {
        if(verteces.containsKey(x)){
            System.out.println("The vertex " + x + " is already in the Graph.");
        }else{
            List<EdgeNode<T>> newList = new LinkedList<EdgeNode<T>>();
            verteces.put(x, newList);
        }
    }

    @Override
    public void removeVertex(T x) {
        if(!verteces.containsKey(x)){
            System.out.println("The vertex " + x + " is not in the Graph.");
        }else{
            verteces.remove(x);
        }
    }

    @Override
    public void addEdge(T x, T y) {
        if(!verteces.containsKey(x)){
            System.out.println("The vertex " + x + " is not in the Graph.");
        }else if(!verteces.containsKey(y)){
            System.out.println("The vertex " + y + " is not in the Graph.");
        }else{
            List<EdgeNode<T>> adjList = verteces.get(x);
            if(adjList.contains(new EdgeNode<T>(y, 0))){
                System.out.println("The edge from " + x + " to " + y + " is already in the graph");
            }else{
                adjList.add(new EdgeNode<T>(y, 0));
            }
        }
    }

    @Override
    public void removeEdge(T x, T y) {
        if(!verteces.containsKey(x)){
            System.out.println("The vertex " + x + " is not in the Graph.");
        }else if(!verteces.containsKey(y)){
            System.out.println("The vertex " + y + " is not in the Graph.");
        }else{
            List<EdgeNode<T>> adjList = verteces.get(x);
            if(!adjList.contains(new EdgeNode<T>(y, 0))){
                System.out.println("The edge from " + x + " to " + y + " is not in the graph and cannot be removed.");
            }else{
                adjList.remove(new EdgeNode<T>(y, 0));
            }
        }
    }

    @Override
    public String toString() {
        String result = "";

        for(T vertex : verteces.keySet()){
            result+= vertex + " neighbours: -> ";
            List<EdgeNode<T>> neighbours = verteces.get(vertex);
            for(EdgeNode<T> edge : neighbours){
                result+= edge.getElement()+ "->";
            }
            result+= "null\n";
        }
        return result;
    }

    public Graph<T> clone(){
        AdjacencyListGraph<T> copy = new AdjacencyListGraph<T>();

        for(T vertex : verteces.keySet()){
            copy.addVertex(vertex);
        }

        for(T vertex : verteces.keySet()){
            for(EdgeNode<T> edge : verteces.get(vertex)){
                copy.addEdge(vertex, edge.getElement());
            }
        }

        return copy;
    }

    @Override
    public List<T> getVertecesList() {
        return new LinkedList<T>(verteces.keySet());
    }
    
}
