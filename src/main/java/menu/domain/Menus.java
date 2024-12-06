package menu.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menus implements Iterable<Menu> {
    private List<Menu> menus = new ArrayList<>();

    public List<Menu> addMenu(Menu menu) {
        menus.add(menu);
        return menus;
    }

    @Override
    public Iterator<Menu> iterator() {
        return menus.iterator();
    }
}
