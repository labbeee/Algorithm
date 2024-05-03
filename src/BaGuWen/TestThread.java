package BaGuWen;


//Java中有几种方式来创建线程执行任务？

//方法1，继承Thread类, 重写的是run方法，而且Java中的类是单继承的，创建的testThread不可以继承其他类了
//public class TestThread extends Thread{
//    public static void main(String[] args) {
//        TestThread testThread = new TestThread();
//        testThread.start();
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Hello Java");
//    }
//}

////方法2. 实现Runnable接口, 实现run()方法，使用依旧要用到Thread， 这种方式更常见
//public class TestThread implements Runnable{
//    public static void main(String[] args) {
//        Thread thread = new Thread(new TestThread());
//
////        //用匿名内部类来实现Runnable
////        Thread thread1 = new Thread(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("Hello Java");
////            }
////        });
//        //用lambda表达式来实现Runnable方法
////        Thread thread1 = new Thread(() -> System.out.println("Hello Java"));
//        thread.start();
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Hello Java");
//    }
//}

import java.util.concurrent.*;

////方法3. 实现Callable接口
//public class TestThread implements Callable<String>{
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> futureTask = new FutureTask<>(new TestThread());
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        String result = futureTask.get();
//        System.out.println(result);
//    }
//
//    @Override
//    public String call(){
//        return "Hello Java";
//    }
//}

//方法4. 线程池来创建线程
public class TestThread {
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


