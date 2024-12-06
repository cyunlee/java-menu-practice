package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private Menus menusCantEat;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void modifyMenusCantEat(Menus menus) {
        this.menusCantEat = menus;
    }
}
