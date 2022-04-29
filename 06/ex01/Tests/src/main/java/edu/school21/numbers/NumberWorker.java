package edu.school21.numbers;

public class NumberWorker {
    public static final int EXACTLY_PRIME_NUM_1 = 1;
    public static final int EXACTLY_PRIME_NUM_2 = 2;
    public static final int EXACTLY_PRIME_NUM_3 = 3;
    public static final int BASE = 10;

    public boolean isPrime(int number) {
        int i = 2;
        if (number <= EXACTLY_PRIME_NUM_1) {
            throw new IllegalNumberException("number <= 1");
        }
        if (number == EXACTLY_PRIME_NUM_2 || number == EXACTLY_PRIME_NUM_3) {
            return true;
        }
        int res = 0;
        while (res < number) {
            res = i * i;
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int digitsSum(int number) {
        int result = 0;
        while (number > 0) {
            int tmp = number % BASE;
            result += tmp;
            number /= BASE;
        }
        return result;
    }

}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String message) {
        System.err.println(message);
    }
}
