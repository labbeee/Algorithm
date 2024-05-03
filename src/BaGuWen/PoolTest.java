package BaGuWen;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        // 3 + 3 = 6，当办理的业务数小于6时只使用核心线程：线程1、2、3，
        // 当办理的业务数大于3 + 3 小于5 + 3 = 8 会使用最大线程数：线程1、2、3、4、5，
        // 超过8之后采用拒绝策略，默认抛出异常
        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName() + "===>办理业务");
            });
        }
        threadPoolExecutor.shutdown();
    }
}
