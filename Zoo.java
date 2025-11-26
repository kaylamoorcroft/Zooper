import java.util.ArrayList;

public class Zoo {
     private ArrayList<Animal> animals;

     /** Create a new empty zoo */
     public Zoo() {
         animals = new ArrayList<Animal>(); 
     }
     /** Copy over an existing zoo */
     public Zoo(ArrayList<Animal> animals) {
         this.animals = animals; 
     }
     /**
     * Add a new animal to the zoo when only the species is known
     * @param species
     */
     public void addAnimal(String species) {
          animals.add(new Animal(species));
     }
     /**
     * Add a new animal to the zoo with an unknown location
     * @param name - given name (eg. "Fred")
     * @param species - general animal name (eg. "spider monkey")
     * @param age - how old the animal is in years
     */
     public void addAnimal(String name, String species, int age) {
          animals.add(new Animal(name, species, age));
     }
     /**
     * Add a new animal to the zoo with all the information
     * @param name - given name (eg. "Fred")
     * @param species - general animal name (eg. "spider monkey")
     * @param age - how old the animal is in years
     * @param location - continent area in the zoo
     */
     public void addAnimal(String name, String species, int age, Location location) {
          animals.add(new Animal(name, species, age, location));
     }

     /**
      * Remove animal by name and species
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @return true if successfully removed
      */
     public boolean removeAnimal (String name, String species) {
          Animal animal = search(name, species);
          return animals.remove(animal);
     }

     /**
      * Update animal name, location and age by name and species
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @param age - how old the animal is in years
      * @param location - continent area in the zoo
      * @param newName - the new given name for the animal
      * @return the updated animal
      */
     public Animal updateAnimal(String name, String species, int age, Location location, String newName) {
          int index = getIndex(name, species);
          animals.get(index).setName(newName);
          animals.get(index).setLocation(location);
          animals.get(index).setAge(age);
          return animals.get(index);
     }
     /**
      * Update animal location and age by name and species
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @param age - how old the animal is in years
      * @param location - continent area in the zoo
      * @return the updated animal
      */
     public Animal updateAnimal(String name, String species, int age, Location location) {
          int index = getIndex(name, species);
          animals.get(index).setLocation(location);
          animals.get(index).setAge(age);
          return animals.get(index);
     }
     /**
      * Update animal location by name and species
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @param location - continent area in the zoo
      * @return the updated animal
      */
     public Animal updateAnimal(String name, String species, Location location) {
          int index = getIndex(name, species);
          animals.get(index).setLocation(location);
          return animals.get(index);
     }
     /**
      * Update animal age by name and species
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @param age - how old the animal is in years
      * @return the updated animal
      */
     public Animal updateAnimal(String name, String species, int age) {
          int index = getIndex(name, species);
          animals.get(index).setAge(age);
          return animals.get(index);
     }
     /**
      * Increase animal age by 1, given name and species of animal
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @return the updated animal
      */
     public Animal ageUpAnimal(String name, String species) {
          int index = getIndex(name, species);
          int currentAge = animals.get(index).getAge();
          animals.get(index).setAge(currentAge + 1);
          return animals.get(index);
     }
     /** Display a list of all the animals in the zoo */
     public void displaySummary() {
          for (Animal a : animals) {
               System.out.println(a);
          }
     }

     /**
      * Private search function for local use
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @return the index of the animal with both name and species
      */
     private int getIndex(String name, String species) {
          for (int i = 0; i < animals.size(); i++) {
               if (name.equals(animals.get(i).getName()) && species.equals(animals.get(i).getSpecies())) {
                    return i;
               }
          }
          return -1;
     }
     /**
      * Search animal by name and species
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @return the first animal that matches both name and species
      */
     public Animal search(String name, String species) {
          for (Animal a : animals) {
               if (name.equals(a.getName()) && species.equals(a.getSpecies())) {
                    return a;
               }
          }
          return null;
     }
     public ArrayList<Animal> filter(Location location) {
          ArrayList<Animal> filtered = new ArrayList<Animal>(); 
          for (Animal a : animals) {
               if (a.getLocation() == location) {
                    filtered.add(a);
               }
          }
          return filtered;
     }
}
