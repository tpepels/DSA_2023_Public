package tutorial_5;

public class EdgeNode<T> {
    private T element;
    private Integer weight;
    
    public EdgeNode(T element, Integer weight) {
        this.element = element;
        this.weight = weight;
    }

    public T getElement(){
        return element;
    }

    public void setElement(T element){
        this.element = element;
    }

    public Integer getWeight(){
        return weight;
    }

    public void setWeight(Integer weight){
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o){
        return element.equals(((EdgeNode<T>) o).getElement());
    }
}
