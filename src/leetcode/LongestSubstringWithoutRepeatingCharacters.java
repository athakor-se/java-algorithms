package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Function;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring2(String text) {

        if (text == null || text.isEmpty())
            return 0;

        var counter = 1;
        var builder = new StringBuilder();
        var textLength = text.length();
        var countList = new ArrayList<Integer>(textLength);

        for (var i = 0; i < textLength; i++) {
            var iChar = text.charAt(i);
            builder.append(iChar);
            for (var j = i + 1; j < textLength; j++) {
                var jChar = text.charAt(j);
                if (builder.toString().contains(String.valueOf(jChar)))
                    break;
                counter++;
                builder.append(jChar);
            }
            countList.add(counter);
            builder = new StringBuilder();
            counter = 1;
        }
        return countList.stream().max(Comparator.comparing(Function.identity())).orElse(0);
    }

    public static int lengthOfLongestSubstring1(String text) {

        if (text == null || text.isEmpty())
            return 0;

        var counter = 0;
        var builder = new StringBuilder();
        var textLength = text.length();
        for (var i = 0; i < textLength; i++) {
            var iChar = text.charAt(i);
            if (!builder.toString().contains(String.valueOf(iChar))) {
                builder.append(iChar);
                counter++;
                continue;
            }
            counter--;
            builder = new StringBuilder();
        }
        return counter;
    }

    public static int lengthOfLongestSubstring(String text) {

        if (text == null || text.isEmpty())
            return 0;

        int left = 0;
        int maxLength = 0;
        var set = new HashSet<Character>();

        for (int right = 0; right < text.length(); right++) {
            while (set.contains(text.charAt(right))) {
                set.remove(text.charAt(left));
                left++;
            }
            set.add(text.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        var result = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf");
        System.out.println(result);
        var result2 = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result2);
        var result3 = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb");
        System.out.println(result3);
        var result4 = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew");
        System.out.println(result4);
        var result5 = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("");
        System.out.println(result5);
        var result6 = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(" ");
        System.out.println(result6);
    }
}
