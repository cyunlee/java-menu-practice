package menu.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Menus implements Iterable<Menu> {
    private List<Menu> menus;

    public Menus() {

    }

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> addMenu(Menu menu) {
        menus.add(menu);
        return menus;
    }

    public Menu findMenu(String name) {
        for (Menu menu : menus) {
            if (menu.isMenuExist(name)) {
                return menu;
            }
        }
        return null;
    }

    public boolean isCategoryMatched(String category) {
        if (category.equals(getCategory())) {
            return true;
        }
        return false;
    }

    public Menu getRandomMenu() {
        int randomIdx = Randoms.pickNumberInRange(0, menus.size()-1);
        return menus.get(randomIdx);
    }

    private String getCategory() {
        return menus.get(0).getCategory();
    }

    @Override
    public Iterator<Menu> iterator() {
        return menus.iterator();
    }
}
