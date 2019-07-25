/**
 * Class for Zone in the Zoo
 */
import java.util.*;

public class Zone {
	String category;
	int maxCages;
	int numberOfCage = 0;
	boolean hasPark;
	boolean hasCanteen;
	List<Cage> cages = new ArrayList<>();

	public Zone(String category, int maxCages, boolean hasPark, boolean hasCanteen){
		this.category = category;
		this.maxCages = maxCages;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}

	/**
	 * Adds Cage to itself
	 * @param typeOfAnimal is the type of animal i.e Lion/Crocodile/Peacock
	 * @param maxAnimals is the capacity of cage
	 */
	public void addCage(String typeOfAnimal, int maxAnimals){
		if(numberOfCage < maxCages){
			cages.add(new Cage(typeOfAnimal, maxAnimals));
			numberOfCage++;
		}else{
			System.out.println("Cannot add more zones");
		}
	}
}
