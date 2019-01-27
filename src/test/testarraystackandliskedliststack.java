package test;

import queue.ArrayQueue;
import queue.LoopQueue;
import queue.Queue;
import stack.ArrayStack;
import stack.LinkedListStack;
import stack.Stack;

import java.util.Random;

/**
 * 测试动态数组栈 和 链表栈
 * @author lixw
 * @date created in 9:13 2019/1/27
 */
public class testarraystackandliskedliststack {
    /**
     * 测试使用q运行opcount个enqueue和dequeue操作需要的时间（单位：秒）
     * @param
     * @param opCount
     * @return
     */
    public static double testStack(Stack<Integer> s , int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0;i<opCount;i++) {
            s.push(random.nextInt(Integer.MAX_VALUE));
        }
        //出栈
        for(int i = 0;i<opCount;i++) {
           s.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println("ArrayTime:" + time1 +"s");
        LinkedListStack <Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack,opCount);
        System.out.println("LinkTime:" + time2 +"s");

    }
}
