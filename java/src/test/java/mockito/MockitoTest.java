package mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Mockito 실습!")
class MockitoTest {
    ArrayList list = mock();

    @Test
    @DisplayName("anyInt() 실습")
    void listTest1() {
        // 값 생성
        when(list.get(0)).thenReturn("one");
        when(list.get(1)).thenReturn("two");
        when(list.get(anyInt())).thenReturn("🙈");

        // 값 확인
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        // 호출 여부 검증
        verify(list).get(0);
        verify(list).get(1);
    }

    @Test
    @DisplayName("argThat() 실습")
    void listTest2() {
        // 값 생성
        when(
                list.get(
                        Optional.ofNullable(
                                argThat(new ArgumentMatcher<Integer>() {
                                    @Override
                                    public boolean matches(Integer argument) {
                                        return argument >= 5;
                                    }
                                })
                        ).orElse(0)
                )
        ).thenReturn("🙈");

        // 값 확인
        System.out.println(list.get(5));
        System.out.println(list.get(1));
        System.out.println(list.get(123));

        // 검증
        verify(list, times(2)).get(
                Optional.ofNullable(
                        argThat(new ArgumentMatcher<Integer>() {
                            @Override
                            public boolean matches(Integer argument) {
                                return argument >= 5;
                            }
                        })
                ).orElse(0)
        );
    }
}