import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution07 {
    public static void main(String[] args) {
        // 정렬 -> sort (하나의 차원 -> 데이터들을 나열하는 방식을 결정), align (화면 내 배치. 표현하려는 데이터들간의 관계. 화면상의 상대적 위치)
        runSort();
    }

    static void runSort() {
        List<String> list = new ArrayList<>(List.of("참치", "꽁치", "멸치"));
        System.out.println(list);
//        Collections.sort(list, Comparator.naturalOrder()); // 가나다순, 오름차순.
//        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder()); // 원본 힙주소에 연결된 객체에 영향을 준다
        // 1. 우리는 주어진 정렬 방법만 쓸 수 있는 건가? // 오름차순, 내림차순 외에는 정렬이 없나?
        // - 실은 '정렬'은 인터페이스를 만족시키는 '비교를 해주는 함수'로 2개의 원소를 처리한 다음 +냐 -냐 등으로 처리를 함.
        // 2. 일반적으로 '비교 가능한' (숫자, 숫자로 표현 가능한 문자) 값들은 제외한 참조 타입들 (객체) 들은 어떻게 비교하지?
        // - 메서드/함수로 정렬을 하는 거라면, 패러미터와 비교 연산자 등을 어떻게 쓸것인가? 기준점을 뭐로 잡을 거냐?
        System.out.println(list);
    }
}
