/*
 * Test Case for Zoo Class
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZooTestCase {

	String category;
	String typeOfAnimal;
	String name;
	int age; 
	double weight;
	Zoo zoo = new Zoo();
	
	@Test
	public void addAnimalToZooTest() {
		zoo.addZone("Mammal", 3);
		zoo.addZone("Reptile", 4);
		zoo.addZone("Bird", 6);
		
		zoo.addCageToZone("Mammal", "Lion", 5);
		zoo.addCageToZone("Reptile", "Crocodile", 4);
		zoo.addCageToZone("Bird", "Peacock", 6);
		boolean result = zoo.addAnimalToZoo("Mammal", "Lion", "Sheru", 5, 100);
		assertEquals(true, result);
	}
	
	@Test
	public void removeAnimalFromZooTest() {
		zoo.addZone("Reptile", 4);
		zoo.addZone("Bird", 6);
		
		zoo.addCageToZone("Mammal", "Lion", 5);
		zoo.addCageToZone("Reptile", "Crocodile", 4);
		zoo.addCageToZone("Bird", "Peacock", 6);
		boolean result = zoo.deleteAnimalFromZoo("Mammal", "Lion", "Babbar", 5, 100);
		assertEquals(false, result);
	}
	
	@Test
	public void getSoundOfAnimalTest() {
		zoo.addZone("Reptile", 4);
		zoo.addZone("Bird", 6);
		
		zoo.addCageToZone("Mammal", "Lion", 5);
		zoo.addCageToZone("Reptile", "Crocodile", 4);
		zoo.addCageToZone("Bird", "Peacock", 6);
		String result = zoo.getSoundOfAnimal("Lion");
		assertEquals("roars", result);
	}
}
