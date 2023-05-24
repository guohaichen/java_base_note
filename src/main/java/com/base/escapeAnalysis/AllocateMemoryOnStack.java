package com.base.escapeAnalysis;

/**
 * @author cgh
 * @create 2023-05-24
 * 创建对象时，java在栈上分配内存的的demo
 * 运行时加上一下两种jvm参数，观察输出情况；
 * 1. -XX:+PrintGC -XX:-DoEscapeAnalysis
 * 2. -XX:+PrintGC
 * -XX:-DoEscapeAnalysis关闭逃逸分析，结合gc情况，可以看出在关闭逃逸分析的情况下，会进行gc，gc主要是对堆这块垃圾回收
 */
public class AllocateMemoryOnStack {
    public static void main(String[] args) throws InterruptedException {

        long l = System.currentTimeMillis();
        for(int i = 50000000; i> 0; i --){
            // 调用方法后，里面的 obj 没有在别的地方引用，属于不可逃逸
            newObject();
        }
        System.out.println("一共执行了"+(System.currentTimeMillis()- l) +"ms");
    }
    static void newObject(){
        Object obj = new Object();
    }
}
