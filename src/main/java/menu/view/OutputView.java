package menu.view;

import java.util.List;

public class OutputView {
    private final static String ERROR = "[ERROR] ";

    public void printStartPrompt() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printCoachNamesPrompt() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printCantEatMenus(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printResult(List<String> categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    public void printError(String message) {
        System.out.println(ERROR + message);
    }
}
