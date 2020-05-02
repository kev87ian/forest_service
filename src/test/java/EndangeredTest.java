import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredTest {
    @Test
    public void endangered_instantiates_correctly(){
        Endangered endangered = new Endangered("Kitty","Irwin","A","Fine", "young");
        assertEquals(true, endangered instanceof Endangered);
    }

    @Test
    public void endangered_returnsCorrectHealth(){
        Endangered endangered = new Endangered("Kitty", "Irwin", "A", "Sickly", "Old");
        assertEquals("Sickly", endangered.getHealthLevel());
    }

    @Test
    public void checkIfEndangered_returnsCorrectAge(){
        Endangered endangered = new Endangered("Kitty", "Irwin", "A", "Sickly", "Old");
        assertEquals("Old", endangered.getAge());
    }
    @Test
    public void checkIfEndangered_returnsCorrectRanger(){
        Endangered endangered = new Endangered("Kitty", "Irwin", "A", "Okay", "Unsure");
        assertEquals("Irwin", endangered.getRangerName());
    }

}