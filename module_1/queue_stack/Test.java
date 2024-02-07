package module_1.queue_stack;

public class Test {
    public static void main(String[] args) {
        // StackADT<Integer> stack = new StackArrayBased<Integer>();

        // for(int i = 0; i<20; i++){
        //     stack.push(i);
        // }

        // for(int i = 0; i<20; i++){
        //     System.out.println(stack.pop());
        // }

        QueueADT<Integer> queue = new QueueArrayBased<Integer>();

        for(int i = 0; i<7; i++){
            queue.enqueue(i);
        }

        for(int i = 0; i<3; i++){
            System.out.println(queue.dequeue());
        }

        for(int i = 20; i<30; i++){
            queue.enqueue(i);
        }

        System.out.println("Final queue");
        for(int i = 0; i<30; i++){
            System.out.println(queue.dequeue());
        }

    }
}
