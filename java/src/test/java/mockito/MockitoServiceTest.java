package mockito;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("DB Test")
@ExtendWith(MockitoExtension.class)
public class MockitoServiceTest {

    @Mock // UserRepository 타입의 모의 객체 생성
    UserRepository userRepository;

    @InjectMocks // 모의 객체 주입
    UserService userService;

    @Test
    void insert() {
        User user = new User(1, "몽키", "monkey@zh.kim");

        given( userRepository.findById(1) ).willReturn( Optional.of(user) );

        User result = userService.getUserById(1);

        assertEquals( user, result );
        verify( userRepository, times(1) ).findById(1);

        System.out.println(result.toString());
    }
    @Test
    void insert2() {
        User user = new User(2, "코알라", "native.bear@zh.kim");

        given( userRepository.findById(1) ).willReturn( Optional.of(user) );

        User result = userService.getUserById(1);

        assertEquals(user, result);
        verify( userRepository, times(1) ).findById(1);

        System.out.println(result.toString());
    }

}
