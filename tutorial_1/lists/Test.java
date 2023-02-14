package module1.lists;

public class Test {
    public static void main(String[] args) {
        ListADT<Integer> list = new ArrayBasedList<Integer>();
        
        // ListADT<Integer> list = new SingleLinkedList<Integer>();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.first());

        for(int i = 0; i<20; i=i+2){
            list.insertFront(i);
        }

        System.out.println(list.first());
        System.out.println(list.last());

        for(int i = 1; i<20; i=i+2){
            list.insertBack(i);
        }

        System.out.println(list.first());
        System.out.println(list.last());

        System.out.println(list.get(50));
    }
}
