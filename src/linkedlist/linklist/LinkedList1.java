package linkedlist.linklist;

/**
 * 没有引入虚拟头结点
 *
 * @author lixw
 * @date created in 12:04 2019/1/25
 */
public class LinkedList1<E> {
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

    /**
     * 添加虚拟头结点
     * 此时空的链表是存在一个结点的
     * 这个节点就是唯一存在的虚拟头结点
     */
    private Node dummyHead;
    int size;

    public LinkedList1() {
        dummyHead = new Node(null, null);
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
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0, e);
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
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//三句话可以写成一句  添加的节点需要新建Node
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }


    /**
     * 末尾添加节点e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);

    }

    /**
     * 获取链表的第index(0-size)个位置的元素
     * 在链表中不常用
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed illegal index");
        }
        //这里是从第一个元素开始遍历
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;

    }

    /**
     * 获取头元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表中的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed illegal index");
        }
        /**
         * 遍历找到需要改变的节点
         */
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
            cur.e = e;
        }
    }

    public boolean contains(E e) {
        /**
         * 这里没有索引
         * 需要全部遍历
         * 不知道需要遍历多少的时候可以使用while遍历
         */
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                cur = cur.next;
                return true;
            }
        }
        return false;
    }


}
