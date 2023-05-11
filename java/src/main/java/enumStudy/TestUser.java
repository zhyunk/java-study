package enumStudy;

import enumStudy.type.UserStatus;

public class TestUser {
    public static void main(String[] args) {
        int getCode = 999;

        // 이런식으로도 사용하려나..??🤔
        if (getCode == UserStatus.LOGIN.getCode())
            System.out.println(UserStatus.LOGIN.getMessage());

    }
}
