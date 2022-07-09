package ex01;

public class Program {
    public static void main(String[] av) {
        System.out.println("-----------------USER_TESTS-----------------------");
        System.out.println("---Create new user---");
        User userOne = new User("John", 15);
        System.out.println("User name: " + userOne.getName());
        System.out.println("User id: " + userOne.getId());
        System.out.println("User balance: " + userOne.getBalance());
        User userTwo = new User("Kate", -1);
        System.out.println("User name: " + userTwo.getName());
        System.out.println("User id: " + userTwo.getId());
        System.out.println("User balance: " + userTwo.getBalance());
        System.out.println("---Create new user---");
        User userThree = new User("Jack", 1000);
        System.out.println("User name: " + userThree.getName());
        System.out.println("User id: " + userThree.getId());
        System.out.println("User balance: " + userThree.getBalance());
    }
}
