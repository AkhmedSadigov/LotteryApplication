package util;

import java.util.Scanner;
import menu.services.LoginService;

public class MenuUtil {

    public static void startPage() {
        Menu.LOGIN.process();
    }

    public static void showMenu() {
        Menu[] menus = Menu.values();

        System.out.println("Menu: ");
        for (int i = 0; i < menus.length; i++) {
            if (menus[i] != Menu.LOGIN && menus[i] != Menu.UNKNOWN) {
                System.out.println(menus[i]);
            }
        }
        chooseService();
    }

    public static void chooseService() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose operation: ");
            int serviceNumber = sc.nextInt();

            Menu menu = Menu.choose(serviceNumber);
            if (menu != Menu.UNKNOWN) {
                menu.process();
            } else {
                System.out.println("Non-existent operation!");
            }
        } catch (Exception ex) {
            System.out.println("Please enter required type message!");
        }
        showMenu();
    }

    public static void run() {
        startPage();
        if (LoginService.getState() == false) {
            Menu.LOGOUT.process();
        } else {
            showMenu();
        }
    }

}
