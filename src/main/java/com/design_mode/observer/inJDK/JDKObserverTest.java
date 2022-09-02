package com.design_mode.observer.inJDK;

/**
 * @author cgh
 * @create 2022-09-02 15:30
 * jdk中自带的观察者模式实现
 * java.util.Observable和java.util.Observer
 * Observable类是抽象目标类（被观察者），它有一个Vector集合成员变量，用于保存所有要通知的观察者对象。
 * - void addObserver(Observer o)：用于将新的观察者对象添加到集合中。
 * - void notifyObservers(Object arg)：调用集合中的所有观察者对象的update方法，通知他们数据发生改变。通常越晚加入集合的观察者越先得到通知。
 * - void setChange()：用来设置一个boolean类型的累不标志，注明目标对象发生了变化。当它为true是，notifyObservers()才会通知观察者。
 * Observer接口是抽象观察者，它监视目标对象的变化，当目标对象发生变化时，观察者得到通知，并调用update方法，进行相应的工作。
 */
public class JDKObserverTest {
    public static void main(String[] args) {

        Thief thief = new Thief("小偷");

        Policemen sir = new Policemen("谭sir");
        //将sir观察者添加到vector中
        thief.addObserver(sir);

        thief.steal();
    }
}
