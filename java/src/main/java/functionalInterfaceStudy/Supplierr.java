package functionalInterfaceStudy;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Supplierr {
    public static void main(String[] args) {
        getNowTime();
    }

    public static void getNowTime() {
        // 기본형
        Supplier<LocalDateTime> supplier = new Supplier<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now();
            }
        };
        System.out.println(
                supplier.get()
        );


        // 람다식
        Supplier<LocalDateTime> supplier2 = () -> LocalDateTime.now();
        System.out.println(
                supplier2.get()
        );


        // 메서드 참조
        Supplier<LocalDateTime> supplier3 = LocalDateTime::now;
        System.out.println(
                supplier3.get()
        );
    }

}
