package functionalInterfaceStudy;

import java.util.function.BinaryOperator;

public class BinaryOperatorr {
    public static void main(String[] args) {
        print("monkey", "monday..");
        print2("monkey", "monday..");
    }
    
    public static void print(String str1, String str2) {

        BinaryOperator<String> bo = new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s.length() >= s2.length() ? s : s2;
            }
        };
        System.out.println( bo.apply(str1, str2) );
    }

    public static void print2(String str1, String str2) {

        BinaryOperator<String> bo = (s, s2) -> s.length() >= s2.length() ? s : s2;
        System.out.println( bo.apply(str1, str2) );

    }
}
