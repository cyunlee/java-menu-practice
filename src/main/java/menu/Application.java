package menu;

import menu.controller.MenuPickerController;

public class Application {
    public static void main(String[] args) {
        MenuPickerController menuPickerController = new MenuPickerController();
        menuPickerController.run();
    }
}
