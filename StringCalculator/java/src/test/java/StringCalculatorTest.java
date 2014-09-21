/**
 * Created by matt on 9/20/14.
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void emptyString() {
        assertEquals("empty string should return 0", 0, StringCalculator.add(""));
    }

    @Test
    public void singleDigit() {
        assertEquals("'1' string should return 1", 1, StringCalculator.add("1"));
        assertEquals("'2' string should return 2", 2, StringCalculator.add("2"));
        assertEquals("'5' string should return 5", 5, StringCalculator.add("5"));
    }

    @Test
    public void largeSingleDigit() {
        assertEquals("'12' string should return 12", 12, StringCalculator.add("12"));
        assertEquals("'26' string should return 26", 26, StringCalculator.add("26"));
        assertEquals("'55' string should return 55", 55, StringCalculator.add("55"));
    }

    @Test
    public void twoDigits() {
        assertEquals("'1,1' string should return 2", 2, StringCalculator.add("1,1"));
        assertEquals("'2,3' string should return 5", 5, StringCalculator.add("2,3"));
        assertEquals("'1,9' string should return 10", 10, StringCalculator.add("1,9"));
    }

    @Test
    public void newLineDelimiter() {
        assertEquals("'1\n2,3' string should return 6", 6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void customDelimiter() {
        assertEquals("'//;\n1;2' string should return 3", 3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void alternateCustomDelimiter() {
        assertEquals("'//[;]\n3;2' string should return 5", 5, StringCalculator.add("//[;]\n3;2"));
    }

    @Test
    public void multipleCustomDelimitersOfVaryingLengths() {
        assertEquals("'//[aab][c]\n32aab132c5' string should return 169", 169, StringCalculator.add("//[aab][c]\n32aab132c5"));
    }

    @Test public void worksWithDelimitersWithRegexCharacters() {
        assertEquals("'//[$$%][#]\n32aab132c5' string should return 169", 169, StringCalculator.add("//[$$%][#]\n32$$%132#5"));
    }

    @Test(expected= IllegalArgumentException.class)
    public void throwsExceptionWithNegativeNumber() {
        StringCalculator.add("3,-4");
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsExceptionWithMessageIfNegativeNumberPassed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-37, -4, -923");
        StringCalculator.add("7,-37,-4, 585,-923, 904");
    }

    @Test
    public void numbersGreaterThan1000AreIgnored() {
        assertEquals("'3,3000,4' string should return 7", 7, StringCalculator.add("3,3000,4"));
    }
}
