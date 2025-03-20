package lang.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    private static List<Integer> LIST = Arrays.asList(3,56,77,8,9,7,6,4,6,4,11,6,55,78);

    public static void main(String[] args) {
//        StreamDemo.findDuplicateOrCountOfNumber();
        StreamDemo.findPairOfCharacters();
    }

    public static void findDuplicateOrCountOfNumber() {
        Set<Integer> set = new HashSet<>();
        Set<Integer> b = LIST.stream().filter(s -> !set.add(s)).collect(Collectors.toSet());

        var map = LIST.stream()
                .collect(Collectors.groupingBy(Function.identity()
                        , Collectors.counting()));

        List<Person> person = new ArrayList<>();
        var map1 = map.merge(1,2L, (k,v) -> k);
        System.out.println(map);

        var sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k,v) -> k));
        System.out.println(sortedMap);

        LIST.stream().filter(i -> Collections.frequency(LIST, i) > 1)
                .collect(Collectors.toSet());

        String s = "abcdabcde";
        var charCount = Stream.of(s.toCharArray())
                .collect(Collectors.groupingBy(Function.identity()
                        , Collectors.counting())); // Need to enhance as return with map
        System.out.println(charCount);


        IntStream.rangeClosed(1 , 10).boxed().forEach(System.out::println);

        A a = new AB();
        System.out.println(a.test());
    }

    public static void findPairOfCharacters(){
        Arrays.stream("AABABCDADX".chars().toArray());
        Arrays.stream("AABABCDADX".split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(m -> {m.setValue(m.getValue()/2); return m;})
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet().forEach(f -> System.out.println("k -> "+f.getKey()+", v -> "+f.getValue()));
    }

    public void findPairOfCharacterss(){
        Arrays.stream("AABABCDADX".split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(m -> {m.setValue(m.getValue()/2); return m;})
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet().forEach(f -> System.out.println("k -> "+f.getKey()+", v -> "+f.getValue()));
        findPairOfCharacters();
    }
}

class Person {
    private String id;
    private String name;
    private Integer age;
    private Integer salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Person(int age) {
        this.age = age;
    }
}

interface A{
    void print();

    default boolean test(){
        try {
            int i = 5 / 0;
            return true;
        } catch (Exception ex) {
            return true;
        }finally {
            System.out.println("Finally executed");
//            return true;
        }
//        System.out.println("A");
//        return false;
    }
}

@FunctionalInterface
interface B {
    void print();

    default boolean test() {
        System.out.println("B");
        return false;
    }
}

@FunctionalInterface
interface C {
    void print();

    default boolean test() {
        System.out.println("B");
        return false;
    }
}

class AB implements A,B {

    @Override
    public void print() {
        System.out.println("Hi");
    }

    @Override
    public boolean test() {
        return A.super.test();
    }
}


