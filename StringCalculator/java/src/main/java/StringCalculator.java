import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by matt on 9/20/14.
 */
public class StringCalculator {

    private static final String regexForDefaultDelimiters = "\\n|,"; // new line or comma

    public static int add(String input) {
        int result = 0;
        if (input.length() > 0) {
            String delimiterRegex = regexForDefaultDelimiters;
            if (hasAdditionalDelimiter(input)) {
                delimiterRegex += getCustomDelimiterRegexFromInput(input);
                input = removeCustomDelimiterInfoFromInput(input);
            }
            String[] numberStrings = getNumberStrings(input, delimiterRegex);
            throwExceptionForNegativeNumbers(numberStrings);
            result = totalOfNumbers(numberStrings);
        }
        return result;
    }

    private static String removeCustomDelimiterInfoFromInput(String input) {
        int firstLineEnd = input.indexOf('\n');
        input = input.substring(firstLineEnd + 1);
        return input;
    }

    private static boolean hasAdditionalDelimiter(String input) {
        return input.length() > 1 &&
               input.substring(0,2).equals("//");
    }

    private static String getCustomDelimiterRegexFromInput(String input) {
        if (delimiterHasBrackets(input)) {
            return getBracketedDelimiters(input);
        } else {
            return getSingleNonbracketedDelimiter(input);
        }
    }

    private static String getBracketedDelimiters(String input) {
        String customDelimiterPortionOfInput = input.substring(0, input.indexOf('\n'));
        Pattern p = Pattern.compile("(?<=\\[)(.*?)(?=\\])");
        Matcher m = p.matcher(customDelimiterPortionOfInput);
        String result = "";
        while (m.find()) {
            result += "|" + Pattern.quote(m.group());
        }
        return result;
    }

    private static String getSingleNonbracketedDelimiter(String input) {
        return "|" + input.charAt(2);
    }

    private static boolean delimiterHasBrackets(String input) {
        return input.charAt(2) == '[';
    }

    private static String[] getNumberStrings(String numbers, String delimiterRegex) {
        return numbers.split(delimiterRegex);
    }

    private static void throwExceptionForNegativeNumbers(String[] result) {
        ArrayList<String> negativeNumbers = getAnyNegativeNumbers(result);
        if (negativeNumbers.size() > 0) {
            throwNoNegativeNumbersException(negativeNumbers);
        }
    }

    private static ArrayList<String> getAnyNegativeNumbers(String[] result) {
        ArrayList<String> negativeNumbers = new ArrayList<String>();
        for (String numStr : result) {
            if (numStr.charAt(0) == '-') {
                negativeNumbers.add(numStr);
            }
        }
        return negativeNumbers;
    }

    private static void throwNoNegativeNumbersException(ArrayList<String> negativeNumbers) {
        String message = "negative numbers not allowed: ";
        for (String negativeNum : negativeNumbers) {
            // TODO Use google guava Joiner or apache commons StringUtils.join
            message += negativeNum + ", ";
        }
        message = removeTrailingCommaAndSpace(message);
        throw new IllegalArgumentException(message);
    }

    private static String removeTrailingCommaAndSpace(String message) {
        return message.substring(0, message.length() - 1);
    }

    private static int totalOfNumbers(String[] numberStrings) {
        int result = 0;
        for (String numStr : numberStrings) {
            if (numStr.equals("")) break;
            int value = Integer.parseInt(numStr);
            if (value < 1000) {
                result += value;
            }
        }
        return result;
    }
}
