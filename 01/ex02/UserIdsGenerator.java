public class UserIdsGenerator {
    private int previousId;
    public static UserIdsGenerator getInstance() {
        return instance;
    }
    static private UserIdsGenerator instance = new UserIdsGenerator();

    public int generateId() {
        return ++previousId;
    }

    private UserIdsGenerator() {
        this.previousId = 0;
    }
}
