package com.wei.proxy.staticproxy;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class PersonProxy implements IPersonDao {
    private IPersonDao target;

    public PersonProxy(IPersonDao target) {
        this.target = target;
    }

    public PersonProxy() {
    }

    @Override
    public int update() {
        System.out.println("更新操作前");
        target.update();
        System.out.println("更新操作后");
        return 0;
    }
}
