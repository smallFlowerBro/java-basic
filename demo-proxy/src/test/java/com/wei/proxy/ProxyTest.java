package com.wei.proxy;

import com.wei.proxy.cglibproxy.CglibProxy;
import com.wei.proxy.cglibproxy.UserDao;
import com.wei.proxy.staticproxy.PersonDao;
import com.wei.proxy.staticproxy.PersonProxy;
import org.junit.Test;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class ProxyTest {

    @Test
    public void test1(){

    //      PersonDao personDao= new PersonProxy<PersonDao>(new PersonDao()).getProxy();
    //      personDao.update();
    //      System.out.println(new PersonProxy<PersonDao>(new PersonDao()).getProxy());
    //      ((IPersonDao)new MyProxy<PersonDao>(new PersonDao()).getProxy()).update();
    //      ((List)(new MyProxy<ArrayList>(new ArrayList<String>()))).add("ssss");
        Object proxy = new CglibProxy(new UserDao()).getProxy();
        ((UserDao)proxy).insert();
    }
    @Test
    public  void test2() {
        PersonDao personDao = new PersonDao();
        PersonProxy personProxy = new PersonProxy(personDao);
        personProxy.update();
    }
}
