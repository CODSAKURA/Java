package Example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMyExample {

    @Test
    public void multipleOfZeroIntegersShouldReturnZero() 
    {
        // assert statements
        assertEquals(0, Example.myMultiply(10, 0), "10 x 0 must be 0");
        assertEquals(0, Example.myMultiply(0, 10), "0 x 10 must be 0");
        assertEquals(0, Example.myMultiply(2, 1), "2 x 1 must be 2 not 0");
    }
}
