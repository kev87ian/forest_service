package models;

import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {


    @Test
    public void animal_instantiatesCorrectly_false() {
        Animal testAnimal = new Animal("Lion");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_Hyena() {
        Animal testAnimal = new Animal("Lynx");
        assertEquals("Lynx", testAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsTheSame_false() {
        Animal firstAnimal = new Animal("Lynx");
        Animal anotherAnimal = new Animal("Lynx");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_assignsIdToObjectAndSavesObjectToDatabase() {
        Animal testAnimal = new Animal("Hyena");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_false() {
        Animal firstAnimal = new Animal("Lion");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Leopard");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Hyena");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Leopard");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void delete_deletesAnimalFromDatabase_0() {
        Animal testAnimal = new Animal("Hyena");
        testAnimal.save();
        testAnimal.delete();
        assertEquals(0, Animal.all().size());
    }


}