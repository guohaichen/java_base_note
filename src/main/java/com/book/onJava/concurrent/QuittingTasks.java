package com.book.onJava.concurrent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author cgh
 * @create 2022-07-10 16:32
 */
public class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<QuittableTask> tasks = IntStream.range(1,COUNT)
                .mapToObj(QuittableTask::new)
                .peek(quittableTask -> threadPool.execute(quittableTask))
                .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        threadPool.shutdown();
    }
}
