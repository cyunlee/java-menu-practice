package menu.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseInput(String input) {
        return Arrays.asList(input.split(","));
    }
}
