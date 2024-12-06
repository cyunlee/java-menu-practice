package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuPickerController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String input = requireInput();
    }

    private String requireInput() {
        outputView.printPrompt();
        return inputView.readInput();
    }
}
