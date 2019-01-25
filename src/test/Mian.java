package test;

import queue.ArrayQueue;
import queue.LoopQueue;
import queue.Queue;

import java.util.Random;

/**
 * @author lixw
 * @date created in 10:32 2019/1/25
 */
public class Mian {
    /**
     * 测试使用q运行opcount个enqueue和dequeue操作需要的时间（单位：秒）
     * @param q
     * @param opCount
     * @return
     */
    public static double testQueue(Queue<Integer> q , int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0;i<opCount;i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        //出队
        for(int i = 0;i<opCount;i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayTime:" + time1 +"s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("ArrayTime:" + time2 +"s");

    }
}
