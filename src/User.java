package src;
public enum User {
    VISITOR(1), ZOOKEEPER(2), ADMIN(3);

    private final int userNumber; 

    User(int userNumber) {
        this.userNumber = userNumber; // associate int value with enum
    }

    // convert User to int
    public int getUserNumber() {
        return userNumber;
    }

    // convert int to User
    public static User getUserType(int intValue) {
        for (User u : User.values()) {
            if (u.userNumber == intValue) {
                return u;
            }
        }
        throw new IllegalArgumentException("No User with number " + intValue);
    }
}

