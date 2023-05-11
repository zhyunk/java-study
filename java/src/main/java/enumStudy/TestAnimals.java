package enumStudy;

import enumStudy.type.Animals;
import enumStudy.type.LikeEnumAnimals;

import java.util.Arrays;

public class TestAnimals {
    public static void main(String[] args) {

        printValues(); // [MONKEY, DOG, PANDA, CAT]
        printOrdinal();
        printKey();

    }
    public static void printValues() {
        System.out.println(
                Arrays.toString(Animals.values())
        );
    }
    public static void printOrdinal() {
        System.out.println(
                "Animals.MONKEY ========= "
                        + Animals.MONKEY.ordinal()
        );
        System.out.println(
                "Animals.DOG ========= "
                        + Animals.DOG.ordinal()
        );
    }
    public static void printKey() {
        System.out.println(
                "Animals.MONKEY ========= "
                        + Animals.MONKEY.getDescription()
        );

        System.out.println(
                "LikeEnumAnimals.MONKEY = "
                        + LikeEnumAnimals.MONKEY.getDescription()
        );
    }
}
