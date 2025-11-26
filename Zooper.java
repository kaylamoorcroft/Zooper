import java.util.Scanner;

public class Zooper {
    // login / user selection
    // menus according to google doc
    // based on user selection from menus, call appropriate functions from Zoo.java
    // should probably save / read from file so that you don't start with a blank Zoo each time you run the code

    // example of how to use the zoo class - you can delete this or comment it out
    public static void main(String[] args) {
    	// create zoo and add animals
    	Zoo zoo = new Zoo();
    	Scanner sc = new Scanner(System.in);
        zoo.addAnimal("George", "Monkey",5);
        zoo.addAnimal("Elly", "Elephant",5,Location.AFRICA);
        zoo.addAnimal("Leo","Lion",10,Location.AFRICA);
        zoo.addAnimal("Rattlesnake");
    	Person user = new Person();
    	int affSelect = 0;
    	
    	while(true) {
    		//prompts user to select how to proceed through program
    		System.out.println("Welcome to Zooper! Please select your affiliation to the Zoo: ");
        	System.out.println("1.) Visitor\n2.) Zookeeper\n3.) Admin\n4.) Exit");
        	affSelect = sc.nextInt();
        	
        	//visitor state
    		if(affSelect == 1) {
        		while (true) {
        			//visitor menu that allows interaction with limited functionality
        			int option = 0;
        			System.out.println("\nWelcome to our zoo! How can we help you? ");
            		System.out.println("1.) Search for an animal\n2.) Filter animals by continent"
            				+ "\n3.) Display all animals\n4.) Exit");
            		
            		option = sc.nextInt();
            		
            		//search use case
            		if(option == 1) {
            			String name = "";
            			String species = "";
            			
            			System.out.print("\nEnter the name of the animal: ");
            			name = sc.next();
            			System.out.print("Enter the species of the animal: ");
            			species = sc.next();
            			
            			System.out.print("\n" + zoo.search(name, species));
            		}
            		
            		//filter use case
            		else if(option == 2) {
            			user.contDisplay(zoo);
            		}
            		
            		//display zoo use case
            		else if(option == 3) {
            			zoo.displaySummary();
            		}
            		
            		//exit
            		else if(option == 4) {
            			System.out.println("Thank you for visiting!\n");
            			break;
            		}
            		
            		//catch for invalid int input
            		else {
            			System.out.println("Invalid selection\n");
            		}
        		}
        	}
        	
    		//zookeepper state
        	else if(affSelect == 2) {
        		while(0 != 1) {
        			//password check
        			String pass = "";
        			System.out.print("\nEnter password: ");
        			pass = sc.next();
        			
        			//correct password entered check
        			if(pass.equals("admin")) {
        				while (0 != 1) {
        					//zookeeper menu with less limited functionality
        	    			int option = 0;
        	    			System.out.println("\nHello! What do you wish to do? ");
        	        		System.out.println("1.) Search for an animal\n2.) Filter animals by continent"
        	        				+ "\n3.) Display all animals\n4.) Update animal\n5.) Exit");
        	        		
        	        		option = sc.nextInt();
        	        		
        	        		//search use case
        	        		if(option == 1) {
        	        			String name = "";
        	        			String species = "";
        	        			
        	        			System.out.print("\nEnter the name of the animal: ");
        	        			name = sc.next();
        	        			System.out.print("Enter the species of the animal: ");
        	        			species = sc.next();
        	        			
        	        			System.out.print("\n" + zoo.search(name, species));
        	        		}
        	        		
        	        		//filter use case
        	        		else if(option == 2) {
        	        			user.contDisplay(zoo);
        	        		}
        	        		
        	        		//display zoo use case
        	        		else if(option == 3) {
        	        			zoo.displaySummary();
        	        		}
        	        		
        	        		//update animal use case
        	        		else if(option == 4) {
        	        			user.updateAnimal(zoo);
        	        		}
        	        		
        	        		//exit
        	        		else if(option == 5) {
        	        			System.out.println("Have a good day!\n");
        	        			break;
        	        		}
        	        		
        	        		//catch for invalid int input
        	        		else {
        	        			System.out.println("Invalid selection\n");
        	        		}
        				}
        			}
        			
        			//incorrect password check
        			else {
        				//allows user to retry password or move back to main menu
        				int retry = 0;
        				System.out.println("Incorrect password. Press 1 to try again or 2 to return to main menu.");
        				retry = sc.nextInt();
        				
        				//exit
        				if(retry == 2) {
        					System.out.println();
        					break;
        				}
        			}
        			break;
        		}
        	}
        	
    		//admin state
        	else if(affSelect == 3) {
        		while(0 != 1) {
        			//password check
        			String pass = "";
        			System.out.print("\nEnter password: ");
        			pass = sc.next();
        			
        			//correct password check
        			if(pass.equals("admin")) {
        				while (0 != 1) {
        					//admin menu with full functionality
        	    			int option = 0;
        	    			System.out.println("\nHello! What do you wish to do? ");
        	        		System.out.println("1.) Search for an animal\n2.) Filter animals by continent"
        	        				+ "\n3.) Display all animals\n4.) Update animal\n5.) Remove animal"
        	        				+ "\n6.) Add animal\n7.) Exit");
        	        		
        	        		option = sc.nextInt();
        	        		
        	        		//search use case
        	        		if(option == 1) {
        	        			String name = "";
        	        			String species = "";
        	        			
        	        			System.out.print("\nEnter the name of the animal: ");
        	        			name = sc.next();
        	        			System.out.print("Enter the species of the animal: ");
        	        			species = sc.next();
        	        			
        	        			System.out.print("\n" + zoo.search(name, species));
        	        		}
        	        		
        	        		//filter use case
        	        		else if(option == 2) {
        	        			user.contDisplay(zoo);
        	        		}
        	        		
        	        		//display zoo use case
        	        		else if(option == 3) {
        	        			zoo.displaySummary();
        	        		}
        	        		
        	        		//update animal use case
        	        		else if(option == 4) {
        	        			user.updateAnimal(zoo);
        	        		}
        	        		
        	        		//remove animal use case
        	        		else if(option == 5) {
        	        			user.deleteAnimal(zoo);
        	        		}
        	        		
        	        		//add animal use case
        	        		else if(option == 6) {
        	        			user.addAnimal(zoo);
        	        		}
        	        		
        	        		//exit
        	        		else if(option == 7) {
        	        			System.out.println("Have a good day!\n");
        	        			break;
        	        		}
        	        		
        	        		//catch invalid int input
        	        		else {
        	        			System.out.println("Invalid selection\n");
        	        		}
        				}
        				break;
        			}
        			
        			//incorrect password check
        			else {
        				int retry = 0;
        				System.out.println("Incorrect password. Press 1 to try again or 2 to return to main menu.");
        				retry = sc.nextInt();
        				
        				if(retry == 2) {break;}
        			}
        		}
        	}
    		
    		//exit
    		if(affSelect == 4) {
    			System.out.println("Have a good day!");
    			break;
    		}
    	}
    	sc.close();
    }  
}