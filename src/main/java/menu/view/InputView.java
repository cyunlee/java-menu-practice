package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.InputValidator;
import menu.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public String readInput() {
        try{
            String input = Console.readLine();

        }catch(IllegalArgumentException exception) {

            return readInput();
        }
    }
}