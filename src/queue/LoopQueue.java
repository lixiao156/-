package queue;

/**
 * 循环队列有意识的浪费一个空间
 * <p>
 * 这个类不在使用之前自定义的动态数组  自己从底层写起
 * 支持泛型  实现接口 接口与动态数组是无关的
 *
 * @author lixw
 * @date created in 9:17 2019/1/20
 */
public class LoopQueue<E> implements Queue<E> {
    /**
     * 需要有泛型  E[] 这个数组
     */
    private E[] data;
    /**
     * 有两个int形式的变量
     */
    private int front, tail;
    /**
     * 不用size 使用front  tail也可以计算出 队列的大小来
     */
    private int size;

    /**
     * 构造函数
     * <p>
     * 容量需要+1      ????
     */

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获取循环数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //1.首先是需要判断队列是否是满的
        if ((tail + 1) % data.length == front) {
            //2.扩容  循环队列有意识的浪费一个空间
            resize(getCapacity() * 2);
        }
    }


    /**
     * 出 队列
     *
     * @return
     */
    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }


    private void resize(int newCapacity) {
        //3.循环数组需要浪费一个空间
        E[] newData = (E[])new Object[newCapacity + 1];

        for( int i = 0 ;i<size;i++){
            /**
             * 新的队列的首位置对应的
             * 原来队列的 front 索引的位置
             *
             *
             * i + front 在 i 不断增加的过程中会出现 溢出 需要取余
             */
            newData[i] = data[i+front];
        }

    }
}
