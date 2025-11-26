import java.util.Scanner;

public class Person{
	Scanner sc = new Scanner(System.in);
	
	public Person() {}
	
	/**
	 * Display all animals from given continent
	 * @param zoo
	 */
	public void contDisplay(Zoo zoo) {
		while (0 != 1) {
			int restart = 0;
			String target = "";
			System.out.print("Enter the continent of animals you would like to see: ");
			target = sc.next().toUpperCase();
			
			if(target.equals("AFRICA")) {System.out.println(zoo.filter(Location.AFRICA));}
			else if(target.equals("NORTH AMERICA")) {System.out.println(zoo.filter(Location.NORTH_AMERICA));}
			else if(target.equals("SOUTH AMERICA")) {System.out.println(zoo.filter(Location.SOUTH_AMERICA));}
			else if(target.equals("ASIA")) {System.out.println(zoo.filter(Location.ASIA));}
			else if(target.equals("ANTARCTICA")) {System.out.println(zoo.filter(Location.ANTARCTICA));}
			else if(target.equals("AUSTRALIA")) {System.out.println(zoo.filter(Location.AUSTRALIA));}
			else if(target.equals("EUROPE")) {System.out.println(zoo.filter(Location.EUROPE));}
			else if(target.equals("UNKNOWN")) {System.out.println(zoo.filter(Location.UNKNOWN));}
			else {
				System.out.println("Invalid continent entered");
			}
			
			System.out.println("Enter 1 to search again. Enter 2 to return to main menu");
			restart = sc.nextInt();
			
			if(restart != 1) {
				System.out.println();
				break;
			}
		}
	}
	
	/**
	 * Update animal information (will finish when search operational
	 * @param zoo
	 */
	public void updateAnimal(Zoo zoo) {
		String name = "";
		String species = "";
		
		System.out.print("Enter the name of the animal you wish to update: ");
		name = sc.next();
		System.out.print("Enter the species of the animal you wish to update: ");
		species = sc.next();
		
		zoo.search(name, species);
	}
	
	/**
	 * Add animal to given zoo using zoo addAnimal function
	 * @param zoo
	 */
	public void addAnimal(Zoo zoo) {
		String species = "";
		String name = "";
		String continentStr = "";
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
				System.out.print("Enter Continent: ");
				continentStr = sc.next().toUpperCase();
					
				System.out.println("You entered " + continentStr
						+ ". Is this correct (1) or incorrect (2)?");
				confirmation = sc.nextInt();
					
				if(confirmation == 1) {
					continent = Utils.stringToLocation(continentStr);
					break;
				}
			}
		}
			
		zoo.addAnimal(name, species, age, continent);
	}
}