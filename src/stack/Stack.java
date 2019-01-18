package stack;

/**
 * 为了实现多态的特性
 * 设计成接口
 * 相同接口名不同的实现
 * <p>
 * 支持泛型
 *
 * @author lixw
 * @date created in 8:18 2019/1/18
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    /**
     * 删除栈顶元素返回栈顶元素的值
     *
     * @return
     */
    E pop();

    /**
     * 取栈顶元素  但是栈中的元素不改变
     *
     * @return
     */
    E peek();
}
