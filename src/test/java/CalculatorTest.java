import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    Calculator calc = Calculator.instance.get();

    @org.junit.jupiter.api.Test
    public void testMinus() {
        final int a = 2;
        final int b = 1;
        final int expected = 1;
        final int result = calc.minus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testPow() {
        final int a = 2;
        final int expected = 4;
        final int result = calc.pow.apply(a);
        Assertions.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testOriginalDevide_validArgument() {
        final int a = 2;
        final int b = 2;
        final int expected = 1;
        final int result = calc.devide.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testOriginalDevide_zeroArgument_throwsException() {
        final int a = 2;
        final int b = 0;
        Assertions.assertThrows(ArithmeticException.class,() -> calc.devide.apply(a, b));
    }
}
