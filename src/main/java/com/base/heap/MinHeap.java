package com.base.heap;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2024/4/29
 * 小顶堆
 */
public class MinHeap {
    public int size;

    public final int[] heap;

    public MinHeap(int[] heap) {
        this.size = heap.length;
        this.heap = heap;
    }

    //堆化
    public void minHeapify() {
        //找到所有的非叶子节点，进行比较交换，由于是 完全二叉树，非叶子节点在数组中的公式为 array.length/2 - 1 到0；
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 获取堆顶元素
     *
     * @return 返回堆顶元素
     */
    private int peek() {
        return heap[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     * 正常来说，删除数组中下标为0的元素，移动后面的元素。
     * 而在堆中可以直接交换堆顶和堆尾的值，并将size-1即可
     */
    public int poll() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        down(0);
        return max;
    }

    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除元素
     */
    public int poll(int index) {
        int deleted = heap[index];
        heap[index] = heap[size - 1];
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        heap[0] = replaced;
        down(0);
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     * @return 是否添加成功
     */
    public boolean offer(int offered) {
        if (size == heap.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    // 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered < heap[parent]) {
                heap[child] = heap[parent];
            } else {
                break;
            }
            child = parent;
        }
        heap[child] = offered;
    }


    //小顶堆 元素下沉
    public void down(int parent) {
        int min = parent;
        int left = parent * 2 + 1;
        int right = left + 1;

        if (left < size && heap[left] < heap[min]) {
            min = left;
        }
        if (right < size && heap[right] < heap[min]) {
            min = right;
        }
        if (min != parent) {
            swap(min, parent);
            down(min);
        }
    }


    private void swap(int parent, int max) {
        int temp = heap[parent];
        heap[parent] = heap[max];
        heap[max] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 7, 6, 5, 4, 3};
        MinHeap minHeap = new MinHeap(array);
        minHeap.minHeapify();
        System.out.println(Arrays.toString(minHeap.heap));
    }
}
