package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private Menus menusCantEat;
    private Menus randomMenus = new Menus();

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
        String randomMenu = menus.getRandomMenu();
        Menu menu = menus.findMenuByName(randomMenu);
        if (doesCoachCanEat(menu)) {
            randomMenus.addMenu(menu);
        }
        menus.removeMenu(menu);
    }

    private boolean doesCoachCanEat(Menu menu) {
        for (Menu menuCanEat : menusCantEat) {
            if (menuCanEat!=null && !menuCanEat.equals(menu)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getCategories() {
        return randomMenus.getCategories();
    }

    @Override
    public String toString() {
        String mon = randomMenus.findMenuByIndex(0).getName();
        String tue = randomMenus.findMenuByIndex(1).getName();
        String wed = randomMenus.findMenuByIndex(2).getName();
        String thu = randomMenus.findMenuByIndex(3).getName();
        String fri = randomMenus.findMenuByIndex(4).getName();

        return String.format("[ %s | %s | %s | %s | %s | %s ]", name, mon, tue, wed, thu, fri);
    }
}
