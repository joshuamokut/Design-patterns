package SomeJava.TemplatePattern;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Duck implements Comparable {
    private final String name;
    private final int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s weighs %d", name, weight);
    }


    @Override
    public int compareTo(@NotNull Object o) {
        Duck other = (Duck) o;
        return Integer.compare(weight, other.weight);
    }

    public static void testDuckCompare() {
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2),
                new Duck("Howard", 7),
                new Duck("Louie", 2),
                new Duck("Donald", 10),
                new Duck("Huey", 2)
        };

        System.out.println("Before sorting: ");
        display(ducks);

        Arrays.sort(ducks);
        System.out.println("\nAfter sorting: ");
        display(ducks);
    }

    private static void display(Object[] objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}
