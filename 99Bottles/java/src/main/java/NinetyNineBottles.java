import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NinetyNineBottles {

    public String song() {
        return verses(99, 0);
    }

    public String verses(int start, int end) {
        return revRangeInclusive(start, end)
                .mapToObj(this::verse)
                .flatMap(s -> Stream.of("\n", s))
                .skip(1)
                .collect(Collectors.joining());
    }

    static IntStream revRangeInclusive(int to, int from) {
        return IntStream.range(from, to + 1)
                .map(i -> to - i + from);
    }

    public String verse(int num) {
        if (num == 0) {
            return "No more bottles of beer on the wall, no more bottles of beer.\n" +
                   "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        } else {
            String originalN = getBottlesString(num);
            String newN = getBottlesString(num - 1);

            return String.format("%s of beer on the wall, " +
                   "%s of beer.\n" +
                   "Take %s down and pass it around, " +
                   "%s of beer on the wall.\n", originalN, originalN, getPreDown(num), newN);
        }
    }

    private String getBottlesString(int num) {
        switch (num)  {
            case 0: return "no more bottles";
            case 1: return "1 bottle";
            default: return num + " bottles";
        }
    }

    private String getPreDown(int num) {
        return num == 1 ? "it" : "one";
    }
}
