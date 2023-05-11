package enumStudy.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeEnumAnimals {
    public static final LikeEnumAnimals MONKEY = new LikeEnumAnimals("몽키 🙉");
    public static final LikeEnumAnimals DOG = new LikeEnumAnimals("강아지");
    public static final LikeEnumAnimals PANDA = new LikeEnumAnimals("팬다 😠");
    public static final LikeEnumAnimals CAT = new LikeEnumAnimals("고양이");

    private final String description;
}
