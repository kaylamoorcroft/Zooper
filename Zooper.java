import java.util.Scanner;

public class Zooper {
    static User user;
    static String password = "admin";
    static boolean loggedIn = false;
    static Scanner sc = new Scanner(System.in);
    static ZooManager zoo = new ZooManager();

    public static boolean passwordCheck() {
        while (true) {
            System.out.print("\nEnter password: ");
            String pass = sc.next();
            if(pass.equals(password)) {
                loggedIn = true;
                return true;
            }
            //allows user to retry password or move back to main menu
            else {
                System.out.println("Incorrect password. Press 1 to try again or 2 to return to main menu.");
                int retry = sc.nextInt();
                
                //exit
                if(retry == 2) {
                    System.out.println();
                    return false;
                }
            }
        }
    }
    // display menu, but return false if unable to due to incorrect password
    public static boolean displayMenu() {
        String[] menuItems = { "Search for an animal", "Filter animals by continent", 
            "Display all animals", "Update animal", "Remove animal", "Add animal" };
        int i = 0;
        switch(user) {
            case VISITOR:
                System.out.println("\nWelcome to our zoo! How can we help you?");
                for (i = 0; i < 3 ; i++) 
                    System.out.printf("%d.) %s\n", i+1, menuItems[i]);
                break;
            case ZOOKEEPER:
                if (!loggedIn) if (!passwordCheck()) return false;  // check password before proceed
                System.out.println("\nHello! What do you wish to do?");
                for (i = 0; i < 4 ; i++) 
                    System.out.printf("%d.) %s\n", i+1, menuItems[i]);
                break;
            case ADMIN:
                if (!loggedIn) if (!passwordCheck()) return false;  // check password before proceed
                System.out.println("\nHello! What do you wish to do?");
                for (i = 0; i < 6 ; i++) 
                    System.out.printf("%d.) %s\n", i+1, menuItems[i]);
                break;
        }
        System.out.printf("%d.) %s\n", i+1, "Exit");  
        return true;     
    }

    public static void performMenuOption(MenuOption option) {
        switch(option) {
            case SEARCH:
                zoo.search();
                break;
            case FILTER:
                zoo.contDisplay();
                break;
            case DISPLAY:
                zoo.displaySummary();
                break;
            case UPDATE:
                System.out.println("Updating if zookeeper / admin...");
                zoo.updateAnimal();
                break;
            case REMOVE:
                System.out.println("Removing if admin...");
                zoo.deleteAnimal();
                break;
            case ADD:
                System.out.println("Adding if admin...");
                zoo.addAnimal();
                break;
        }
    }

    public static void main(String[] args) {
        int affSelect = 0;
        
        while(true) { // loop user selection
            //prompts user to select how to proceed through program
            System.out.println("Welcome to Zooper! Please select your affiliation to the Zoo: ");
            System.out.println("1.) Visitor\n2.) Zookeeper\n3.) Admin\n4.) Exit");
            affSelect = sc.nextInt();
            do { // loop option selection
                // display menu based on user selection - if invalid user selection, exit program
                try {
                    user = User.getUserType(affSelect);
                    if (!displayMenu()) break; // if not display menu due to incorrect password, exit to main menu
                }
                catch (java.lang.IllegalArgumentException e) {
                    zoo.writeToFile(); // save changed data before exit
                    System.out.println("\nHave a good day!");
                    sc.close();
                    System.exit(0);
                }

                // perform option that user selects - catch invalid int input
                int option = sc.nextInt();
                try{
                    performMenuOption(MenuOption.getMenuOption(option, user));
                }
                catch (java.lang.IllegalArgumentException e) {
                    System.out.println("Have a good day!");
                    break;
                }
            } while (true);
        }
    }
}
