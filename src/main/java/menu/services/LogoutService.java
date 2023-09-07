package menu.services;

import menu.service.interfaces.LogoutServiceInterface;
import util.Menu;

public class LogoutService implements LogoutServiceInterface{
    @Override
    public void process() {
        System.out.println("Log out from the system...");
        Menu.LOGIN.process();
    }
}
