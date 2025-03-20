package lang;

public class CountObjectInstances {

    public static void main(String[] args) {

        System.out.println("Pre count: " + CounterClass.getCounter());
        
        new CounterClass();
        new CounterClass();
        new CounterClass();
        new CounterClass();
        new CounterClass();

        System.out.println("Post Count: "+ CounterClass.getCounter());
    }
}

class CounterClass {

    private static int counter = 0;

    {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
