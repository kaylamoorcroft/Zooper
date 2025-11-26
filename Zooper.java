import java.util.Scanner;

public class Zooper {
    // login / user selection
    // menus according to google doc
    // based on user selection from menus, call appropriate functions from Zoo.java
    // should probably save / read from file so that you don't start with a blank Zoo each time you run the code

    // example of how to use the zoo class - you can delete this or comment it out
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter admin password: ");
        String pass = sc.next();
        
        System.out.println(pass);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	// create zoo and add animals
        Zoo zoo = new Zoo();
        zoo.addAnimal("George", "Monkey",5);
        zoo.addAnimal("Elly", "Elephant",5,Location.AFRICA);
        zoo.addAnimal("Leo","Lion",10,Location.AFRICA);
        zoo.addAnimal("Rattlesnake");
        
        // make updates
        zoo.updateAnimal("George", "Monkey", Location.ASIA);
        zoo.updateAnimal("", "Rattlesnake", 2, Location.AUSTRALIA, "Bob");
        
        // initial zoo state
        System.out.println("---Initial zoo state---");
        zoo.displaySummary();

        // more updates
        System.out.println("---George dies and Elly ages up---");
        zoo.removeAnimal("George", "Monkey");
        zoo.ageUpAnimal("Elly", "Elephant");

        // new zoo state
        zoo.displaySummary();

        // filter
        System.out.println("---All animals in Africa---");
        for (Animal a : zoo.filter(Location.AFRICA)) {
            System.out.println(a);
        }
        // the following example represents the format of what it would look like in the program, minus the user input
        System.out.println("---All animals in Australia---");
        int location = 4; // you would prompt the user with a list of each location with nums 0-6 following the list in Location.java
        // the 4th index in the Location enum corresponds to Australia
        for (Animal a : zoo.filter(Location.values()[location])) {
            System.out.println(a);
        }

        // search
        System.out.println("---Search for Leo the Lion---");
        System.out.println(zoo.search("Leo", "Lion"));
        System.out.println("---Search for George the Monkey---");
        System.out.println(zoo.search("George", "Monkey"));
        // the following example represents the format of what it would look like in the program, minus the user input
        System.out.println("---Search for George the Monkey with error checking---");
        String name = "George";
        String species = "Monkey";
        Animal animal = zoo.search(name, species);
        if (animal == null) {
            System.out.println("Could not find " + name + " the " + species);
        }
        else {
            System.out.println(animal);
        }
        
        sc.close();
    }
}
