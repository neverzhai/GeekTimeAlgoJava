package geektime.algo.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 17:53
 * @description:
 */
public class LearnSourceDemo {

    public static void main(String[] args) {
        new HashMap();
        new Hashtable<>();
        new ReentrantLock();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        LinkedList<Object> list = new LinkedList<>();


//        ArrayList<Person> array = new ArrayList<Person>();
//
//        Person p1 = new Person("Tom1");
//        Person p2 = new Person("Tom2");
//        Person p3 = new Person("Tom3");
//        Person p4 = new Person("Tom4");
//
//        array.add(p1);
//        array.add(p2);
//        array.add(p3);
//        array.add(p4);
//
//        Iterator<Person> iterator = array.iterator();
//
//        for (Person pp : array){
//            System.out.println(pp.getName());
//        }
//
//        System.out.println("\r\n" + "-----利用Lambda表达式的foreach-----" + "\r\n");
//        array.forEach(obj -> System.out.println(obj.getName()));
//
//
//        System.out.println("\r\n" + "-----利用for循环-----" + "\r\n");
//        for(Person p : array){
//            p.setName("wang");
//        }
//
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().getName()); //输出的是wang，而不是tom

    }

}