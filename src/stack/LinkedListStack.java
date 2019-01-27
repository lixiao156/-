package stack;


import linkedlist.linklist.LinkedList1;

/**
 * 采用的链表实现
 *
 * @author lixw
 * @date created in 23:00 2019/1/26
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList1<E> list;

    /**
     * 构造方法
     */
    public LinkedListStack() {
        list = new LinkedList1<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {

        //链表头是栈顶元素
        list.addFirst(e);

    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * 看一些第一个元素  对 栈的元素结构是不影响的
     *
     * @return
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
       StringBuffer res = new StringBuffer();
       res.append("Stack:top");
       res.append(list);
       return res.toString();

    }


    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
