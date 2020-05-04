package models;
import org.junit.*;
import static org.junit.Assert.*;


public class EndangeredAnimalTest {
    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Raccoon", "Healthy", "Young");
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void getHealth_returnsCorrectHealthAttribute_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Raccoon", "Healthy", "Young");
        assertEquals("Healthy", testEndangeredAnimal.getHealth());
    }

    @Test
    public void save_assignsIdAndSavesObjectToDatabase() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Raccoon", "Healthy", "Young");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Raccoon", "Healthy", "Young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Raccoon", "Healthy", "Young");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Beast", "Ill", "Young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("lion", "Healthy", "Adult");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }

    @Test
    public void update_updatesHealthAttribute_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Beast", "Ill", "Young");
        testEndangeredAnimal.save();
        testEndangeredAnimal.updateHealth("ill");
        assertEquals("ill", EndangeredAnimal.find(testEndangeredAnimal.getId()).getHealth());
    }

    @Test
    public void update_updatesAgeAttribute_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Beast", "Ill", "Young");
        testEndangeredAnimal.save();
        testEndangeredAnimal.updateAge("Adult");
        assertEquals("Adult", EndangeredAnimal.find(testEndangeredAnimal.getId()).getAge());
    }

}