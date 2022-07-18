import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class CalculatorTest {

    Calculator sut;

    @BeforeEach
    public void init() {
        sut = new Calculator();
    }

    @Test
    public void testMinus() {
        final int a = 2, b = 1, expected = 1;
        final int result = sut.minus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPow() {
        final int a = 2, expected = 4;
        final int result = sut.pow.apply(a);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testOriginalDevide_validArgument() {
        final int a = 2, b = 2, expected = 1;
        final int result = sut.devide.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testOriginalDevide_zeroArgument_throwsException() {
        final int a = 2, b = 0;
        Assertions.assertThrows(ArithmeticException.class,() -> sut.devide.apply(a, b));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testIsPositive(int a, boolean expectedResult) {
        boolean result = sut.isPositive.test(a);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(-2, false),
                Arguments.of(0, false)
        );
    }
}
