package ex02;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Program {
    public static final int EXIT_ERROR_CODE = -1;
    public static final int ARR_LENGTH_POS = 12;
    public static final int NUM_OF_THREADS_POS = 15;

    public static void main(String[] args) {
        int arrLength = Integer.parseInt(args[0].substring(ARR_LENGTH_POS));
        int numOfThreads = Integer.parseInt(args[1].substring(NUM_OF_THREADS_POS));
        if (numOfThreads > arrLength) {
            System.err.println("Error: the number of threads must be less than the size of the array!\n");
            System.exit(EXIT_ERROR_CODE);
        }
        List<Integer> myList = new ArrayList<>(arrLength);
        for (int i = 0; i < arrLength; i++) {
            int rand = ThreadLocalRandom.current().nextInt() % 1000;
            myList.add(rand < 0 ? rand * -1 : rand);
        }

        System.out.println("Sum: " + calculateSumOfList(myList));

        int range = arrLength / (numOfThreads - 1);

        List<Thread> threadsList = new ArrayList<>(numOfThreads);

        int begin = 0;
        int last = 0;
        for (int i = 0; i < numOfThreads - 1; i++) {
            begin = i * range;
            last  = (i + 1) * range;
            threadsList.add(new myThread(myList.subList(begin, last), begin, last -1));
        }
        begin = (numOfThreads - 1) * range;
        last = arrLength;
        threadsList.add(new myThread(myList.subList(begin, last), begin, last -1));

        for (Thread thread : threadsList) {
            thread.start();
        }

        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum by threads: " + myThread.getSumOfThreads());
    }

    private static int calculateSumOfList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return  sum;
    }
}
