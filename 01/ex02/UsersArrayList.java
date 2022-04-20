public class UsersArrayList implements UsersList {

    private User[] usersStorage;
    private int usersCount;

    public UsersArrayList() {
        this.usersStorage = new User[DEFAULT_SIZE];
        this.usersCount = 0;
    }

    @Override
    public void addUser(User user) throws NullPointerException {
        if (user == null)
            throw new NullPointerException();
        if (usersCount < usersStorage.length) {
            usersStorage[usersCount++] = user;
            return;
        }
        User[] newUsersStorage = new User[usersStorage.length + usersStorage.length / DEFAULT_SCALE];
        for (int i = 0; i < usersStorage.length; i++) {
            newUsersStorage[i] = usersStorage[i];
        }
        usersStorage = newUsersStorage;
        usersStorage[usersCount++] = user;
    }

    @Override
    public User retrieveUserById(int id) throws UserNotFoundException {
        for (int i = 0; i < usersCount; i++) {
            if (usersStorage[i].getId() == id)
                return usersStorage[i];
        }
        throw new UserNotFoundException();
    }

    @Override
    public User retrieveUserByIndex(int idx) throws ArrayIndexOutOfBoundsException {
        if (idx > usersCount - 1 || idx < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        else {
            return usersStorage[idx];
        }
    }

    @Override
    public int retrieveNumberOfUsers() {
        return usersCount;
    }

    @Override
    public String toString() {
        String lineOne = "UsersArrayList\n";
        String lineTwo = "Has " + this.usersCount + " users\n";
        String lineThree = "Capacity is " + this.usersStorage.length + "\n";
        return lineOne + lineTwo + lineThree;
    }
}
