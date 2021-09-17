package com.wei.generics.test;

import com.wei.generics.*;
import org.junit.Test;

import java.util.*;

/**
 * @Author weiyongjian
 * @Description 泛型测试类
 * @Date
 */

public class DemoGenerics {

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(1);
        list.add("a String");

        Integer integer = (Integer) list.get(0);
        System.out.println(integer==1);
        String s = (String) list.get(1);
        System.out.println(s);

    }
    @Test
    public void test2(){
        List<String> list = new ArrayList<String>();
        list.add("XXX");
        list.add("dSS");
        list.add("SSs");
        list.add("SsS");
        list.add("Sss");
        list.add("SSz");
        for (String s : list) {
            System.out.println("XXX".equals(s.toUpperCase())||"SSS".equals(s.toUpperCase()));
        }
   }
    @Test
    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("XXX");
        list.add("dSS");
        list.add("SSs");
        list.add("SsS");
        list.add("Sss");
        list.add("SSz");
        for (String s : list) {
            System.out.println("XXX".equals(s.toUpperCase())||"SSS".equals(s.toUpperCase()));
        }
   }
    @Test
    public void test4(){
        HashSet<String> objects = new HashSet<>();
        objects.add("xiaohua");
        for (String s : objects) {
            System.out.println(s);
        }
        Iterator<String> iterator = objects.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
    @Test
    public void test5(){
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("key1","ww2");
        objectObjectHashMap.put("key2","ww3");
        objectObjectHashMap.put("key2","ww4");

        System.out.println(objectObjectHashMap.get("key2"));
        Map<String,String> hashMap = new HashMap<String, String>(){{put("xxx","zzz");put("sss","zkk");}};
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(hashMap.get(iterator.next()));
        }
    }
    @Test
    public void test6() throws InstantiationException, IllegalAccessException {
        GenericsFactory<String> stringGenericsFactory = new GenericsFactory<>(String.class);
        String instance = stringGenericsFactory.createInstance();
        String instance2 = stringGenericsFactory.createInstance();
        System.out.println(instance==instance2);
    }
    @Test
    public void test7() throws InstantiationException, IllegalAccessException {
        Map<String,String> map= new HashMap<String, String>(){{put("key","value");}};
        List<Map> list =new ArrayList<>();
        System.out.println(GenericsMethod.add(map,list));
    }
    @Test
    public void test8() throws InstantiationException, IllegalAccessException {
        GenericsObjectFactory<String> str = new GenericsObjectFactory<String>(String.class);
        String newInstance = str.createNewInstance();
        String newInstance1 = GenericsObjectFactory.createNewInstance(String.class);
        System.out.println(newInstance.getClass().isInstance(newInstance1));
    }
    @Test
    public void test9() throws InstantiationException, IllegalAccessException {
        List<?> listA= new ArrayList<Son>();
        List<? extends Father> listB= new ArrayList<Son>();

    }


}
