package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class MenuPicker {
    private final static List<String> categories = Arrays.asList("일식", "한식", "중식", "아시안", "양식");

    public List<String> pickRandomCategories() {
        List<String> randomCategories = new ArrayList<>();
        for (int i=0; i<5; i++) {
            String category = categories.get(Randoms.pickNumberInRange(1,5));
            randomCategories.add(category); // 한식 한식 한식 양식 중식
        }
        List<String> distinctCategories = randomCategories.stream().distinct().collect(Collectors.toList());
        // 한식 양식 중식
        if (randomCategories.size() - distinctCategories.size() >= 2) {
            return pickRandomCategories();
        }
        return randomCategories;
    }

}
