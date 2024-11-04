package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final List<Lotto> lottoTickets = new ArrayList<>();


    public Lotto() {
        this.numbers = generateLotto();
    }

    private List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if(number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하 숫자여야 합니다.");
        }
    }
    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers); // 번호 정렬
        return sortedNumbers.toString(); // 정렬된 번호를 문자열로 반환
    }

}