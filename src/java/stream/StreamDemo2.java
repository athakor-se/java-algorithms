package java.stream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String[] args) {
        Stream<Integer> limit = Stream.generate(() -> new Random().nextInt(100))
                .limit(100);
        System.out.println(limit.sorted().takeWhile(it -> it < 10)
                .collect(Collectors.counting()));
    }

}
