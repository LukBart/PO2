import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexOperationsTest{
    @Test
    public void add (){
        assertEquals (ComplexOperations.add(new Complex(2.5, 13.1), (new Complex (-8.5, -0.9))), new Complex (-6.0, 12.2));
    }
    @Test
    public void subtract (){
        assertEquals (ComplexOperations.subtract(new Complex(2.5, 13.1), (new Complex (-8.5, -0.9))), new Complex (11.0, 14.0));
    }
    @Test
    public void multiply (){
        assertEquals (ComplexOperations.multiply(new Complex(2.5, 13.1), (new Complex (-8.5, -0.9))), new Complex (-9.46, -113.6));
    }
    @Test
    public void divide (){
        assertEquals (ComplexOperations.divide(new Complex(2.5, 13.1), (new Complex (-8.5, -0.9))), new Complex (-0.4522310429783739, -1.4932931836846426));
    }
}