import java.util.concurrent.Callable;


public class MyCallable implements Callable<Integer> {
    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        Thread.currentThread().setName(name);
        while (count <= 3) {
            Thread.sleep(2500);
            System.out.println("I am " + Thread.currentThread().getName() + ". Hi all!");
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return name;
    }
}