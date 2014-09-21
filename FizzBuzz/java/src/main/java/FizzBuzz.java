/**
 * Created by matt on 9/21/14.
 */
public class FizzBuzz {

    public static String test(int num) {
        if (num % 15 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        }
        return "";
    }
}
