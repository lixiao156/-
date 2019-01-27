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
        //next 是一个指向node的引用
        /**
         * 设置为public 是为了在外部类LinkedList中不使用get set 方法
         * <p>
         * 定义为  next 只是可读性  本节点封装了 另外一个结点
         * <p>
         * 创建链表的时候  就确定了： 节点的顺序 （创建的时候就是依赖这种封装的关系   删除 插入自然也是可以有这种关系）
         */
        public Node next;

        /**
         * 设计构造函数
         */
        public Node(E e, Node next) {
            /**
             *构造函数的两个参数和节点的成员两个变量重名了
             *
             * (this指的是当前对象 与 用户传过来的参数区别开  也可以 用户传递的参数和 类的成员变量字段设置成不一样)
             *
             *
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
     * <p>
     * 创建链表的时候  就是将 Node 类里面封装的 节点 next  作为下一个节点的逻辑关系
     * <p>
     * 及时不将 封装的节点  定义为 next  定义为  following 也是可以的
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //prev引用从 prev 节点指向 prev 节点中封装的另外一个结点
            prev = prev.next;
        }
//            三句话可以写成一句  添加的节点需要新建Node
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
            //Node节点中的成员属性 next
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

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        Node cur = dummyHead.next;
        /**
         * 将不为空的输出 虚拟头结点是不会输出的
         */
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        return res.toString();

    }

    /**
     * 增加链表的删除操作  删除index(0-based)位置的元素
     * 返回删除的元素
     * 在链表的不是一个常用的操作
     */
    public E remove(int index) {
        //检查index是否是合法的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed Index is illegal ");
        }
        //  将dummyHead的引用复制一份给 prev 节点
        Node prev = dummyHead;
        //找到待删除的节点之前的节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        //记得维护size
        size--;
        //将删除的元素返回  可以知道删除节点的属性
        return retNode.e;
    }


    public E removeTest(int index) {
        //检查index是否是合法的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed Index is illegal ");
        }
        //  将dummyHead的引用复制一份给 prev 节点
        Node prev = dummyHead;

        Node cur = dummyHead;
        //找到待删除的节点之前的节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        cur = prev;
        cur.next = prev.next.next;

        //记得维护size
        size--;
        //将删除的元素返回  可以知道删除节点的属性
        return cur.e;
    }

    /**
     * 删除链表头节点
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }
}
