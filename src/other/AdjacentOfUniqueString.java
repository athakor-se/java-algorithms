package other;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author athakor
 */
public class AdjacentOfUniqueString {

    private static class Pair<A, B> {

        private A prev;
        private B next;

        public Pair(A prev, B next) {
            this.prev = prev;
            this.next = next;
        }

        public A getPrev() {
            return prev;
        }

        public B getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Pair{prev=" + prev + ", next=" + next + '}';
        }
    }

    public static void main(String[] args) {

        var arr = new String[]{"1219231A", "1533081C", "1534034C", "CLAUS-10005A", "1679617A", "1192272A"};
        System.out.println(findAdjacent(arr, "next", "1192272A"));
    }

    private static String findAdjacent(String[] arr, String direction, String strToMatch) {

        var map = new LinkedHashMap<String, Pair<String, String>>();

        var length = arr.length;
        IntStream.range(0, length)
                .forEach(it -> {
                    var prev = it > 0 ? arr[it - 1] : null;
                    var next = it < length - 1 ? arr[it + 1] : null;
                    map.put(arr[it], new Pair<>(prev, next));
                });

        var index = map.get(strToMatch);
        if (Objects.isNull(index))
            return null;

        if (direction.equals("prev")) {
            return index.getPrev();
        } else if (direction.equals("next")) {
            return index.getNext();
        }
        return null;
    }
}
