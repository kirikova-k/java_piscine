package ex02;

import java.util.Scanner;

public class Program {
    private static final int ERROR_EXIT_CODE = -1;
    private static final int DEFAULT_EXIT_CODE = 0;
    private static final int EXACTLY_PRIME_NUM = 2;
    private static final int END_OF_INPUT = 42;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        int coffeRequests = 0;
        while (input != END_OF_INPUT){
            input = scan.nextInt();
            if (isPrime(sumOfDigits(input))) {
                coffeRequests++;
            }
        }
        scan.close();
        System.out.println("Count of coffee - request " + coffeRequests);
    }

    private static int sumOfDigits(int num) {
        int res = 0;
        while (num > 0) {
            res += num %10;
            num = num/10;
        }
        return (res);
    }

    private  static boolean isPrime(int num) {
          int sqrt;
          if (num < EXACTLY_PRIME_NUM) {
              System.err.println("Illegal Argument");
              System.exit(ERROR_EXIT_CODE);
          }
          else {
              sqrt = mySqrt(num);
              for (int i = 2; i < sqrt + 1; i++) {
                  if (num % i == 0){
                      return false;
                  }
          }
          return  true;
          }

        return true;
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

