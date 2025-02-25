package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRomanian {
    static Map<String, Integer> map = new LinkedHashMap<>() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};

    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        System.out.println(IntToRomanian.intToRoman(2567));
        System.out.println(System.currentTimeMillis()-start);
    }

    private static String intToRoman(int num) {
        var intToRoman = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (num == 0) {
                break;
            } else if (num == value) {
                intToRoman += key;
                break;
            }
            while (num >= value) {
                intToRoman += key;
                num = num - value;
            }
        }
        return intToRoman;
    }

}
