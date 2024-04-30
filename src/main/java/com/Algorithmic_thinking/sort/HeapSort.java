package com.Algorithmic_thinking.sort;

import com.base.heap.MaxHeap;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2024/4/30
 * 堆排序，第一步需要先建堆，之后再交换堆顶和末尾的值直至末尾到堆顶
 * 这里演示的是大顶堆，升序；
 */
public class HeapSort {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(new int[]{2, 3, 1, 7, 6, 4, 5});
        //建堆
        maxHeap.maxHeapify();
        //堆排序，交换堆顶和size--的元素，执行n-1次
        while (maxHeap.size > 1) {
            SwapUtil.swap(maxHeap.heap, 0, --maxHeap.size);
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.heap));
    }
}
