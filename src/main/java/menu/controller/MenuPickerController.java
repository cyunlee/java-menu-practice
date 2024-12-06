package menu.controller;

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
        Menus asianMenus = generateMenus(Constants.)
    }

    public Menus generateMenus(String filePath) {
        return menuGenerator.generateMenu(filePath);
    }

    private String requireInput() {
        outputView.printPrompt();
        return inputView.readInput();
    }
}
