package ex01;
public class Program {

    private static final int ERROR_EXIT_CODE = -1;
    private static final int END_OF_PREFIX = 8;
    public static boolean isEggPrinted = false;

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Wrong number of arguments");
            System.exit(ERROR_EXIT_CODE);
        }

        int count = Integer.parseInt(args[0].substring(END_OF_PREFIX));

        Thread hen = new Thread(new Hen(count));
        Thread egg = new Thread(new Egg(count));
        egg.start();
        hen.start();

        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void printEgg() {
        if (isEggPrinted) {
            try {
                Program.class.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Egg");;
        isEggPrinted = true;
        Program.class.notify();
    }

    public static synchronized void printHen() {
        if (isEggPrinted == false) {
            try {
                Program.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hen");
        isEggPrinted = false;
        Program.class.notify();
    }
}
