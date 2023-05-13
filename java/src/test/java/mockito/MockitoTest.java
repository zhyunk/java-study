package mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 * anyInt
 * argThat
 * spy()
 * InOrder
 *
 */
@DisplayName("Mockito 실습!")
class MockitoTest {
    ArrayList<String> list = mock();

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
        when(list.get(0)).thenReturn("zero");
        when(list.get(1)).thenReturn("??");
        when(list.get(5)).thenReturn("오");
        when(list.get(123)).thenReturn("오잉");
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
        when(
                list.get(
                        (Integer) Optional.ofNullable(
                                argThat(num -> (Integer)(num) < 5)
                        ).orElse(0)
                )
        ).thenReturn("👻");

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

    @Test
    @DisplayName("spy() 실습")
    void listTest3() {
        // 실제 객체 생성
        List<String> aList = new LinkedList<>();

        // 실제 객체를 wrapping 하는 spy 객체 생성
        List<String> spyList = spy(aList);

        // 이 다음 문장인 add 안 될 경우 size()를 임의로 늘려주면 됨
//        when(spyList.size()).thenReturn(100);

        // 실제 메서드 호출
        spyList.add("하하");
        spyList.add("우하하");

        System.out.println(spyList.get(0)); // 하하
        System.out.println(spyList.get(1)); // 우하하
        System.out.println(spyList.size()); // 2

        // spy 객체의 메소드 동작 변경
        when(spyList.get(1)).thenReturn("우하핳");
        System.out.println(spyList.get(1)); // 우하핳

        doReturn("HaHa").when(spyList).get(0);
        System.out.println(spyList.get(0)); // HaHa

        verify(spyList, times(2)).get(0);
        verify(spyList).size();
    }

    @Test
    @DisplayName("InOrder 실습")
    void listTest4() {
        // 비교할 Mock 객체 2개 생성
        List<String> first = mock();
        List<String> second = mock();

        first.add("하이");
        second.add("Hi");

        InOrder inOrder = inOrder(first, second);
        
        // 검증 성공
        inOrder.verify(first).add("하이");
        inOrder.verify(second).add("Hi");

        // 검증 실패
        inOrder.verify(second).add("Hi");
        inOrder.verify(first).add("하이");
    }
}
