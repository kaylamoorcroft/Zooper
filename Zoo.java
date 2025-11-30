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
     public boolean addAnimal(String name, String species, int age, Location location) {
          if (!isUniqueName(name, species)) return false;
          animals.add(new Animal(name, species, age, location));
          return true;
     }
     /**
      * @return true if there is not already an animal of species with name
      */
     public boolean isUniqueName(String name, String species) {
          Animal existingAnimal = null;
          for (Animal a : animals) {
               if (a.getName().equalsIgnoreCase(name) && a.getSpecies().equalsIgnoreCase(species)) {
                    existingAnimal = a;
                    break; // Exit loop once found
               }
          }
          return (existingAnimal == null);
     }

     /**
      * Remove animal by index
      * @return removed animal
      */
     public Animal removeAnimal(int index) {
          return animals.remove(index);
     }

     /**
      * Update animal name based on index
      * @return Updated animal
      */
     public Animal updateAnimalName(int index, String name) {
          if (!isUniqueName(name, animals.get(index).getSpecies())) return null;
          animals.get(index).setName(name);
          return animals.get(index);
     }
     /**
      * Update animal age based on index
      * @return Updated animal
      */
     public Animal updateAnimalAge(int index, int age) {
          animals.get(index).setAge(age);
          return animals.get(index);
     }
     /**
      * Update animal location based on index
      * @return Updated animal
      */
     public Animal updateAnimalLocation(int index, Location location) {
          animals.get(index).setLocation(location);
          return animals.get(index);
     }
     /**
      * Increase animal age by 1, given the index
      * @return the updated animal
      */
     public Animal ageUpAnimal(int index) {
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
      * Search animal by name and species
      * @param name - animal's given name (eg. "Fred")
      * @param species - general animal name (eg. "spider monkey")
      * @return the first animal that matches both name and species
      */
     public Animal search(String name, String species) {
          for (Animal a : animals) {
               if (name.equalsIgnoreCase(a.getName()) && species.equalsIgnoreCase(a.getSpecies())) {
                    return a;
               }
          }
          return null;
     }
     
     /**
      * 
      * @param location
      * @return filtered ArrayList containing the animals from the given location (continent)
      */
     public ArrayList<Animal> filter(Location location) {
          ArrayList<Animal> filtered = new ArrayList<Animal>(); 
          for (Animal a : animals) {
               if (a.getLocation() == location) {
                    filtered.add(a);
               }
          }
          return filtered;
     }
     
     public ArrayList<Animal> getAnimals(){
    	 return animals;
     }
}
