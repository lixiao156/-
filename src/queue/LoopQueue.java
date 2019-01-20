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
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    /**
     * 出 队列
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        E ret = data[front];
        /**
         * 将原来的front置为  null
         */
        data[front] = null;
        /**
         * 队列只需要关注队列的  队首  和   队尾
         * 所以讲队列的front所指向的位置向后移动一位
         */
        front = (front + 1) % data.length;
        size--;

        /**
         * 出队可以可以缩容量  减少为1/4的时候进行操作
         */
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot get data from empty queue");
        }
        /**
         * 直接返回队列的首部的位置
         */
        return data[front];
    }

    /**
     * 队列扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        //3.循环数组需要浪费一个空间
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            /**
             * 新的
             *
             *  33333333队列的首位置对应的
             * 原来队列的 front 索引的位置
             *
             *
             * i + front 在 i 不断增加的过程中会出现 溢出 需要取余
             */
            newData[i] = data[(i + front) % data.length];

            data = newData;
            front = 0;
            tail = size;
        }

    }
//    错误的写法
//    @Override
//    public String toString() {
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("[");
//        for (int i = 0; i < data.length; i++) {
//            stringBuffer.append(data[front]);
//            data[front] = null;
//            //front 指针后移一位
//            front = (front + 1) % data.length;
//            //队列中需要遍历的位置数目减小一位
//            size--;
//        }
//        stringBuffer.append("]");
//        return stringBuffer.toString();
//    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("Queue:size=  %d, capacity:%d\n", size, getCapacity()));
        stringBuffer.append("front[");
        // for (int i = 0; i < size; i++) {
        //循环列表与一般的不同
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuffer.append(data[i]);
            if (i != size - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]tail");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
        System.out.println(10 / 4);

    }
}
