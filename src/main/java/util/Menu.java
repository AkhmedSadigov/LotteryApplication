package util;

import menu.service.interfaces.MenuService;
import menu.services.ExitService;
import menu.services.LoginService;
import menu.services.LogoutService;
import menu.services.RegisterService;
import menu.services.StartService;

public enum Menu {
    LOGIN(new LoginService()),
    REGISTER(1, "Register", new RegisterService()),
    START(2, "Start competition", new StartService()),
    LOGOUT(3, "Log out", new LogoutService()),
    EXIT(4, "Exit", new ExitService()),
    UNKNOWN();

    private int number;
    private String label;
    private MenuService menuService;

    Menu() {
    }

    Menu(MenuService menuService) {
        this.menuService = menuService;
    }

    Menu(int number, String label, MenuService menuService) {
        this.number = number;
        this.label = label;
        this.menuService = menuService;
    }

    public void process() {
        menuService.process();
    }

    @Override
    public String toString() {
        return number + ". " + label;
    }

    public int getNumber() {
        return number;
    }

    public String getLabel() {
        return label;
    }

    public static Menu choose(int number) {
        Menu[] menus = Menu.values();
        for (int i = 0; i < menus.length; i++) {
            if (menus[i].getNumber() == number) {
                return menus[i];
            }
        }
        return UNKNOWN;
    }
}
