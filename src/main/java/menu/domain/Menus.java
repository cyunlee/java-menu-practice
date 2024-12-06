package menu.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class Menus implements Iterable<Menu> {
    private List<Menu> menus = new ArrayList<>();

    public Menus() {

    }

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> addMenu(Menu menu) {
        menus.add(menu);
        return menus;
    }

    public Menu findMenuByName(String name) {
        for (Menu menu : menus) {
            if (name!=null && menu.isMenuExist(name)) {
                return menu;
            }
        }
        return null;
    }

    public Menu findMenuByIndex(int idx) {
        return menus.get(idx);
    }

    public boolean isCategoryMatched(String category) {
        if (category.equals(getCategory())) {
            return true;
        }
        return false;
    }

    public String getRandomMenu() {
        List<String> menusForRandom = menus.stream().map(Menu::getName).collect(Collectors.toList());
        return Randoms.shuffle(menusForRandom).get(0);
    }

    public boolean alreadyContainsMenu(Menu menu) {
        if (menus.contains(menu)) {
            return true;
        }
        return false;
    }

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();

        for (Menu menu : menus) {
            categories.add(menu.getCategory());
        }

        return categories;
    }

    private String getCategory() {
        return menus.get(0).getCategory();
    }

    public void removeMenu(Menu menu){
        menus.remove(menu);
    }

    @Override
    public Iterator<Menu> iterator() {
        return menus.iterator();
    }
}
