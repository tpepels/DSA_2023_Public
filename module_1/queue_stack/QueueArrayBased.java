package module_1.queue_stack;

public class QueueArrayBased<T> implements QueueADT<T> {
    private T[] elements;
    private int array_size;
    private int front_index;
    private int rear_index;
    private int size;

    public QueueArrayBased(){
        this.array_size = 4;
        this.elements = (T[]) new Object[this.array_size];
        this.front_index = 0;
        this.rear_index = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if(this.size==this.array_size){
            System.out.println("Resizing!");
            int new_array_size = 2*this.array_size;
            T[] new_elements = (T[]) new Object[new_array_size];
            for(int i = 0; i<this.array_size; i++){
                new_elements[i] = this.elements[(i+front_index) % this.array_size];
            }
            this.front_index = 0;
            this.rear_index = this.size;
            this.array_size = new_array_size;
            this.elements = new_elements;
        }
        this.elements[rear_index] = element;
        this.size++;
        rear_index = (rear_index + 1) % this.array_size;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }else{
            T front_element = elements[front_index];
            elements[front_index] = null;
            front_index = (front_index + 1) % this.array_size;
            this.size--;
            return front_element;
        }
    }

    @Override
    public T top() {
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }else{
            return elements[front_index];
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }
    
}
