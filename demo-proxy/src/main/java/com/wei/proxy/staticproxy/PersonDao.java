package com.wei.proxy.staticproxy;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class PersonDao implements IPersonDao {
    @Override
    public int update() {
        System.out.println("正在执行更新操作");
        return 0;
    }
}
