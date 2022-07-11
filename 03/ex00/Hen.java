package ex00;
public class Hen extends Thread {
    private int count;

    public Hen(int _count) {
        this.count = _count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            System.out.println("HEN");
        }
    }
}
