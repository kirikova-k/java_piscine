
import java.util.List;

public class myThread extends Thread{
    private static int sumOfThreads = 0;
    int begin;
    int last;
    int localSum;


    private static synchronized void addToSum(int localSum, int b, int l) {
        System.out.println(Thread.currentThread().getName() +
                ": from " + b + " to " + l + " sum is " + localSum);
        sumOfThreads += localSum;
    }

    public static int getSumOfThreads() {
        return sumOfThreads;
    }

    public myThread(List<Integer> sublist, int b, int l) {
        this.begin = b;
        this.last = l;
        localSum = 0;
        for (int x : sublist) {
            localSum += x;
        }
    }

    @Override
    public void run() {
        addToSum(localSum, begin, last);
    }
}
