package testtdd.StringCalculatorTest;

import org.junit.Test;
import testtdd.StringCalculator;

//The method can take 0, 1 or 2 numbers separated by comma (,).

public class StringCalculatorTest {
    @Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculator.add("1,2,3");
    }
    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }
}

//  @Test(expected = RuntimeException.class)
//  public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//      StringCalculator.add("1,2,3");
//  }
@Test
public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
    Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
}

//Allow the Add method to handle new lines between numbers (instead of commas).

@Test
public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
    Assert.assertEquals(3+6+15, StringCalculator.add("3,6n15"));
}

//Support different delimiters

@Test
public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
    Assert.assertEquals(3+6+15, StringCalculator.add("//;n3;6;15"));
}

//Negative numbers will throw an exception

@Test(expected = RuntimeException.class)
public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
    StringCalculator.add("3,-6,15,18,46,33");
}
@Test
public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
    RuntimeException exception = null;
    try {
        StringCalculator.add("3,-6,15,-18,46,33");
    } catch (RuntimeException e) {
        exception = e;
    }
    Assert.assertNotNull(exception);
    Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
}

//Numbers bigger than 1000 should be ignored

@Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        Assert.assertEquals(3+1000+6, StringCalculator8.add("3,1000,1001,6,1234"));
    }