package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import src.*;
import java.util.ArrayList;

public class TestZooOperations {
   private Zoo zoo = new Zoo();
   private ArrayList<Animal> filteredExpected = new ArrayList<Animal>();
   
   @Before
   public void setup() {
      zoo.addAnimal("George", "Monkey", 5, Location.AFRICA);
      zoo.addAnimal("Elly", "Elephant", 15, Location.AFRICA);
      zoo.addAnimal("George the second", "Monkey", 2, Location.AFRICA);
      zoo.addAnimal("Kanga", "Kangaroo", 3, Location.AUSTRALIA);
      zoo.addAnimal("Penny", "Penguin", 2, Location.ANTARCTICA);

      filteredExpected.add(new Animal("George", "Monkey", 5, Location.AFRICA));
      filteredExpected.add(new Animal("Elly", "Elephant", 15, Location.AFRICA));
      filteredExpected.add(new Animal("George the second", "Monkey", 2, Location.AFRICA));
   }
   @Test
   public void testAddAnimal() {
      assertTrue(zoo.addAnimal("Leo", "Lion", 10, Location.AFRICA));
   }
   @Test
   public void testStopFromAddingDuplicateAnimal() {
      assertTrue(!zoo.addAnimal("Penny", "Penguin", 5, Location.UNKNOWN));
   }
   @Test 
   public void testUpdateAnimalName() {
      assertEquals("Roo", zoo.updateAnimalName(3, "Roo").getName());
   }
   @Test 
   public void testUpdateAnimalAge() {
      assertEquals(5, zoo.updateAnimalAge(3, 5).getAge());
   }
    @Test 
   public void testUpdateAnimalBeyondBounds() {
      assertEquals(null, zoo.updateAnimalAge(6, 5));
   }
   @Test 
   public void testAgeUpAnimal() {
      assertEquals(3, zoo.ageUpAnimal(4).getAge());
   }
   @Test 
   public void testUpdateAnimalLocation() {
      assertEquals(Location.ASIA, zoo.updateAnimalLocation(1, Location.ASIA).getLocation());
   }
   @Test
   public void testStopFromUpdatingAnimalNameToDuplicate() {
      assertEquals(null, zoo.updateAnimalName(0,"George the second"));
   }
   @Test 
   public void testRemoveAnimal() {
      Animal george = zoo.getAnimal(0);
      assertEquals(george, zoo.removeAnimal(0));
   }
   @Test 
   public void testRemoveAnimalBeyondBounds() {
      assertEquals(null, zoo.removeAnimal(5));
   }
   @Test 
   public void testSearchSuccess() {
      assertEquals("Elly", zoo.search("Elly", "Elephant").getName());
   }
   @Test 
   public void testSearchFailure() {
      assertEquals(null, zoo.search("Rara", "Rattlesnake"));
   }
   @Test 
   public void testFilter() {
      assertEquals(filteredExpected, zoo.filter(Location.AFRICA));
   }
   @Test 
   public void testFilterEmpty() {
      assertEquals(new ArrayList<Animal>(), zoo.filter(Location.EUROPE));
   }
}
