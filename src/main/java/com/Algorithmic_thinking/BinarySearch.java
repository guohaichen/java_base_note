package com.Algorithmic_thinking;

/**
 * @author cgh
 * @create 2022-07-25 21:25
 * 二分查找
 * - 前提：有已排序数组array；
 * 1. 定义左边界left，右边界right，确定搜索范围，循环执行二分查找；
 * 2. 获取中间索引middle = （left + right）/ 2;
 * 3. 中间索引值array[middle] 与待搜索的target值作比较
 *    - array[middle] = target，返回middle索引；
 *    - array[middle] < target，则说明left至middle元素不用再去比较，将left重新赋值为middle+1;
 *    - array[middle] > target，则说明middle至right元素不用再去比较，将right重新赋值为middle-1;
 * 4. 当L>R时，则说明没有该数组没有target元素，结束循环；
 */
public class
BinarySearch {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 6, 7, 10, 22, 64, 232, 466, 678, 1202,2052, 2202, 12622};
        //要查找的目标target
        int target = 232;

        int result = search(array, target);
        System.out.println(result);
    }

    static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        /*
        middle二分查找的中间节点，如果target小于array[middle]，则下次从left-middle中间找，如果target大于array[middle]则从middle-right中找
        如果target==array[middle]，则返回middle;
        结束条件：left>right;
        * */
        while (left <= right) {
            int middle = (left + right) >>> 1; //(left+right)/2
            /*
            思考:如果target > array[middle]，则left为middle+1，假设left和right都很大了，超过了integer的最大值，则会出错
                解决方法：
                无符号右移1位，>>>1
            */
            if (target == array[middle]) {
                return middle;
            }
            if (target < array[middle]) {
                right = middle - 1;
            }
            if (target > array[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }
}
