package lecture2HW;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String[] args) {

//        Collection<Integer> collection = Arrays.asList(1, 2, 3, 0, -1, 10, 11, -20, 40);
//        Stream<Integer> streamFromCollection = collection.stream();

//        System.out.println("Все элементы коллекции больше 0:");
//        streamFromCollection.filter(i -> i > 0).forEach(System.out::println);
//        System.out.println("Все элементы коллекции меньше 0:");
//        streamFromCollection.filter(i -> i < 0).forEach(System.out::println);
//        System.out.println("Все элементы коллекции кратны 5:");
//        streamFromCollection.filter(i -> i % 5 == 0).forEach(System.out::println);
//        System.out.println("Все элементы коллекции кратны 10:");
//        streamFromCollection.filter(i -> i % 10 == 0).forEach(System.out::println);

        System.out.println("Все элементы коллекции кратны 10:");
        Collection<Integer> collection = Arrays.asList(1, 2, 3, 0, -1, 10, 11, -20, 40);
        Queue<Integer> streamFromCollection = collection.stream().filter(i -> i % 10 == 0).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(streamFromCollection);


    }

}
