package mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
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
class MockitoGivenTest {
    ArrayList<String> list = mock();

    @Test
    @DisplayName("anyInt() 실습")
    void listTest1() {
        // 값 생성
        given(list.get(0)).willReturn("one");
        given(list.get(1)).willReturn("two");
        given(list.get(anyInt())).willReturn("🙈");

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
        given(list.get(0)).willReturn("zero");
        given(list.get(1)).willReturn("??");
        given(list.get(5)).willReturn("오");
        given(list.get(123)).willReturn("오잉");
        given(
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
        ).willReturn("🙈");
        given(
                list.get(
                        (Integer) Optional.ofNullable(
                                argThat(num -> (Integer)(num) < 5)
                        ).orElse(0)
                )
        ).willReturn("👻");

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
//        given(spyList.size()).willReturn(100);

        // 실제 메서드 호출
        spyList.add("하하");
        spyList.add("우하하");

        System.out.println(spyList.get(0)); // 하하
        System.out.println(spyList.get(1)); // 우하하
        System.out.println(spyList.size()); // 2

        // spy 객체의 메소드 동작 변경
        given(spyList.get(1)).willReturn("우하핳");
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

        InOrder inOrder = inOrder(first, second); // 순서를 검증할 목 객체 지정
        
        // 검증 성공
        inOrder.verify(first).add("하이");
        inOrder.verify(second).add("Hi");

        // 검증 실패
        inOrder.verify(second).add("Hi");
        inOrder.verify(first).add("하이");
    }
}
