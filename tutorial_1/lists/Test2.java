package module1.lists;

public class Test2 {
    public static void main(String[] args) {
        ListADT<Integer> list = new SingleLinkedList<Integer>();

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.first());
        System.out.println(list.last());

        for(int i=0; i<20;i=i+2){
            list.insertFront(i);
        }

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.first());
        System.out.println(list.last());

        for(int i=1; i<20; i++){
            list.insertBack(i);
        }

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.first());
        System.out.println(list.last());

        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }

        list.get(list.size()+5);

        System.out.println(list);

        /* Speed test - comparison with implementation using last node reference */

        ListADT<Integer> list1 = new SingleLinkedList<Integer>();
        ListADT<Integer> list2 = new SingleLinkedList_Alt<Integer>();

        double startTime, endTime;
        startTime = System.currentTimeMillis();
        for(int i = 0; i<10000; i++){
            list1.insertBack(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total time for initialization List1: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i<10000; i++){
            list2.insertBack(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total time for initialization List2: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i<10000; i++){
            list1.removeBack();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total time for removing all elements in List1: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i<10000; i++){
            list2.removeBack();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total time for removing all elements in List2: " + (endTime - startTime));

    }
}
