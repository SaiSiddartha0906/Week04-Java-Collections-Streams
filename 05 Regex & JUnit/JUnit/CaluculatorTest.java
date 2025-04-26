package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(-1, calc.add(2, -3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calc.subtract(4, 3));
        assertEquals(-6, calc.subtract(-3, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(12, calc.multiply(4, 3));
        assertEquals(0, calc.multiply(0, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide(6, 3));
        assertEquals(-3, calc.divide(-9, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(5, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
