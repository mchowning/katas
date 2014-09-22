import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by matt on 9/21/14.
 */
public class CalcStatsTest {

    @Test(expected = IllegalArgumentException.class)
    public void mustPassInAtLeastOneNumber() {
        int[] nums = {};
        CalcStats.getStats(nums);
    }

    @Test
    public void caclulateMinimumValue() {
        int[] nums = {2, 3, 1, 5};
        CalcStats.Stats s = CalcStats.getStats(nums);
        assertEquals("Minimum of {2, 3, 1, 5} should be 1", 1, s.min);
    }

    @Test
    public void calculateMaximumValue() {
        int[] nums = {3, 652, 234, 65};
        CalcStats.Stats s = CalcStats.getStats(nums);
        assertEquals("Maximum of {3, 652, 234, 65} should be 652", 652, s.max);
    }

    @Test
    public void calculateNumberOfElements() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        CalcStats.Stats s = CalcStats.getStats(nums);
        assertEquals("Stats should reflect the correct number of elements in the sequence", 7, s.numElements);
    }

    @Test
    public void calculateAverage() {
        int[] nums = {3214, 234, 524, 2342};
        CalcStats.Stats s = CalcStats.getStats(nums);
        assertEquals("Stats should reflect the average of the numbers in the sequence", 1578.5, s.average, .01);
    }
}
