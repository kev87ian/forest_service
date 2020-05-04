package  models;
import org.junit.*;

import static org.junit.Assert.*;


public class SightingTest {

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        Sighting testSighting = new Sighting(testAnimal.getId(), "zone A", "John Chege");
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void equals_returnsTrueIfLocationAndDescriptionAreSame_true() {
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        Sighting testSighting = new Sighting(testAnimal.getId(), "zone A", "John Chege");
        Sighting anotherSighting = new Sighting(testAnimal.getId(), "zone A", "John Chege");
        assertTrue(testSighting.equals(anotherSighting));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Sighting() {
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        Sighting testSighting = new Sighting (testAnimal.getId(), "zone A", "John Chege");
        testSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(testSighting));
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        Sighting testSighting = new Sighting (testAnimal.getId(), "zone A", "John Chege");
        testSighting.save();
        Animal secondTestAnimal = new Animal("C");
        secondTestAnimal.save();
        Sighting secondTestSighting = new Sighting (testAnimal.getId(), "zone A", "Kevin Onyango");
        secondTestSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(testSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondTestSighting));
    }

    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        Sighting testSighting = new Sighting (testAnimal.getId(), "zone A", "John Chege");
        testSighting.save();
        Animal secondTestAnimal = new Animal("Cheetah");
        secondTestAnimal.save();
        Sighting secondTestSighting = new Sighting (testAnimal.getId(), "zone A", "Kevin Onyango");
        secondTestSighting.save();
        assertEquals(Sighting.find(secondTestSighting.getId()), secondTestSighting);
    }



}