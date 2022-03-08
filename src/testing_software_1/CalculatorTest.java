package testing_software_1;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.subtract(5, 2));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 3));
    }

    @org.junit.jupiter.api.Test
    public void divide_9and0_error() {
        //ARRANGE
        Calculator c = new Calculator();

        //ACT + ASSERT 1
        Exception exception = Assertions.assertThrows(Exception.class, () -> c.divide(9, 0));

        String expectedMessage = "Pokus o deleni nulou";
        String actualMessage = exception.getMessage();

        // ASSERT 2
        Assertions.assertEquals(expectedMessage, actualMessage);

    }
}