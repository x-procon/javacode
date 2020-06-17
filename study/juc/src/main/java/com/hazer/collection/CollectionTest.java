package com.hazer.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: 多个线程同事执行添加线程不安全
 * @author: Hazer
 * @date: 2020-06-12 10:36
 */
public class CollectionTest {
    public static void main(String[] args) {
       CollectionTest collectionTest = new CollectionTest();
       // collectionTest.newArrayList();  //线程不安全ConcurrentModificationException
       // collectionTest.newVector();  //增加synchronized关键字线程安全
       // collectionTest.newCollections(); //增加synchronize代码块线程安全
        collectionTest.newCopyOnWriteArrayList(); //增加lock锁线程安全

    }

    //arrayList
    private void newArrayList(){
        List<String> list = new ArrayList();
        for(int i = 0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },"线程:"+i).start();
        }
    }

    //Vector
    private void newVector(){
        List<String> list = new Vector<>();
        for(int i = 0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },"线程:"+i).start();
        }
    }


    //synchronizedList
    private void newCollections(){

        List<String> list =  Collections.synchronizedList(new ArrayList<>());
        for(int i = 0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },"线程:"+i).start();
        }
    }


    //CopyOnWriteArrayList
    private void newCopyOnWriteArrayList(){

        List<String> list =  new CopyOnWriteArrayList<>();
        for(int i = 0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },"线程:"+i).start();
        }
    }
}
