/*
 * Utility Class for Zoo Management
 * @since 23-July-2019
 */
import java.util.*;
public class Zoo {

	List<Zone> zones = new ArrayList<>();

	/**
	 * Adds Zone to the Zoo
	 * @param category is the category of animal i.e Mammal/Reptile/Bird
	 * @param maxCages is the capacity of Zone
	 */
	public void addZone(String category, int maxCages){
		zones.add(new Zone(category, maxCages, true, true));
	}

	/**
	 * Adds Cage to a particular Zone
	 * @param category is the category of animal i.e Mammal/Reptile/Bird
	 * @param typeOfAnimal is the type of animal i.e Lion/Crocodile/Peacock
	 * @param maxAnimals is the capacity of Cage
	 */
	public void addCageToZone(String category, String typeOfAnimal, int maxAnimals) {
		for(int i = 0 ; i < zones.size() ; i++) {
			if(zones.get(i).category.equals(category)) {
				zones.get(i).addCage(typeOfAnimal, maxAnimals);
			}
		}
	}

	/**
	 * Adds particular Animal to the Zoo
	 * @param category is the category of animal i.e Mammal/Reptile/Bird
	 * @param typeOfAnimal is the type of animal i.e Lion/Crocodile/Peacock
	 * @param name is the name of the animal
	 * @param age of animal
	 * @param weight of animal
	 * @return true/false depending on whether animal is added or not
	 */
	public boolean addAnimalToZoo(String category, String typeOfAnimal , String name, int age, 
			double weight) {
		try {
			for(int i = 0 ; i < zones.size() ; i++) {
				if(zones.get(i).category.equals(category)) {
					for(int j = 0 ; j < zones.get(i).cages.size() ; j++) {
						if(zones.get(i).cages.get(j).typeOfAnimal.equals(typeOfAnimal)) {
							return zones.get(i).cages.get(j).addAnimalToCage(name, age, weight);
						}
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * Deletes particular Animal from the Zoo
	 * @param category is the category of animal i.e Mammal/Reptile/Bird
	 * @param typeOfAnimal is the type of animal i.e Lion/Crocodile/Peacock
	 * @param name is the name of the animal
	 * @param age of animal
	 * @param weight of animal
	 * @return true/false depending on whether animal is removed or not
	 */
	public boolean deleteAnimalFromZoo(String category, String typeOfAnimal , String name, int age,
			double weight) {
		try {
			for(int i = 0 ; i < zones.size() ; i++) {
				if(zones.get(i).category.equals(category)) {
					for(int j = 0 ; j < zones.get(i).cages.size() ; j++) {
						if(zones.get(i).cages.get(j).typeOfAnimal.equals(typeOfAnimal)) {
							return zones.get(i).cages.get(j).removeAnimalFromCage(name, age, weight);
						}
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * Computes Sound of Animal
	 * @param typeOfAnimal  is the type of animal i.e Lion/Crocodile/Peacock
	 * @return sound Of Animal
	 */
	public String getSoundOfAnimal(String typeOfAnimal) {
		Animal animal = null;
		switch(typeOfAnimal){
		case "Lion" : animal = new Lion();
		break;
		case "Crocodile" : animal = new Crocodile();
		break;    
		case "Peacock" : animal = new Peacock();
		break;
		default :return "Animal is not present in the zoo";
		}
		return animal.getSound();
	}
}
