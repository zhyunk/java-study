package streamStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("뽀로로");
        list.add("루피");
        list.add("에디");

        System.out.println("\n출력 ==================");
        print1(list);

        System.out.println("\n정렬 후 출력 ==================");
        print2(list);

        System.out.println("\n각 문자열 길이 출력 ==================");
        print3(list);

        System.out.println("\n각 문자열 길이가 2보다 큰 문자열 출력 ==================");
        print4(list);
    }
    private static void print1(List<String> list) {
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }
    private static void print2(List<String> list) {
        Stream<String> stream = list.stream();
        stream.sorted().forEach(System.out::println);
    }
    private static void print3(List<String> list) {
        Stream<String> stream = list.stream();
        stream.map(String::length)
                .forEach(System.out::println);
    }
    private static void print4(List<String> list) {
        Stream<String> stream = list.stream();
        stream.filter(s -> s.length() > 2)
                .forEach(System.out::println);
    }
}
