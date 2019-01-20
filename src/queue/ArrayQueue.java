package queue;

/**
 * @author lixw
 * @date created in 12:40 2019/1/18
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Queue:");
        res.append("front[");
        for(int i = 0 ;i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(",");
            }
        }
        //提示用户那个位置是队首元素
        //因为每次加入到动态数组的末端
        res.append("] tail");
        return res.toString();
    }
}
