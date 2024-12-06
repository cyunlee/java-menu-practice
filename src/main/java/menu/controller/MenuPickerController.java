package menu.controller;

import java.util.List;
import menu.common.Constants;
import menu.domain.Coach;
import menu.domain.CoachGenerator;
import menu.domain.Coaches;
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
        Menus asianMenus = generateMenus(Constants.ASIAN_PATH);
        Menus chineseMenus = generateMenus(Constants.CHINESE_PATH);
        Menus japaneseMenus = generateMenus(Constants.JAPANESE_PATH);
        Menus koreanMenus = generateMenus(Constants.KOREAN_PATH);
        Menus westernMenus = generateMenus(Constants.WESTERN_PATH);

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

    private void processMenuPicker(List<Menus> menus, Coaches coaches) {
        MenuPicker menuPicker = new MenuPicker()
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
