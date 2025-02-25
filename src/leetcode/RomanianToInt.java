package leetcode;

public class RomanianToInt {

    public static void main(String[] args) {
        System.out.println(new RomanianToInt().romanToInt("MMI"));
    }

    public int romanToInt(String s) {
        var chars = s.toCharArray();
        var total = 0;
        for (int i = 0; i < chars.length; i++) {
            var nextIndex = i;
            if (i + 1 != chars.length) {
                nextIndex++;
            }
            switch (chars[i]) {
                case 'M': total += 1000; break;
                case 'D': total += 500; break;
                case 'L': total += 50; break;
                case 'V': total += 5; break;
                case 'C': {
                    if (chars[nextIndex] == 'D') {
                        total += 400;
                        i++;
                        break;
                    } else if (chars[nextIndex] == 'M') {
                        total += 900;
                        i++;
                        break;
                    } else {
                        total += 100; break;
                    }
                }
                case 'X' : {
                    if (chars[nextIndex] == 'L') {
                        total += 40;
                        i++;
                        break;
                    } else if (chars[nextIndex] == 'C') {
                        total += 90;
                        i++;
                        break;
                    } else {
                        total += 10;
                        break;
                    }
                }
                case 'I' : {
                    if (chars[nextIndex] == 'V') {
                        total += 4;
                        i++;
                        break;
                    } else if (chars[nextIndex] == 'X') {
                        total += 9;
                        i++;
                        break;
                    } else {
                        total += 1;
                        break;
                    }
                }
                default: total += 0;
            }
            if (i == chars.length)
                break;
        }
        return total;
    }

}
