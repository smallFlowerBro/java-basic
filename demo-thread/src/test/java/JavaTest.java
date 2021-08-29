import com.wei.thread.thread.*;
import org.junit.Test;

import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class JavaTest {


    /*线程初始化*/
    @Test
    public void test() throws Exception {
        new Thread(new ThreadOne()).start();
        new ThreadTwo().start();
        FutureTask<String> stringFutureTask = new FutureTask<String>(new ThreadThree());
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
    }
    /*线程池*/
    @Test
    public void test1() throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                20,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>( ));
        for(int i =0;i<20;i++){
            System.out.println("线程"+i+"开启");
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+";start");
                    for(int j=0;j<1000;j++){
                        System.out.println(Thread.currentThread().getName()+";"+j);
                    }
                    System.out.println(Thread.currentThread().getName()+";end");
                }
            });
        }
        while(threadPoolExecutor.getActiveCount()!=0){
            Thread.sleep(1000);
        }
    }
    @Test
    public  void test2(){
        Ticket ticket = new Ticket(200);
        new Thread(new Platform(ticket,"杭州")).start();
        new Thread(new Platform(ticket,"泰安")).start();
    }
}
