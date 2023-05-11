package functionalInterfaceStudy;

import java.util.function.Function;

/**
 * Function 함수형 인터페이스 실습
 */
public class Functionn {
    public static void main(String[] args) {

        // 기본 인터페이스 구현체 실습
        Integer indexLast = getLastIndex("Hello, World!");

        // andThen 메서드 실습
        andThenStudy();
    }
    public static void andThenStudy() {
        Function<Integer, Integer> f1 = num -> num * 2;
        Function<Integer, Integer> f2 = num -> num * num;

        Function<Integer, Integer> f = f1.andThen(f2);
        System.out.println(f.apply(3)); // 결과 값 : 3 * 2 -> 6 * 6 = 36
    }

    public static Integer getLastIndex(String text) {
        // 기본형 사용으로 Function 인터페이스 구현
        Function<String, Integer> getBasicLastIndex = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length() - 1;
            }
        };

        // 람다식 사용으로 Function 인터페이스 구현
        Function<String, Integer> getLambdaLastIndex = s -> s.length() - 1;

        System.out.println(
                getLambdaLastIndex.apply(text)
        );

        return getBasicLastIndex.apply(text);
    }
}
