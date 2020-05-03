import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredTest {
    @Test
    public void endangered_instantiates_correctly(){
        Endangered endangered = new Endangered("Kitty","Young","Irwin","By the River", "okay");
        assertEquals(true, endangered instanceof Endangered);
    }

    @Test
    public void endangered_returnsCorrectHealth(){
        Endangered Endangered = new Endangered("Kitty","Young","Irwin","By the River", "okay");
        assertEquals("Sickly", Endangered.getHealth());
    }

    @Test
    public void checkIfEndangered_returnsCorrectAge(){
        Endangered endangered = new Endangered("Kitty","Young","Irwin","By the River", "okay");
        assertEquals("Old", endangered.getAge());
    }
    @Test
    public void checkIfEndangered_returnsCorrectRanger(){
        Endangered endangered = new Endangered("Kitty","Young","Irwin","By the River", "okay");
        assertEquals("Irwin", endangered.getRanger());
    }

}