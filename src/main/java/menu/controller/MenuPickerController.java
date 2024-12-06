package menu.controller;

import java.util.List;
import menu.common.Constants;
import menu.domain.Coach;
import menu.domain.CoachGenerator;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.MenuGenerator;
import menu.domain.MenuPicker;
import menu.domain.Menus;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuPickerController {
    private final MenuGenerator menuGenerator = new MenuGenerator();
    private final CoachGenerator coachGenerator = new CoachGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        start();
        Coaches coaches = generateCoaches(requireCoachNames());
        for (Coach coach : coaches) {
            List<String> menusCoachCantEat = requireMenusCoachCantEat(coach.getName());
            Menus menusCantEat = menuGenerator.generateMenuFromString(menusCoachCantEat);
            coach.modifyMenusCantEat(menusCantEat);
        }
        showMenuPickerResult();
    }

    public Menus generateMenus(String filePath) {
        return menuGenerator.generateMenu(filePath);
    }

    public Coaches generateCoaches(List<String> coachNames) {
        return coachGenerator.generateCoaches(coachNames);
    }

    private void start() {
        outputView.printStartPrompt();
    }

    private void processMenuPicker(Coaches coaches) {
        MenuPicker menuPicker = new MenuPicker();
        List<String> randomCategories = menuPicker.pickRandomCategories(); // 양식 일식 한식 중식 중식
        Menus asianMenus = generateMenus(Constants.ASIAN_PATH);
        Menus chineseMenus = generateMenus(Constants.CHINESE_PATH);
        Menus japaneseMenus = generateMenus(Constants.JAPANESE_PATH);
        Menus koreanMenus = generateMenus(Constants.KOREAN_PATH);
        Menus westernMenus = generateMenus(Constants.WESTERN_PATH);

        for (String randomCategory : randomCategories) {
            if (asianMenus.isCategoryMatched(randomCategory)) { //아시안 카테고리에서 하나 고르기!

            }

            if (chineseMenus.isCategoryMatched(randomCategory)) {

            }

            if (japaneseMenus.isCategoryMatched(randomCategory)) {

            }

            if (koreanMenus.isCategoryMatched(randomCategory)) {

            }

            if (westernMenus.isCategoryMatched(randomCategory)) {

            }
        }
    }

    private List<String> requireCoachNames() {
        outputView.printCoachNamesPrompt();
        return inputView.readCoachNames();
    }

    private List<String> requireMenusCoachCantEat(String coachName) {
        outputView.printCantEatMenus(coachName);
        return inputView.cantEatMenu();
    }

    private void showMenuPickerResult(List<String> categories, ) {
        outputView.printResult();
    }
}
