public class Program {
    public static void main(String[] av) {
        UsersArrayList usersArrayList = new UsersArrayList();
        System.out.println(usersArrayList);
        usersArrayList.addUser(new User("A", 100));
        usersArrayList.addUser(new User("B", 100));
        usersArrayList.addUser(new User("C", 100));
        usersArrayList.addUser(new User("D", 100));
        usersArrayList.addUser(new User("E", 100));
        usersArrayList.addUser(new User("F", 100));
        usersArrayList.addUser(new User("G", 100));
        usersArrayList.addUser(new User("H", 100));
        usersArrayList.addUser(new User("I", 100));
        usersArrayList.addUser(new User("J", 100));
        System.out.println(usersArrayList);
        usersArrayList.addUser(new User("F", 100));
        System.out.println(usersArrayList);
        User retrievedUser = usersArrayList.retrieveUserByIndex(1);
        System.out.println(retrievedUser);
        User retrievedByIdUser = usersArrayList.retrieveUserById(5);
        System.out.println(retrievedByIdUser);

        int numberOfUsers = usersArrayList.retrieveNumberOfUsers();
        System.out.println("Number of users retrieved is: " + numberOfUsers);
        try {
            usersArrayList.retrieveUserById(100);
        }
        catch (UserNotFoundException e) {
            System.out.println(e);
        }

        try {
            usersArrayList.retrieveUserByIndex(100);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
