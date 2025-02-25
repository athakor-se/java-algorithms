package java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    static int i = 0; //1
    int j = 0; //2
    static {
        System.out.println("In static block" + i);
    } //3
    {
        j = 1;
        System.out.println("In instance initializer block" + j);
    } //4
    {
        j = 2;
        System.out.println("In instance initializer block 2" + j);
    } //5
    public Main() {
        System.out.println("In constructor");
    }
    public static void test() {
        System.out.println("test");
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        new Main();
        System.out.println("In main method");
        HashMap<Object, Object> hashMap = new HashMap<>() {{
            put(new MapKey("A", ""), new Object());
            put(new MapKey("B", ""), new Object());
            put(new MapKey("C", ""), new Object());
        }};
//        var test = new LinkedList<String>(){{
//            add("a");
//            add("b");
//            add("c");
//            add("d");
//        }};
//        Iterator iterator = test.descendingIterator();
//        for (; iterator.hasNext();) {
//            System.out.println(iterator.next());
//        }
//        new java.Test().getString();
//        java.Main main = new java.Main();
//        int a = main.j;
//        java.Main.test();
        Builder builder = Builder.getInstance()
                .setI(0)
                .setJ(1)
                .setK(2);
    }
}

class MapKey {
    String key;
    String value;

    public MapKey(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MapKey mapKey = (MapKey) o;
        return Objects.equals(key, mapKey.key) && Objects.equals(value, mapKey.value);
    }

    @Override
    public int hashCode() {
        var hashCode = Objects.hashCode(this);
        return hashCode;
    }
}

class Test extends Main {
    Map<String, Object> String = new HashMap<>(){{
        put("1", 1);
        put("1", 2);
    }};

    public static void main(String[] args) {
        long limit = 100001;
        for (Integer i = 1; ; i = i * 1999) {
            if (limit-- == 0) break;
            System.out.println(i + " " + i.getClass());
        }
        Stream.generate(new Random()::nextInt).forEach(System.out::println);

        Map.of("","","","");
    }
    public void getString() {
        System.out.println(String);
    }
}

class Builder {
    int i, j, k;

    private Builder() {

    }
    public static Builder getInstance() {
        return new Builder();
    }

    public Builder setI(int i) {
        this.i = i;
        return this;
    }

    public int getI() {
        return i;
    }

    public Builder setJ(int j) {
        this.j = j;
        return this;
    }

    public int getJ() {
        return j;
    }

    public Builder setK(int k) {
        this.k = k;
        return this;
    }

    public int getK() {
        return k;
    }
}