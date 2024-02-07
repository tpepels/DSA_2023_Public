package module_1.queue_stack;

public interface StackADT<T> {
    /**
     * 
     * @param element
     */
    public void push(T element);
    public T pop();
    public T top();
    public int size();
    public boolean isEmpty();
}
