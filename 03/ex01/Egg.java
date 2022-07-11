package ex01;
public class Egg implements Runnable {
    private int count;

    public Egg(int _count) {
        this.count = _count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++)
            Program.printEgg();
    }
}
