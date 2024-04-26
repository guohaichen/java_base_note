package com.base.queue.impl.unitTest;

import com.base.queue.impl.CycleArrayQueue1;
import org.junit.Test;

/**
 * @author cgh
 * @create 2024/4/24
 */
public class QueueTest {

    @Test
    public void arrayTest() {
        CycleArrayQueue1<Integer> cycleQueue = new CycleArrayQueue1<>(4);
        cycleQueue.offer(1);
        cycleQueue.offer(2);
        cycleQueue.offer(3);
        cycleQueue.offer(4);
        System.out.println("isFull:\t" + cycleQueue.isFull());
        cycleQueue.offer(5);
        cycleQueue.offer(1);
        System.out.println(cycleQueue.poll());
        System.out.println(cycleQueue.poll());
        cycleQueue.offer(5);
        cycleQueue.offer(1);
        System.out.println(cycleQueue.poll());
        System.out.println(cycleQueue.poll());
        System.out.println(cycleQueue.peek());
        System.out.println("size:\t" + cycleQueue.size());
    }
}
