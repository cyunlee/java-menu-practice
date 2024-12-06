package menu.domain;

import java.util.List;

public class MenuGenerator {
    public Menus generateMenu(String category, String name) {
        Menus menus = new Menus();

        for(int i=0; i<menus.getSize(); i++) {
            Menu menu = new Menu(category, name);
            menus.addMenu(menu);
        }
        return menus;
    }
}
