package com.bxbro.summer.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 场景：模拟10人赛跑。10人跑完后才喊 "Game Over."
 * @Author dong
 * @Date 2020/11/26
 */
public class CountDownLatchTest {

    private static final int RUNNER_COUNT = 10;


    /**
     * 疑问：
     * 1.CountDownLatch的应用场景一定是 任务可以计数的是吗？ 如果任务无法被计数，只是知道有一堆任务，还能否用CountDownLatch?
     * 2.CountDownLatch的应用场景一定是 同种类型的任务吗？
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < RUNNER_COUNT; i++) {
            int NO = i + 1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        begin.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + NO + " arrived.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            exec.submit(run);
        }
        System.out.println("Game Start...");

        // 如果不执行begin.countDown(),子进程会一直阻塞在begin.await()
        begin.countDown();

        // 主进程执行到end.await()阻塞等待end计数器清0，子进程中每执行一次CountDown()减1，所有执行完后主进程继续往下执行
        end.await();

        System.out.println("Game Over.");
        exec.shutdown();
    }
}
