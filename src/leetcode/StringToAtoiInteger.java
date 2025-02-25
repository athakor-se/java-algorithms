package leetcode;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 */
public class StringToAtoiInteger {

    public static int myAtoi(String s) {
        var finalString = "0";
        var charArray = s.strip().toCharArray();
        var firstChar = '+';
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                finalString += charArray[i];
            } else {
                if (i == 0 && (charArray[i] == '-' || charArray[i] == '+')) {
                    firstChar = charArray[i];
                } else {
                    break;
                }
            }
        }
        try {
            return Integer.parseInt(finalString) * (firstChar == '-' ? -1 : 1);
        } catch (NumberFormatException ex) {
            if (firstChar == '-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   +1"));
    }
}
