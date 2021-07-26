/*
 * Class for Cage in a Zone
 */
import java.util.*;

public class Cage {
	String typeOfAnimal;
	List<String> listOfAnimal = new ArrayList<>();
	int maxAnimals;
	int numberOfAnimal = 0;

	public Cage(String typeOfAnimal, int maxAnimals){
		this.maxAnimals = maxAnimals;
		this.typeOfAnimal = typeOfAnimal;
	}

	/**
	 * Adds animal to cage
	 * @param name of animal
	 * @param age of animal
	 * @param weight of animal
	 * @return true/false depending on whether animal is added or not
	 */
	public boolean addAnimalToCage(String name, int age, double weight){
		if(numberOfAnimal < maxAnimals){
			listOfAnimal.add(name);
			numberOfAnimal++;
			return true;
		}else{
			System.out.println("Cannot add more animals");
			return false;
		}
	}

	/**
	 * Adds animal to cage
	 * @param name of animal
	 * @param age of animal
	 * @param weight of animal
	 * @return true/false depending on whether animal is added or not
	 */
	public boolean removeAnimalFromCage(String name, int age, double weight){
		int index = listOfAnimal.indexOf(name);
		if(index != -1){
			listOfAnimal.remove(index);
			numberOfAnimal--;
			return true;
		}else{
			System.out.println("Cannot remove animal from zoo!");
			return false;
		}
	}
}
