package menu.domain;

import java.util.Objects;

public class Menu {
    private String category;
    private String name;

    public Menu(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public boolean isMenuExist(String name) {
        if (this.name.equals(name)) {
            return true;
        }
        return false;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
