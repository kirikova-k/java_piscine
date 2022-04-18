package ex03;
import java.util.Scanner;

public class Program {
    private static final String WEEK_TEXT = "Week ";
    private static final String END_OF_INPUT = "42";
    private static final int ERROR_EXIT_CODE = -1;
    private static final int MAX_TESTS = 5;
    private static final int MAX_WEEKS = 18;
    private static final int MIN_GRADE = 1;
    private static final int MAX_GRADE = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputWeek = scanner.nextLine();
        int weekNum = 1;
        long allGrades = 0;

        while (weekNum <= MAX_WEEKS && !inputWeek.equals(END_OF_INPUT)) {
            if (!inputWeek.equals(WEEK_TEXT + weekNum)) {
                System.exit(putIllegalArgument());
            }
            allGrades = packGrade(getMinGrade(scanner), allGrades, weekNum);
            weekNum++;
            inputWeek = scanner.nextLine();
        }
        scanner.close();
        for (int i = 1; i < weekNum; i++) {
            System.out.print(WEEK_TEXT + i + " ");
            putGraph(unpackGrade(i, allGrades));
        }
    }

    public static long packGrade(int minGrade, long allGrades, int index) {
        long ret;
        long powTen = 1;

        for (int i = 1; i < index; i++) {
            powTen *= 10;
        }
        ret = allGrades + (minGrade * powTen);
        return (ret);
    }

    public static int unpackGrade(int index, long allGrades)	{
        int ret;

        for (int i = 1; i < index; i++) {
            allGrades /= 10;
        }
        ret = (int)(allGrades % 10);
        return (ret);
    }

    private static void putGraph(int minGrade) {

        for (int i = 0; i < minGrade; i++) {
            System.out.print("=");
        }
        System.out.println(">");
    }

    private static int getMinGrade(Scanner scanner) {
        int min = MAX_GRADE;
        int current;

        for (int i = 0; i < MAX_TESTS; i++) {
            current = scanner.nextInt();
            if (current < MIN_GRADE || current > MAX_GRADE) {
                System.exit(putIllegalArgument());
            }
            min = (current < min) ? current : min;
        }
        scanner.nextLine();
        return (min);
    }

    private static int putIllegalArgument() {
        System.err.println("Illegal Argument");
        return (ERROR_EXIT_CODE);
    }

}
