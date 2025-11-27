public enum MenuOption {
    SEARCH(1), FILTER(2), DISPLAY(3), UPDATE(4), REMOVE(5), ADD(6);

    private final int number; 

    MenuOption(int number) {
        this.number = number; // associate int value with enum
    }

    // convert MenuOption to int
    public int getNumber() {
        return number;
    }

    // convert int to MenuOption
    public static MenuOption getMenuOption(int intValue, User user) {
        for (MenuOption opt : MenuOption.values()) {
            if (opt.number == intValue) {
                // throw exceptions if user does not have appropriate privileges
                if (opt == UPDATE && user == User.VISITOR) 
                    throw new IllegalArgumentException("Visitor cannot perform UPDATE");
                if (opt == REMOVE && user != User.ADMIN) 
                    throw new IllegalArgumentException("Only admin can perform REMOVE");
                if (opt == ADD && user != User.ADMIN) 
                    throw new IllegalArgumentException("Only admin can perform ADD");
                return opt;
            }
        }
        throw new IllegalArgumentException("No User with number " + intValue);
    }
}

