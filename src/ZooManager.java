package src;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ZooManager{
	Scanner sc = new Scanner(System.in);
	Zoo zoo;
	String filename = "data.txt";
	
	public ZooManager() {
		// read existing data from file
		zoo = new Zoo();
		readFromFile();
	}

	public void writeToFile() {
        try {
            FileWriter writer = new FileWriter(filename);
			for (Animal a : zoo.getAnimals()) {
				writer.write(a.getRecord() + "\n");
			}
            writer.close();
            System.out.println("Saved new zoo state");
        }

        // Exception Thrown
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
	}

	private void readFromFile() {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
          
            // Traversing File Data
          	while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] attributes = data.split(","); // Splits by comma
				int age = 0, locationInt = 8;
				try {
					age = Integer.parseInt(attributes[2]);
					locationInt = Integer.parseInt(attributes[3]);
				} catch (NumberFormatException e) {
					System.out.println("Cannot complete import from file...");
					reader.close();
					return;
				}
				zoo.addAnimal(attributes[0],attributes[1],age,Location.getLocation(locationInt));
            }
          
            reader.close();
        }
        
        // Exception Cases
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
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
		int restart = 0;
		do {
			int continent = 0;
			System.out.println("\nSelect Continent: ");
			for (Location loc : Location.values()) {
				System.out.println(loc.getLocationNumber() + ".) " + loc);
			}
			continent = sc.nextInt();
			
			for(Animal a : zoo.filter(Location.getLocation(continent))) {
				System.out.println(a);
			}
			
			System.out.println("Enter 1 to search again. Enter 2 to return to main menu");
			restart = sc.nextInt();

		} while(restart == 1);
	}
	public void displaySummary() {
		zoo.displaySummary();
	}
	/**
	 * Update animal information (will finish when search operational
	 */
	public void updateAnimal() {
		int index = 0;
		int choice = 0;
		int count = 1; 
		
		System.out.println("Enter the number ID of the animal you wish to update");
		
		for (Animal a : zoo.getAnimals()) {
			System.out.println(count + ".) " + a.getName() + " the " + a.getSpecies());
			count++;
		}
		
		index = sc.nextInt() - 1;
		if (index < 0 || index > zoo.getAnimals().size() - 1) {
			System.out.println("Invalid selection...\n\n");
			return;
		}
		
		System.out.println("\nSelect attribute to change");
		System.out.println("1.) Name: " + zoo.getAnimals().get(index).getName());
		System.out.println("2.) Age: " + zoo.getAnimals().get(index).getAge());
		System.out.println("3.) Location: " + zoo.getAnimals().get(index).getLocation());
		System.out.println("or... select 4.) to age animal up");
		
		choice = sc.nextInt();

		switch(choice) {
			case 1:
				String newName = "";
				System.out.print("\nEnter updated name: ");
				newName = sc.next();
				
				if (zoo.updateAnimalName(index, newName) == null) {
					System.out.println("\nUnable to update... There is already a(n) " + zoo.getAnimals().get(index).getSpecies() + " with name " + newName);
				}
				else {
					System.out.println("\nSuccessfully updated animal name");
				}
				break;
			case 2:
				int newAge = 0;
				System.out.print("\nEnter age: ");
				newAge = sc.nextInt();
				
				zoo.updateAnimalAge(index, newAge);
				System.out.println("\nSuccessfully updated animal age");
				break;
			case 3:
				int continentChoice = 0;
				System.out.println("\nSelect Continent: ");
				for (Location loc : Location.values()) {
					System.out.println(loc.getLocationNumber() + ".) " + loc);
				}
				continentChoice = sc.nextInt();
					
				try{ 
					zoo.updateAnimalLocation(index, Location.getLocation(continentChoice));
					System.out.println("\nSuccessfully updated animal location");
				}
				catch(IllegalArgumentException e) {
					System.out.println("Invalid input...\n");
				}
				break;
			case 4:
				zoo.ageUpAnimal(index);
				System.out.println("\nSuccessfully updated animal age");
				break;
			default:
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
		
		switch(infoSelection) {
			case 3:
				System.out.println("Select Continent: ");
				for (Location loc : Location.values()) {
					System.out.println(loc.getLocationNumber() + ".) " + loc);
				}
				continentChoice = sc.nextInt();
				boolean retry = false;
				do {
					try {
						continent = Location.getLocation(continentChoice);
						retry = false;
					}
					catch (IllegalArgumentException e) {
						System.out.println("Invalid input... please try again.");
						retry = true;
					}
				} while (retry);
			case 2:
				System.out.print("Enter Name: ");
				name = sc.next();

				System.out.print("Enter Age: ");
				age = sc.nextInt();
			case 1:
				System.out.print("Enter Species: ");
				species = sc.next();
				break;
			default:
				System.out.println("Invalid input...");
		}
		
		System.out.println("Confirm (1) or reenter info (2)?");
		confirmation = sc.nextInt();
		if (confirmation == 2) { // redo
			addAnimal();
			return;
		}
		if (!zoo.addAnimal(name, species, age, continent)) {
			System.out.println("Unable to add new animal... there is already a(n) " + species + " with name " + name);
		}
		else {
			System.out.println("\nSuccessfully added new animal\n");
		}
	}

	/**
	 * Gives user menu of all current animals and deletes one based on input
	 * using zoo removeAnimal function
	 */
	public void deleteAnimal() {
		int index = 0;
		int count = 1; 
		
		System.out.println("Enter the number ID of the animal you wish to remove");
		
		for (Animal a : zoo.getAnimals()) {
			System.out.println(count + ".) " + a.getName() + " the " + a.getSpecies());
			count++;
		}
		
		index = sc.nextInt() - 1;
		Animal removedAnimal = zoo.removeAnimal(index);
		if(removedAnimal == null) {
			System.out.println("\nError removing animal");
		}
		else {
			System.out.println("\nSuccessfully removed " + removedAnimal.getName() + " the " + removedAnimal.getSpecies());
		}
	}
}