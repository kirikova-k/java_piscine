package ex00;
public class Egg extends  Thread {
    private int count;

    public Egg(int _count) {
        this.count = _count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            System.out.println("EGG");
        }
    }
}
