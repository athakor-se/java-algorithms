package other;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author athakor
 */
public class GroupByAnagramOfWords {

    private static Function<String, String> sortedList = it -> it.chars().sorted()
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

    public static void main(String[] args) {
        var words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "tab"};
        Map<String, List<String>> collect = Arrays.stream(words)
                .collect(Collectors.groupingBy(sortedList));
        System.out.println(collect);
    }
}
