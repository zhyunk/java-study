package functionalInterfaceStudy;

import java.util.function.BiFunction;

public class BiFunctionn {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> sum = (a, b) -> String.valueOf(a + b);

        System.out.println( sum.apply(2, 3) );
    }
}
