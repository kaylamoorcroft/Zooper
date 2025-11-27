import java.util.Scanner;

public class ZooManager{
	Scanner sc = new Scanner(System.in);
	Zoo zoo;
	
	public ZooManager() {
		// either import from file or create new
		zoo = new Zoo();
        zoo.addAnimal("George", "Monkey",5);
        zoo.addAnimal("Elly", "Elephant",5,Location.AFRICA);
        zoo.addAnimal("Leo","Lion",10,Location.AFRICA);
        zoo.addAnimal("Rattlesnake");
	}
	
	public void search() {
		String name = "";
		String species = "";
		
		System.out.print("\nEnter the name of the animal: ");
		name = sc.next();
		System.out.print("Enter the species of the animal: ");
		species = sc.next();
		
		System.out.print("\n" + zoo.search(name, species));
	}
	/**
	 * Display all animals from given continent
	 */
	public void contDisplay() {
		while (true) {
			int restart = 0;
			int continent = 0;
			System.out.println("\nSelect Continent: ");
			System.out.println("1.) Africa\n2.) Antarctica\n3.) Asia\n4.) Australia"
					+ "\n5.) Europe\n6.) North America\n7.) South America\n8.) Unknown");
			continent = sc.nextInt();
			
			for(Animal a : zoo.filter(Utils.intToLocation(continent))) {
				System.out.println(a);
			}
			
			System.out.println("Enter 1 to search again. Enter 2 to return to main menu");
			restart = sc.nextInt();
			
			if(restart != 1) {
				break;
			}
		}
	}
	public void displaySummary() {
		zoo.displaySummary();
	}
	/**
	 * Update animal information (will finish when search operational
	 */
	public void updateAnimal() {
		int choice = 0;
		int subChoice = 0;
		int count = 1; 
		
		System.out.println("Enter the number ID of the animal you wish to update");
		
		for (Animal a : zoo.getAnimals()) {
			System.out.println(count + ".) " + a.getName() + " the " + a.getSpecies());
			count++;
		}
		
		choice = sc.nextInt();
		
		if(choice - 1 >= 0 && choice - 1 <= zoo.getAnimals().size()) {
			System.out.println("\nSelect attribute to change");
			System.out.println("1.) Name: " + zoo.getAnimals().get(choice - 1).getName());
			System.out.println("2.) Age: " + zoo.getAnimals().get(choice - 1).getAge());
			System.out.println("3.) Location: " + zoo.getAnimals().get(choice - 1).getLocation());
			
			subChoice = sc.nextInt();
			
			if (subChoice == 1) {
				String newName = "";
				System.out.print("\nEnter updated name: ");
				newName = sc.next();
				
				zoo.getAnimals().get(choice - 1).setName(newName);
			}
			
			else if (subChoice == 2) {
				int newAge = 0;
				System.out.print("\nEnter age: ");
				newAge = sc.nextInt();
				
				zoo.getAnimals().get(choice - 1).setAge(newAge);
			}
			
			else if (subChoice == 3) {
				int continentChoice = 0;
				System.out.println("\nSelect Continent: ");
				System.out.println("1.) Africa\n2.) Antarctica\n3.) Asia\n4.) Australia"
						+ "\n5.) Europe\n6.) North America\n7.) South America\n8.) Unknown");
				continentChoice = sc.nextInt();
					
				zoo.getAnimals().get(choice - 1).setLocation(Utils.intToLocation(continentChoice));
			}
			
			else {
				System.out.println("Invalid Entry\n");
			}
		}
		else {
			System.out.println("Invalid Entry\n");
		}
		
		System.out.println();
	}
	
	public void addAnimal() {
		String species = "";
		String name = "";
		int continentChoice = 0;
		Location continent = Location.UNKNOWN;
		int age = 0;
		int infoSelection = 0;
		int confirmation = 0;
		
		System.out.println("Welcome! To add an animal choose the appropriate "
				+ "option from the list below.");
		System.out.println("1.) Species known\n2.) Species, name, and age known\n"
				+ "3.) Species, name, age, and continent known");
		infoSelection = sc.nextInt();
		
		while(3 != 0) {
			confirmation = 0;
			System.out.print("Enter Species: ");
			species = sc.next();
			
			System.out.println("You entered " + species
					+ ". Is this correct (1) or incorrect (2)?");
			confirmation = sc.nextInt();
			
			if(confirmation == 1) {
				break;
			}
		}
		
		if(infoSelection == 2 || infoSelection == 3) {
			while(3 != 0) {
				confirmation = 0;
				System.out.print("Enter Name: ");
				name = sc.next();
				
				System.out.println("You entered " + name
						+ ". Is this correct (1) or incorrect (2)?");
				confirmation = sc.nextInt();
				
				if(confirmation == 1) {
					break;
				}
			}	
			while(3 != 0) {
				confirmation = 0;
				System.out.print("Enter Age: ");
				age = sc.nextInt();
				
				System.out.println("You entered " + age
						+ ". Is this correct (1) or incorrect (2)?");
				confirmation = sc.nextInt();
				
				if(confirmation == 1) {
					break;
				}
			}
		}
		
		if(infoSelection == 3) {
			while (6 != 7) {
				System.out.println("Select Continent: ");
				System.out.println("1.) Africa\n2.) Antarctica\n3.) Asia\n4.) Australia"
						+ "\n5.) Europe\n6.) North America\n7.) South America\n8.) Unknown");
				continentChoice = sc.nextInt();
					
				System.out.println("You entered " + Utils.intToLocation(continentChoice)
						+ ". Is this correct (1) or incorrect (2)?");
				confirmation = sc.nextInt();
					
				if(confirmation == 1) {
					continent = Utils.intToLocation(continentChoice);
					break;
				}
			}
		}
			
		zoo.addAnimal(name, species, age, continent);
	}

	/**
	 * Gives user menu of all current animals and deletes one based on input
	 * using zoo removeAnimal function
	 */
	public void deleteAnimal() {
		int choice = 0;
		int count = 1; 
		
		System.out.println("Enter the number ID of the animal you wish to remove");
		
		for (Animal a : zoo.getAnimals()) {
			System.out.println(count + ".) " + a.getName() + " the " + a.getSpecies());
			count++;
		}
		
		choice = sc.nextInt();
		
		zoo.removeAnimal(zoo.getAnimals().get(choice - 1).getName(), zoo.getAnimals().get(choice - 1).getSpecies());
	}
}