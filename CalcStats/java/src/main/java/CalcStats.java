/**
 * Created by matt on 9/21/14.
 */
public class CalcStats {

    public static Stats getStats(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("nums argument must contain at least one number");
        }
        Stats stats = new Stats();
        stats.numElements = nums.length;
        stats.average = getAverage(nums);
        getMinAndMax(nums, stats);
        return stats;
    }

    private static double getAverage(int[] nums) {
        double average = 0;
        for (int num : nums) {
            average += num;
        }
        return average / nums.length;
    }

    private static void getMinAndMax(int[] nums, Stats stats) {
        stats.min = nums[0];
        stats.max = nums[0];
        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                int newNum = nums[i];
                if (newNum > stats.max) {
                    stats.max = newNum;
                }
                if (newNum < stats.min) {
                    stats.min = newNum;
                }
            }
        }
    }

    public static class Stats {
        public int min;
        public int max;
        public int numElements;
        public double average;
    }
}
