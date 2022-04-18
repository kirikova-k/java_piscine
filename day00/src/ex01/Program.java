package ex01;
import java.util.Scanner;

public class Program {
    private static final int ERROR_EXIT_CODE = -1;
    private static final int DEFAULT_EXIT_CODE = 0;
    private static final int EXACTLY_PRIME_NUM = 2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int input = scan.nextInt();
        boolean isInputPrime = true;
        int steps = 0;
        int sqrt;
        if (input < EXACTLY_PRIME_NUM) {
            System.err.println("Illegal Argument");
            System.exit(ERROR_EXIT_CODE);
        }
        if (input == EXACTLY_PRIME_NUM){
            System.out.println(isInputPrime + " " + 1);
        }
        else {
            sqrt = mySqrt(input);
            for (int i = 2; i < sqrt + 1; i++) {
                steps++;
                if (input % i == 0){
                    isInputPrime = false;
                    break;
                }
            }
            System.out.println(isInputPrime + " " + steps);
        }
        scan.close();
        System.exit(DEFAULT_EXIT_CODE);
    }
    private static int mySqrt(int input) {
        long start = 1;
        long end = input;
        long ret = 0;
        long mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == input) {
                return ((int) mid);
            } else if (mid * mid < input) {
                start = mid + 1;
                ret = mid;
            } else {
                end = mid - 1;
            }
        }
        return (int) ret;
    }
}
