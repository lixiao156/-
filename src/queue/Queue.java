package queue;

/**
 * @author lixw
 * @date created in 12:38 2019/1/18
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
