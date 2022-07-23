import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("I create threads...");
        Callable<Integer> myCallable1 = new MyCallable("thread one");
        Callable<Integer> myCallable2 = new MyCallable("thread two");
        Callable<Integer> myCallable3 = new MyCallable("thread three");
        Callable<Integer> myCallable4 = new MyCallable("thread four");
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Integer> task1 = threadPool.submit(myCallable1);
        Future<Integer> task2 = threadPool.submit(myCallable2);
        Future<Integer> task3 = threadPool.submit(myCallable3);
        Future<Integer> task4 = threadPool.submit(myCallable4);
        try {
            System.out.println(myCallable1 + " executed the task " + task1.get() + " times.");
            System.out.println(myCallable2 + " executed the task " + task2.get() + " times.");
            System.out.println(myCallable3 +" executed the task " + task3.get() + " times.");
            System.out.println(myCallable4 + " executed the task " + task4.get() + " times.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            Integer result = threadPool.invokeAny(Arrays.asList(myCallable1, myCallable2, myCallable3, myCallable4));
            System.out.println("The result of the fastest task" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("I complete all threads...");
        threadPool.shutdown();
    }
}
