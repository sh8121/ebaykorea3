package tdd.examples.mockito;

import org.mockito.Mockito;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// Mocking과 Verification
public class Examples01 {
    public static void main(String[] args){
        // mock
        List mockedList = Mockito.mock(List.class);// List를 구현하는 Mock객체를 반환
        // mockedList레펀스가 참조하는 객체의 클래스 이름.
        System.out.println(mockedList.getClass().getName());

        // mock 사용하기
        mockedList.add("two");
        mockedList.clear();

        // verification
        Mockito.verify(mockedList).add("two");
        Mockito.verify(mockedList).clear();
    }
}
