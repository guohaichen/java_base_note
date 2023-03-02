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
        User user = new User("jack");
        user.setAge(15);
        System.out.println("user hasCode"+user.hashCode());
        User cloneUser = user.clone();
        user.setAge(18);
        System.out.println("cloneUser hasCode"+cloneUser.hashCode());
        //改变原引用类型，而克隆对象的引用类型还是指向原有属性的所指向的内存地址，如user.name已是new Name:tony，而clone对象还指向jack
        user.setName("new Name:tony");
        System.out.println(user.getName());
        //基本类型15->18
        System.out.println(cloneUser.getName()+":"+user.getAge());

        cloneUser.setName("clone change name");
        System.out.println(cloneUser.getName());
    }

    static class User implements Cloneable{
        private String name;

        private int age;
        public User() {
            System.out.println("原型构造");
        }
        public void setName(String name) {
            this.name = name;
        }
        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            System.out.println("clone User");
            return (User)super.clone();
        }
    }
}
