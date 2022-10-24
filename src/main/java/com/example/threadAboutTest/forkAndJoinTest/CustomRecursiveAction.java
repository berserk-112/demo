package com.example.threadAboutTest.forkAndJoinTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

/**
 * RecursiveAction 子任务无返回值
 */
public class CustomRecursiveAction extends RecursiveAction {

    private String workload = "";
    private static final int THRESHOLD = 4;

    private static Logger logger =
      Logger.getAnonymousLogger();

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            //划分子任务的方法1；
            ForkJoinTask.invokeAll(createSubtasks());
            //划分子任务的方法2；
/*

            for (CustomRecursiveAction subtask : createSubtasks()) {
                subtask.fork();
                subtask.join(); //join()等待subtask任务返回后才继续执行
            }
*/
        } else {
           processing(workload);
        }
    }

    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2);

        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));

        return subtasks;
    }

    private void processing(String work) {
        String result = work.toUpperCase();
        logger.info("This result - (" + result + ") - was processed by " 
          + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CustomRecursiveAction task = new CustomRecursiveAction("hello world");
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        /**
         * 运行task的方法一：
         */
        commonPool.execute(task);
        task.join();

        //方法二：
        commonPool.invoke(task);


        //方法三：
        task.exec();
    }
}