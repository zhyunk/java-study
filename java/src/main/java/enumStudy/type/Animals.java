package enumStudy.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Animals {
    MONKEY("원숭이🙉"),
    DOG("강아지"),
    PANDA("팬더"),
    CAT("고양이");

    private final String description;
}
