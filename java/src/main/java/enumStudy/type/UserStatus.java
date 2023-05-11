package enumStudy.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    LOGIN(777, "로그인 했습니다."),
    LOGOUT(999, "로그아웃 했습니다.");

    private final int code;
    private final String message;
}
