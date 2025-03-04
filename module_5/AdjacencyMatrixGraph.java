package module_5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyMatrixGraph<T> implements Graph<T> {

    private Integer[][] matrix;
    private int capacity;
    private int n;
    private Map<T,Integer> indexForVertex;
    List<Integer> availableIndeces;

    public AdjacencyMatrixGraph(){
        capacity = 8;
        n = 0;
        matrix = new Integer[capacity][capacity];
        indexForVertex = new HashMap<>();

        availableIndeces = new LinkedList<>();
        for(int i=0;i<capacity;i++){
            availableIndeces.add(i);
        }
    }

    @Override
    public boolean adjacent(T x, T y) {
        if(indexForVertex.containsKey(x) && indexForVertex.containsKey(y)){
            Integer indexX = indexForVertex.get(x);
            Integer indexY = indexForVertex.get(y);
            return (matrix[indexX][indexY]!=null);        
        }else{
            System.out.println("The verteces should be in the graph");
            return false;
        }
    }

    @Override
    public List<T> neighbors(T x) {
        if(indexForVertex.containsKey(x)){
            List<T> neighbors = new LinkedList<>();
            for(T v : getVertecesList()){
                if(adjacent(x, v)){
                    neighbors.add(v);
                }
            }
            return neighbors;
        }else{
            System.out.println("The node should be in the graph");
            return null;
        }
    }

    @Override
    public void addVertex(T x) {
        if(indexForVertex.containsKey(x)){
            System.out.println("The node is already in the graph");
        }else{
            if(availableIndeces.isEmpty()){
                capacity+=8;
                Integer[][] newMatrix = new Integer[capacity][capacity];
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        newMatrix[i][j] = matrix[i][j];
                    }
                }

                matrix = newMatrix;

                for(int i=n;i<capacity;i++){
                    availableIndeces.add(i);
                }
            }
            Integer firstAvailableIndex = availableIndeces.remove(0);
            indexForVertex.put(x, firstAvailableIndex);
            n++;
        }
    }

    @Override
    public void removeVertex(T x) {
        if(indexForVertex.containsKey(x)){
            Integer indexRemoved = indexForVertex.remove(x);
            availableIndeces.add(0, indexRemoved);
            for(int i=0;i<n;i++){
                matrix[indexRemoved][i] = null;
                matrix[i][indexRemoved] = null;
            }
            n--;
        }else{
            System.out.println("The node should be in the graph");
        }
    }

    @Override
    public void addEdge(T x, T y) {
        addEdge(x, y, 0);
    }

    @Override
    public void addEdge(T x, T y, int weight) {
        if(indexForVertex.containsKey(x) && indexForVertex.containsKey(y)){
            Integer indexX = indexForVertex.get(x);
            Integer indexY = indexForVertex.get(y);
            matrix[indexX][indexY] = weight;
        }else{
            System.out.println("The verteces should be in the graph");
        }
    }

    @Override
    public void removeEdge(T x, T y) {
        if(indexForVertex.containsKey(x) && indexForVertex.containsKey(y)){
            Integer indexX = indexForVertex.get(x);
            Integer indexY = indexForVertex.get(y);
            matrix[indexX][indexY] = null;
        }else{
            System.out.println("The verteces should be in the graph");
        }
    }

    @Override
    public List<T> getVertecesList() {
        Set<T> keySet = indexForVertex.keySet();
        List<T> vertecesList = new LinkedList<>();
        vertecesList.addAll(keySet);
        return vertecesList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Graph<T> copy = new AdjacencyMatrixGraph<>();

        for (T vertex : indexForVertex.keySet()) {
            copy.addVertex(vertex);
        }

        for (T vertex : indexForVertex.keySet()) {
            for (T neighbor : neighbors(vertex)) {
                copy.addEdge(vertex, neighbor, matrix[indexForVertex.get(vertex)][indexForVertex.get(neighbor)]);
            }
        }

        return copy;
    }
    
    @Override
    public String toString() {
        String s = "";
        for(T v : getVertecesList()){
            s+= v + ": ";
            for(T u : neighbors(v)){
                s+= u + "; ";
            }
            s+="\n";
        }
        return s;
    }
    
}
