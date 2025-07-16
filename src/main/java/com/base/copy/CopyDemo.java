package com.base.copy;

/**
 * @author cgh
 * @create 2025/7/16
 * 深浅拷贝程序，浅拷贝见程序中的代码注释
 * <p>
 * 而 深拷贝 则是递归层级的完全拷贝
 * 深拷贝会递归复制所有层级的属性：
 * <p>
 * 基本类型和不可变对象与浅拷贝一致。不会改变原对象
 * 引用类型属性会创建新的对象实例，形成与原对象完全独立的对象图
 * 修改副本的任何属性都不会影响原对象
 * notice 1. ArrayList的clone()方法为浅拷贝，仅复制数组引用： 2. Arrays.copyOf对基本类型数组是深拷贝，对对象数组是浅拷贝。
 * 深拷贝的优势是 数据隔离，适用于独立修改对象且不影响原数据的场景。
 */
public class CopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        //使用java的 Object.clone 方法实现浅拷贝
        User java = new User(29, "java", new Address("USA"));
        User copy = java.clone();
        // 这里 改变 浅拷贝对象的 基本类型和 不可变类型 String，并不会改变 原对象的属性，而 如果改变拷贝对象的 引用对象，则也会影响到 原对象
        copy.name = ("copy");
        copy.age = 16;
        copy.address.city = "四川";

        System.out.println(copy);
        System.out.println(java);

    }

    //java默认提供了 Clone接口，clone方法，默认的Object.clone就是浅拷贝，需显式实现Clone接口
    static class User implements Cloneable {
        private int age;
        private String name;
        private Address address;

        public User(int age, String name, Address address) {
            this.age = age;
            this.name = name;
            this.address = address;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", address=" + address +
                    '}';
        }
    }

    static class Address {
        String city;

        public Address(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    '}';
        }
    }
}
