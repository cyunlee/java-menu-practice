package menu.domain;

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
}
