###  Algorithmic-thinking

#### 二分查找法

- 前提：有已排序数组array；

1. 定义左边界left，右边界right，确定搜索范围，循环执行二分查找；

2. 获取中间索引middle = （left + right）/ 2;  ==无符号左移1位更优==

3. 中间索引值array[middle] 与待搜索的target值作比较

	- array[middle] = target，返回middle索引；

	- array[middle] < target，则说明left至middle元素不用再去比较，将left重新赋值为middle+1;
   
	-  array[middle] > target，则说明middle至right元素不用再去比较，将right重新赋值为middle-1;

4. 当L>R时，则说明没有该数组没有target元素，结束循环；

```java
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 6, 7, 10, 22, 64, 232, 466, 678, 1202, 2202, 2052, 12622};
        //要查找的目标target
        int target = 232;
        int result = search(array, target);
        System.out.println(result);
    }

    static int search(int[] array, int target) {

        int left = 0, right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
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
```

#### 冒泡排序

1. 依次比较数组中两个相邻元素的大小，若a[j]>a[j+1]，交换两个元素的位置，两两都比较，直到比较至最后一个元素，都比较一遍成为一轮冒泡，结果是让该数组中最大的元素移至最后；
2. 重复比较，直到整个数组有序；

```java
public class Bubbling {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            //优化点: 最大元素每次在排序后已经在数组末尾，可减少比较次数,
          	//增加一个标记位，在一次循环中，相邻两个元素没有发生位移，则将标志位为true,不会置为false，跳出循环
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 比较相邻的两个元素，
                if (array[j] > array[j + 1]) {
                    swap(array,j,j+1);
                    flag = false;
                }
            }
            System.out.println("遍历第" + i + "次结果:\t" + Arrays.toString(array));
            if (flag) {
                break;
            }
        }
        System.out.println("遍历完成:        \t" + Arrays.toString(array));
    }
    //交换元素，抽取成方法
    static void swap(int[] array, int pre, int next) {
        int temp = array[next];
        array[next] = array[pre];
        array[pre] = temp;
    }
}
```

#### 选择排序

1. 将数组分成分成两个子集，已排序的和未排序的，每一轮从未排序中数组找到最小元素，并放入排序子集中；
2. 反复以上步骤，直到整个数组有序；

```java
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        //i代表每轮选择最小元素要交换到的目标索引
        for (int i = 0; i < array.length - 1; i++) {
            //temp代表最小元素的索引
            int temp = i;
            for (int j = i + 1; j < array.length; j++) {
                //在剩余j个元素中找到最小的元素，
                if (array[temp] > array[j]) {
                    temp = j;
                }
            }
            if (i != temp) {
                swap(array, i, temp);
            }
            System.out.println("第"+i+"轮:\t"+"交换的元素:"+array[i]+"\t"+Arrays.toString( array));
        }
    }
}
```

#### 插入排序

1. 将数组分为两个区域，排序区域和未排序区域，每一轮从未排序区域中取出第一个元素，插入到排序区域（需保证顺序）

2. 重复以上步骤，直到整个数组有序

```java
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        //i代表要插入元素的索引
        for (int i = 1; i < array.length; i++) {
            //j-1代表已排好序的子集，j=i，j就是将要插入的元素，需要将j元素从0->j-1个元素进行比较，插入
            for (int j = i; j > 0 ; j--) {
                if (array[j]<array[j-1]){
                    swap(array,j,j-1);
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}

```

### LeetCode

#### 反转字符串

```java
public class ReverseString {
    public static void main(String[] args) {
        char[] string = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
        System.out.println(string);
        System.out.println("双指针反转");
        int left = 0;
        int right = string.length -1;
        while (left < right) {
           swap(string,left++,right--);
        }
        System.out.println(string);
    }

    private static void swap(char[] s, int left, int right) {
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
    }
}
```

