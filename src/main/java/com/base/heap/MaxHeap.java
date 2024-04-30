package com.base.heap;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2024/4/29
 * 堆的定义：堆的物理结构本质上是顺序存储的，是线性的。但在逻辑上不是线性的，是完全二叉树的这种逻辑储存结构。
 * 大顶堆，建堆过程:1. 确定左右子树；2.找到最大节点；3.交换并递归（交换后的节点可能不满足大顶堆的性质，因此需要递归，直到整个子树满足性质）
 * 例如数组存储的是{1，2，3，4，5，6，7} ，这颗二叉树如下：
 * 1
 * 2            3
 * 4        5   6          7
 * 在转变为大顶堆后如下：
 * 7
 * 5             6
 * 4        2   1          3
 */
public class MaxHeap {
    public int size;

    public final int[] heap;

    public MaxHeap(int[] heap) {
        this.size = heap.length;
        this.heap = heap;
    }

    //堆化
    public void maxHeapify() {
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
            //找到父节点
            int parent = (child - 1) / 2;
            if (offered > heap[parent]) {
                //上浮
                heap[child] = heap[parent];
            } else {
                break;
            }
            child = parent;
        }
        heap[child] = offered;
    }


    //大顶堆 元素下沉
    public void down(int parent) {
        int max = parent;
        //一个叶子节点的左孩子下标为= index*2+1
        int left = parent * 2 + 1;
        int right = left + 1;

        if (left < size && heap[left] > heap[max]) {
            max = left;
        }
        if (right < size && heap[right] > heap[max]) {
            max = right;
        }
        //交换并递归：如果最大值不在当前节点，即找到了一个更大的子节点，那么需要交换当前节点与这个最大子节点的值，以恢复大顶堆的性质。
        // 交换之后，原先最大子节点所在的位置可能又不满足堆性质了，因此需要对这个新的位置（即交换后原最大子节点的索引）递归调用 down 方法，直到整个子树都满足大顶堆的条件。
        if (max != parent) {
            swap(parent, max);
            down(max);
        }
    }

    private void swap(int parent, int max) {
        int temp = heap[parent];
        heap[parent] = heap[max];
        heap[max] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);
        maxHeap.maxHeapify();
        System.out.println(Arrays.toString(maxHeap.heap));
    }
}
