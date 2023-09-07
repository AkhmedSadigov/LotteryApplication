package menu.services;

import bean.Config;
import java.util.Scanner;
import menu.service.interfaces.RegisterServiceInterface;
import util.MenuUtil;

public class RegisterService implements RegisterServiceInterface {

    @Override
    public void process() {
        try {
            Config config = Config.instance();
            Scanner sc = new Scanner(System.in);
            System.out.print("How many competitor will add: ");
            int number = sc.nextInt();
            config.add(number);
        } catch (Exception ex) {
            System.out.println("Please enter required type message!");
        }
        MenuUtil.showMenu();
    }
}
