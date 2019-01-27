package linkedlist.linklist;

/**
 * @author lixw
 * @date created in 14:29 2019/1/25
 */
public class Main {

    public static void main(String[] args) {
        LinkedList1 <Integer> linkedList = new LinkedList1<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.removeTest(1);
        System.out.println(linkedList);
    }
}
