package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import menu.util.FileParser;

public class MenuGenerator {
    private final FileParser fileParser = new FileParser();
    public Menus generateMenu(String filePath) {
        Map<String, List<String>> parsedMenu = parseFromFile(filePath);
        String parsedCategory = "";
        List<String> parsedMenus = null;
        for (Entry<String, List<String>> entry : parsedMenu.entrySet()) {
            parsedCategory = entry.getKey();
            parsedMenus = entry.getValue();
        }
        Menus menus = new Menus();
        for(int i=0; i<parsedMenus.size(); i++) {
            Menu menu = new Menu(parsedCategory, parsedMenus.get(i));
            menus.addMenu(menu);
        }
        return menus;
    }

    private Map<String, List<String>> parseFromFile(final String filePath) {
        List<String> parsedFile = Arrays.asList(fileParser.parseFromFile(filePath).get(0).split(":"));
        Map<String, List<String>> parsedFromFile = new HashMap<>();
        String category = parsedFile.get(0);
        List<String> menus = Arrays.stream(parsedFile.get(1).split(",")).map(String::trim).collect(Collectors.toList());
        parsedFromFile.put(category, menus);
        return parsedFromFile;
    }
}
