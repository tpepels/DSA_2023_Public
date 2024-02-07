package module_1.queue_stack;

public class StackArrayBased<T> implements StackADT<T>{
    private T[] elements;
    private int size;
    private int top_index;
    private int array_size;

    public StackArrayBased(){
        this.size = 0;
        this.top_index = -1;
        this.array_size = 16;
        this.elements = (T[]) new Object[this.array_size];
    }

    @Override
    public void push(T element) {
        if(this.size==this.array_size){
            System.out.println("Resizing!");
            int new_array_size = 2*this.array_size;
            T[] new_elements = (T[]) new Object[new_array_size];
            for(int i = 0; i<this.array_size; i++){
                new_elements[i] = this.elements[i];
            }
            this.array_size = new_array_size;
            this.elements = new_elements;
        }
        this.top_index++;
        this.size++;
        this.elements[this.top_index] = element;
        
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }else{
            T topElement = elements[top_index];
            elements[top_index] = null;
            size--;
            top_index--;
            return topElement;
        }
    }

    @Override
    public T top() {
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }else{
            return elements[top_index];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }
    
}
