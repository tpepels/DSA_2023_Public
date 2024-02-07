package module_1.queue_stack;

public interface QueueADT<T> {
    public void enqueue(T element);
    public T dequeue();
    public T top();
    public int size();
    public boolean isEmpty();
}
