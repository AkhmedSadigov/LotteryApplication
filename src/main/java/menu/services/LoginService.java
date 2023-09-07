package menu.services;

import java.util.Scanner;
import menu.service.interfaces.LoginServiceInterface;
import util.Menu;
import util.MenuUtil;

public class LoginService implements LoginServiceInterface {

    private final String username = "admin";
    private final String password = "12345";

    private String enteredUsername;
    private String enteredPassword;
    
    private static boolean state = false;

    public void enterCredentials() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        enteredUsername = sc.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter password: ");
        enteredPassword = sc2.nextLine();
    }

    @Override
    public void process() {
        System.out.println("Login to system");
        
        int failCount=0;
        int successCount=0;
        
        while (failCount < 3 && successCount < 1) {
            enterCredentials();
            if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
                successCount++;
                System.out.println("Log in successfully!");
                state = true;
                MenuUtil.showMenu();
            } else {
                failCount++;
                if (failCount != 3) {
                    System.out.println("Username or password is incorrect. Please try again");
                }
                if (failCount == 3) {
                    System.out.println("You're banned");
                    Menu.EXIT.process();
                }
            }
        }
    }

    public static boolean getState() {
        return state;
    }
}
