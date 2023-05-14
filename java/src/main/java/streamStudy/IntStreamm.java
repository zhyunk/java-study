package streamStudy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        for (int num : arr) {
            System.out.println(num);
        }

        IntStream is = Arrays.stream(arr);
        is.forEach(System.out::println);

        System.out.println("==================================================");

        System.out.println(sum(arr));

        System.out.println(count(arr));
        System.out.println(count2(arr));

        System.out.println(sum2(arr));
    }

    private static int sum(int[] arr) {
        IntStream is = Arrays.stream(arr);
        return is.sum();
    }

    private static long count(int[] arr) {
        // 이렇게 사용하는건 arr.length와 같으니까 의미가 없고, 중간 연산자를 이용해서 써야 하나보다
        return Arrays.stream(arr).count();
    }

    private static long count2(int[] arr) {
        // 2보다 큰 수만 카운트

        // boolean filter(Predicate<T>)
        return Arrays.stream(arr)
                .filter(n -> n > 2)
                .count();
    }

    private static long sum2(int[] arr) {
        // map 과 count는 안맞는것 같다는 생각이 들었다. sum으로 변경!

        // T map(UnaryOperator<T>) 오호 티맵
        return Arrays.stream(arr)
                .map(n -> n * 2)
                .sum();
    }
}
