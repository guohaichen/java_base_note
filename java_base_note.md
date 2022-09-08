## 设计模式

### 设计模式的六大原则

##### 单一职责原则

​		一个类负责一项职责。

##### 开闭原则Open Close Principle

​		开闭原则的意思是**"对修改关闭，对扩展开放"**。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了程序的扩展性好，易于维护和升级。

##### 里氏代换原则Liskov Substitution Principle

​		里氏代换原则是面向对象设计的基本原则之一。里氏代换原则中说，任何基类可以出现的地方，其子类一定可以出现。LSP是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用，而派生类也能够在基类的基础上增加新的行为。里氏代换原则是对开闭原则的补充。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体表现，所以里氏代换是对实现抽象化的具体步骤的规范。

##### 依赖倒置原则

​		这个原则是开闭原则的基础，具体内容：**针对接口编程，依赖于抽象而不依赖于具体**。

##### 接口隔离原则

​		这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。它还有另外一个意思是：降低类之间的耦合度。

##### 迪米特法则

​		又称最少知道原则，指的是一**个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立**。高内聚，低耦合。

##### 合成复用原则

​		合成复用原则是指**尽量使用合称/聚合的方式，而不是使用继承**。

### 一、创建型模式

#### 一、工厂模式

> 概述：在java中，万物皆对象，这些对象都需要创建，如果创建的时候直接new该对象，就会对该对象耦合严重，假如我们要更换对象，所有new对象的地方都需要修改一遍，这显然违背了软件设计的开闭原则。如果我们使用工厂来生产对象，我们就只和工厂打交道就可以了，彻底和对象解耦，如果要更换对象，直接在工厂里更换该对象即可，达到了与对象解耦的目的；所以说，工厂模式最大的优点就是：**解耦**。

##### 1.1.1 简单工厂模式

简单工厂模式不是一种设计模式，更像是一种变成习惯；

结构：

- 抽象产品：定义了产品的规范，描述了产品的主要特性和功能。
- 具体产品：实现或者继承抽象产品的子类。
- 具体工厂：提供了创建产品的方法，调用者通过该方法来获取产品。

优点：

- 具体工厂封装了创建对象的过程，可以通过参数直接获取对象。把对西安的创建和业务逻辑层分开，避免了修改消费者代码，如果要实现新产品直接修改工厂类，而不需要在原代码中修改，这样就降低了客户代码修改的可能性，更加容易扩展。

缺点：

- 增加新产品是还是需要修改具体工厂的代码，违背了'开闭原则'。

### 二、结构型模式

#### 一、代理模式

##### 2.1.1 静态代理

##### 2.1.2 JDK动态代理

##### 2.1.3 CGLib动态代理

> 概述：cglib是一个强大、高性能的字节码生成库，它用于在运行时扩展Java类和实现接口；本质上它是通过动态的生成一个子类去覆盖所要代理的类。

##### 2.1.4 三种代理模式的对比



#### 二、适配器模式

> 概述：适配器模式是作为两个不兼容的接口之间的桥梁，它结合了两个独立接口的功能。这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。举例：读卡器是作为内存卡和笔记本之间的适配器，将内存卡插入读卡器，再将读卡器插入笔记本，这样就可以通过笔记本来读取内内卡。

结构

* 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
* 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
* 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。

##### 2.2.1 类适配器模式

实现方式：定义一个适配器类来实现当前系统的业务接口，同时又继承现有组件库中已经存在的组件。

##### 2.2.2 对象适配器模式

实现方式：对象适配器模式可釆用将现有组件库中已经实现的组件引入适配器类中，该类同时实现当前系统的业务接口。



#### 三、装饰者模式

> 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
>
> 这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。

#### 四、桥接模式

>概述：桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
>
>这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。

### 三、行为模式

#### 一、策略模式

> 概述：在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。

#### 二、责任链模式

> 概述：责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。这种模式给与请求的类型，对请求的发送者和接收者进行解耦。
>
> 在这种模式中，通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依次类推。

#### 三、观察者模式

> 概述：又被称为发布-订阅模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己。



## Algorithmic-thinking

### 二分查找法

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

### 冒泡排序

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

### 选择排序

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

### 插入排序

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

## LeetCode

### 反转字符串

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

## Mybatis-Plus

### 注解

#### 1. @TableField FieldStrategy

| 值        | 描述                                                         |
| :-------- | :----------------------------------------------------------- |
| IGNORED   | 忽略判断，不管有没有设置属性，所有的字段都会设置到insert语句中，如果没设置值会更新为null |
| NOT_NULL  | 非 NULL 判断，默认策略，忽略null的字段，不忽略""             |
| NOT_EMPTY | 忽略为null，为空串的判断，就是如果设置值为null，""，不会插入数据库 |
| DEFAULT   | 追随全局配置                                                 |
| NEVER     | 一经插入，用不更新（etc:createTime）                         |

