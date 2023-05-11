package functionalInterfaceStudy;

import java.util.function.Consumer;

public class Consumerr {
    public static void main(String[] args) {
        print();
    }
    public static void print() {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.printf("\"%s\" 입력 받았슴다 🤓\n", s);
            }
        };
        consumer.accept("가나다라");


        Consumer<String> consumer2 = s -> System.out.printf("\"%s\" 입력 받았슴다 🤓\n", s);
        consumer2.accept("아자차카타파하하하하하");


        // 응용 : 메서드 참조 사용하기
        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("하하 🙈");

    }
}
