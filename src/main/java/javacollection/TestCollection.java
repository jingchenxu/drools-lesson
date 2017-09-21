package javacollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestCollection {
    //测试java的collection和collections

    /**
     * java.util.Collection是一个集合接口。它提供了对集合对象进行
     * 基本操作的通用接口方法。Collection接口在java类库中有很多具
     * 体的实现。Collection接口的意义是为了具体的集合提供了最大化
     * 的统一操作方式。
     */

    class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Test
    public void Test1() {
        List list = new ArrayList();
        double array[] = {112, 111, 23, 456, 231};
        for (int i = 0;i<array.length;i++) {
            list.add(new Double(array[i]));
        }
        Collections.sort(list);
        for (int i = 0; i<array.length;i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void Test2() {
        Collection<Person> personlist1 = new ArrayList<Person>();
        Collection<Person> personlist2 = new ArrayList<Person>();
        personlist2.add(new Person());
        personlist1.add(new Person());
        System.out.println("1:"+personlist1.toString());
        //addall用于数组集合的拼接
        personlist1.addAll(personlist2);
        System.out.println("2:"+personlist1.toString());
        //personlist1.clear();
        System.out.println("3:"+personlist1.toString());
        boolean ishave = personlist1.contains(new Person());
        System.out.println("4:"+ishave);
    }
}
