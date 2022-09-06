package SomeJava.SingletonPattern;

public class SingletonExample {
    private static volatile SingletonExample uniqueInstance;
    public static Integer counter = 0;

    private SingletonExample() {
        System.out.printf("%d instances created%n", ++counter);
    }

    public static synchronized SingletonExample getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonExample.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new SingletonExample();
            }
        }

        return uniqueInstance;
    }
}
