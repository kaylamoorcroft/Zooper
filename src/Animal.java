package src;

import java.util.Objects;

/**
 * Animal in the Zoo
 */
public class Animal {
    private String name;
    private String species;
    private int age;
    private Location location;

    /**
     * Add a new animal to the zoo when only the species is known
     * @param species
     */
    public Animal(String species) {
        this.species = species;
        name = "";
        age = 0;
        location = Location.UNKNOWN;
    }
    /**
     * Add a new animal to the zoo with an unknown location
     * @param name - given name (eg. "Fred")
     * @param species - general animal name (eg. "spider monkey")
     * @param age - how old the animal is in years
     */
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
        location = Location.UNKNOWN;
    }
    /**
     * Add a new animal to the zoo with all the information
     * @param name - given name (eg. "Fred")
     * @param species - general animal name (eg. "spider monkey")
     * @param age - how old the animal is in years
     * @param location - continent area in the zoo
     */
    public Animal(String name, String species, int age, Location location) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.location = location;
    }

    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public Location getLocation() { return location; }

    public void setName(String name) {this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setLocation(Location location) { this.location = location; }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        
        Animal a = (Animal) obj;
        
        return (a.name == this.name && a.species == this.species && a.age == this.age && a.location == this.location);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, species);
    }

    public String toString() {
        String toReturn = "Name: " + name + "\n";
        toReturn += "Species: " + species + "\n";
        toReturn += "Age: " + age + "\n";
        toReturn += "Location: " + location + "\n";
        return toReturn;
    }
    public String getRecord() {
        return name + "," + species + "," + age + "," + location.getLocationNumber();
    }
}
