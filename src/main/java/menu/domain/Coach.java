package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Coach {
    private String name;
    private Menus menusCantEat;
    private Menus randomMenus;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void modifyMenusCantEat(Menus menus) {
        this.menusCantEat = menus;
    }

    public void pickOneRandomMenu(Menus menus) {
        Menu randomMenu = menus.getRandomMenu();
        if (doesCoachCanEat(randomMenu)) {
            this.randomMenus.addMenu(randomMenu);
        }
        if (!doesCoachCanEat(randomMenu) || randomMenus.alreadyContainsMenu(randomMenu)) {
            pickOneRandomMenu(menus);
        }
    }

    private boolean doesCoachCanEat(Menu menu) {
        for (Menu menuCanEat : menusCantEat) {
            if (!menuCanEat.equals(menu)) {
                return true;
            }
        }
        return false;
    }
}
