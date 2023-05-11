package functionalInterfaceStudy;

import java.util.function.Predicate;

public class Predicatee {
    public static void main(String[] args) {
        isEvenOdd(4);
        isEvenOdd(3);

        isZero(0);
        isZero(321654);

    }

public static void isZero(int num) {
    Predicate<Integer> predicate = i -> i == 0;

    System.out.println(
            predicate.test(num)
                    ? "0을 입력하셨네여?"
                    : "0이 아니고 " + num + "입니다."
    );
}
public static void isEvenOdd(int num) {
    Predicate<Integer> predicate = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer % 2 == 0;
        }
    };

    System.out.println(
            predicate.test(num)
                    ? "짝수 입니다."
                    : "홀수 입니다."
    );
}
}
