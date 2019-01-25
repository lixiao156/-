package linkedlist.linklist;

/**
 * 没有引入虚拟头结点
 * @author lixw
 * @date created in 12:04 2019/1/25
 */
public class LinkedList<E> {
    /**
     * 设置为私有的内部类
     * 因为用户根本就不需要知道节点的具体实现
     * 只需要知道链表是一种线性的结构
     * <p>
     * 可以增删数据的
     */
    private class Node {
        //元素
        public E e;
        //next 是一个指向nod的引用
        /**
         * 设置为public 是为了在外部类LinkedList中不使用get set 方法
         */
        public Node next;

        /**
         * 设计构造函数
         */
        public Node(E e, Node next) {
            /**
             *构造函数的两个参数和节点的成员两个变量重名了
             *这时候需要用this 指明  将用户传来的的 e 指向节点成员变量的 e
             *这时候需要用this 指明  将用户传来的的 next 指向节点成员变量的 next
             */
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 元素e添加在链表头
     * 节点的next 指向 head
     *
     * @param e
     */
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        /**
         * 记得 +1
         */
        size++;
    }

    /**
     * 在链表中的index（0-based)位置添加新的元素e
     * 不常用  一般在练习题
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed illegal index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            /**
             * 找index位置的前一个位置
             */
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//三句话可以写成一句  添加的节点需要新建Node
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /**
     * 末尾添加节点e
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }
}
