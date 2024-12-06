package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.exception.InputValidator;
import menu.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public List<String> readCoachNames() {
        String input = Console.readLine();
        return inputParser.parseInput(input);
    }

    public List<String> readCantEatMenu() {
        try {
            String input = Console.readLine();
            inputValidator.validateInput(input);
            return inputParser.parseInput(input);
        }catch(IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return readCantEatMenu();
        }

    }


}