package stack;

/**
 * 基于自定义动态数组实现的栈
 * 也需要支持泛型
 *
 * 动态数组会自己调节容量
 *
 * @author lixw
 * @date created in 8:26 2019/1/18
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * 成员变量
     */
    Array<E> array;

    /**
     * 设计构造函数 初始化栈的容量
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造
     */
    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 获取容量只是与用动态数组实现有关
     * 和栈的接口是无关的
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 栈的push相当于在动态数组的末尾
     * 加上一个元素
     *
     * 运用了动态数组  resize（）数组也是能够使用上的
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     *
     * @return
     */
    @Override
    public E pop() {
      return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getSize()-1);
    }
}
