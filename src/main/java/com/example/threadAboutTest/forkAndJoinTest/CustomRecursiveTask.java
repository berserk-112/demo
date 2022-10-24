package com.example.threadAboutTest.forkAndJoinTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private int[] arr;

    private static final int THRESHOLD = 20;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            int sum = 0;
            for (CustomRecursiveTask subtask : createSubtasks()) {
                subtask.fork();
                sum += subtask.join();
            }
            return sum;

/*
方法二
            return ForkJoinTask.invokeAll(createSubtasks())
              .stream()
              .mapToInt(ForkJoinTask::join)
              .sum();
*/
        } else {
            return processing(arr);
        }
    }

    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new CustomRecursiveTask(
          Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomRecursiveTask(
          Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
        return dividedTasks;
    }

    private Integer processing(int[] arr) {
        return Arrays.stream(arr)
          .filter(a -> a > 10 && a < 27)
          .map(a -> a * 10)
          .sum();
    }

    public static void main(String[] args) {
        CustomRecursiveTask task = new CustomRecursiveTask(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11});
        //创建forkJoinPool的两种方式
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
//        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        /**
         * 运行task的方法一：
         */
        commonPool.execute(task);
        Integer result = task.join();
        System.out.println("result is " + result);

        //方法二：
        commonPool.invoke(task);


        //方法三：
        task.exec();
    }
}