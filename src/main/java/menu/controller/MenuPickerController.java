package menu.controller;

import java.util.List;
import menu.common.Constants;
import menu.domain.MenuGenerator;
import menu.domain.Menus;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuPickerController {
    private final MenuGenerator menuGenerator = new MenuGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String input = requireInput();
        Menus asianMenus = generateMenus(Constants.ASIAN_PATH);
        Menus chineseMenus = generateMenus(Constants.CHINESE_PATH);
        Menus japaneseMenus = generateMenus(Constants.JAPANESE_PATH);
        Menus koreanMenus = generateMenus(Constants.KOREAN_PATH);
        Menus westernMenus = generateMenus(Constants.WESTERN_PATH);
    }

    public Menus generateMenus(String filePath) {
        return menuGenerator.generateMenu(filePath);
    }

    private List<String> requireCoachNames() {
        outputView.printCoachNamesPrompt();
        return inputView.readCoachNames();
    }
}
