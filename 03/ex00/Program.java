public class Program {

    private static final int ERROR_EXIT_CODE = -1;
    private static final int END_OF_PREFIX = 8;

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Wrong number of arguments");
            System.exit(ERROR_EXIT_CODE);
        }
        int count = Integer.parseInt(args[0].substring(END_OF_PREFIX));

        Egg egg = new Egg(count);
        Hen hen = new Hen(count);

        hen.start();
        egg.start();

        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++)
            System.out.println("HUMAN");
    }
}
