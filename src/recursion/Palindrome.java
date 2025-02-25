package recursion;

/**
 * @author athakor
 */
public class Palindrome {

    // Reverse of string should be equal

    public static void main(String[] args) {
        var string = "ABCD";
        System.out.println(palindrome(string, string.length()));
    }

    private static String palindrome(String string, int length) {
        if (length == 0)
            return string;
        return palindrome(string, length - 1);
    }

//    private static int palindromeNormal(String string, int length) {
//        var newString = new StringBuilder();
//        for (var i = 0; i < string.length(); i++) {
//
//        }
//
//        return 0;
//    }
}
