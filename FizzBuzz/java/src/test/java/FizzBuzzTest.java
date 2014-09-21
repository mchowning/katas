/**
 * Created by matt on 9/21/14.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void fizzTest() {
        for (int i = 3; i < 100; i += 3) {
            if (i % 5 != 0) {
                assertEquals("If num is divisible by 3 but not 5, then print 'Fizz'", "Fizz", FizzBuzz.test(i));
            }
        }
    }

    @Test
    public void buzzTest() {
        for (int i = 5; i < 100; i += 5) {
            if (i % 3 != 0) {
                assertEquals("If num is divisible by 5 but not 3, then print 'Buzz'", "Buzz", FizzBuzz.test(i));
            }
        }
    }

    @Test
    public void fizzBuzzTest() {

        /* Not using a for loop with num increasing by 15 because the remainder 15 test is what I am using in my
         * implementation and I want my tests to use different logic */

        assertEquals("If num is divisible by 3 and 5 (i.e., 15), then print 'FizzBuzz'", "FizzBuzz", FizzBuzz.test(15));
        assertEquals("If num is divisible by 3 and 5 (i.e., 15), then print 'FizzBuzz'", "FizzBuzz", FizzBuzz.test(30));
        assertEquals("If num is divisible by 3 and 5 (i.e., 15), then print 'FizzBuzz'", "FizzBuzz", FizzBuzz.test(45));
        assertEquals("If num is divisible by 3 and 5 (i.e., 15), then print 'FizzBuzz'", "FizzBuzz", FizzBuzz.test(3000));
    }
}
