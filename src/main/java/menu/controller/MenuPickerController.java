package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
    private Menus asianMenus;
    private Menus chineseMenus;
    private Menus japaneseMenus;
    private Menus koreanMenus;
    private Menus westernMenus;

    public void run() {
        start();
        asianMenus = generateMenus(Constants.ASIAN_PATH);
        chineseMenus = generateMenus(Constants.CHINESE_PATH);
        japaneseMenus = generateMenus(Constants.JAPANESE_PATH);
        koreanMenus = generateMenus(Constants.KOREAN_PATH);
        westernMenus = generateMenus(Constants.WESTERN_PATH);
        List<Menus> allMenus = Arrays.asList(asianMenus, chineseMenus, japaneseMenus, koreanMenus, westernMenus);
        Coaches coaches = generateCoaches(requireCoachNames());
        for (Coach coach : coaches) {
            List<String> menusCoachCantEat = requireMenusCoachCantEat(coach.getName());
            if (menusCoachCantEat!=null) {
                Menus menusCantEat = menuGenerator.generateMenuFromString(menusCoachCantEat, allMenus);
                coach.modifyMenusCantEat(menusCantEat);
            }
        }
        processMenuPicker(coaches);
        showMenuPickerResult(findCategories(coaches), coaches);
    }

    private Menus generateMenus(String filePath) {
        return menuGenerator.generateMenu(filePath);
    }

    private Coaches generateCoaches(List<String> coachNames) {
        return coachGenerator.generateCoaches(coachNames);
    }

    private void start() {
        outputView.printStartPrompt();
    }

    private void processMenuPicker(Coaches coaches) {
        MenuPicker menuPicker = new MenuPicker();
        List<String> randomCategories = menuPicker.pickRandomCategories(); // 양식 일식 한식 중식 중식


        for (String randomCategory : randomCategories) {
            if (asianMenus.isCategoryMatched(randomCategory)) { //아시안 카테고리에서 하나 고르기!
                coaches.pickOneRandomMenuForAll(asianMenus);
            }

            if (chineseMenus.isCategoryMatched(randomCategory)) {
                coaches.pickOneRandomMenuForAll(chineseMenus);
            }

            if (japaneseMenus.isCategoryMatched(randomCategory)) {
                coaches.pickOneRandomMenuForAll(japaneseMenus);
            }

            if (koreanMenus.isCategoryMatched(randomCategory)) {
                coaches.pickOneRandomMenuForAll(koreanMenus);
            }

            if (westernMenus.isCategoryMatched(randomCategory)) {
                coaches.pickOneRandomMenuForAll(westernMenus);
            }
        }
    }

    private List<String> findCategories(Coaches coaches) {
        Coach coach = coaches.findCoachByIdx(0);
        return coach.getCategories();
    }

    private List<String> requireCoachNames() {
        outputView.printCoachNamesPrompt();
        return inputView.readCoachNames();
    }

    private List<String> requireMenusCoachCantEat(String coachName) {
        outputView.printCantEatMenus(coachName);
        return inputView.readCantEatMenu();
    }

    private void showMenuPickerResult(List<String> categories, Coaches coaches) {
        outputView.printResult(categories, coaches);
    }
}
