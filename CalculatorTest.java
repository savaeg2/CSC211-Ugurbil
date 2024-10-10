import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2");
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Division by zero should throw ArithmeticException");
    }
}

class Calculator {
    public int add(int a, int b) {  
        return a + b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}