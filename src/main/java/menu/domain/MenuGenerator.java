package menu.domain;

import java.util.List;

public class MenuGenerator {
    public Menus generatorMenu() {
        Menus menus = new Menus();

        for(int i=0; i<menus.size(); i++) {
            Menu menu = new Menu();
            menus.addMenu(menu);
        }
        return menus;
    }
}
