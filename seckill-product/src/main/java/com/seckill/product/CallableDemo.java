package com.seckill.product;

import java.util.concurrent.*;

public class CallableDemo {

    static class SumClass implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            Long sum = 0L;
            for (int i = 0; i < 9000; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(System.nanoTime());
        FutureTask<Long> futureTask = new FutureTask<>(new SumClass());
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(futureTask);
        System.out.println(futureTask.get());
        System.out.println(System.nanoTime());
    }
}
