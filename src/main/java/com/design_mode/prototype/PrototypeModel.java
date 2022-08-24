package com.design_mode.prototype;

/**
 * @author cgh
 * @create 2022-08-23 9:03
 * 原型模式
 * 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型对象相同的新对象。
 * 需要克隆的对象需要实现Cloneable接口，重写clone()方法
 *      clone分为浅克隆和深克隆
 *      浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性（引用类型），仍指向原有属性所指向的对象的内存地址。
 *      深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 */
public class PrototypeModel {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        User cloneUser = user.clone();
        System.out.println("user hasCode"+user.hashCode());
        System.out.println("cloneUser hasCode"+cloneUser.hashCode());
    }

    static class User implements Cloneable{
        public User() {
            System.out.println("原型构造");
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            System.out.println("clone User");
            return (User)super.clone();
        }
    }
}
