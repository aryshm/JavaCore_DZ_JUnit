import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.Is.isA;


public class CalculatorTest {

    Calculator sut;

    @BeforeEach
    public void init() {
        sut = new Calculator();
    }

    @Test
    public void classChecked_() {
        assertThat(sut, instanceOf(Calculator.class));
        assertThat(sut, isA(Calculator.class));
    }

    @Test
    public void testPow() {
        int intVal = 2;
        int actual = sut.pow.apply(intVal);
        assertThat(actual, is(4));
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
