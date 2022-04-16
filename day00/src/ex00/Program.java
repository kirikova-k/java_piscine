// package ex00;

public class Program {

    public static void main(String[] args) {
	    int res;
        int res1;
        int res2;
        int res3;
        int res4;
        int res5;
	    int num = 479598;
        res = num%10;
	    num = num/10;
        res1 = num%10;
        num = num/10;
        res2 = num%10;
        num = num/10;
        res3 = num%10;
        num = num/10;
        res4 = num%10;
        num = num/10;
        res5 = num%10;
        System.out.println(res + res1 + res2 + res3 + res4 +res5);
    }
}
