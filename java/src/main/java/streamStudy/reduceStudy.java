package streamStudy;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class reduceStudy {
    public static void main(String[] args) {
        String[] arr = {"안녕하세요!", "Hi!", "Hi~~~", "Hello!", "Hello~~~", "안녕하세요 ^^"};

        System.out.println( print1(arr) ); // 초기값초기값초기값초기값초기값초기값초기값초기값초기값
        System.out.println( print2(arr) ); // Hello~~~
    }

    private static String print1(String[] arr) {
        return Arrays
                .stream( arr )
                .reduce(
                        "초기값초기값초기값초기값초기값초기값초기값초기값초기값",
                        (s1, s2) -> s1.length() >= s2.length() ? s1 : s2
                );
    }

    private static String print2(String[] arr) {
        return Arrays.stream(arr).reduce(new CompareString()).get();
    }
}

class CompareString implements BinaryOperator<String> {

    @Override
    public String apply(String s1, String s2) {
        return s1.length() >= s2.length() ? s1 : s2;
    }
}