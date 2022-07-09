package ex02;

public interface UsersList {
    int DEFAULT_SIZE = 10;
    int DEFAULT_SCALE = 2;

    void addUser(User user);
     User retrieveUserById(int id) throws UserNotFoundException;
    User retrieveUserByIndex(int idx) throws ArrayIndexOutOfBoundsException;
    int retrieveNumberOfUsers();
}
