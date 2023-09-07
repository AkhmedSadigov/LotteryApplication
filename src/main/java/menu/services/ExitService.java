package menu.services;

import menu.service.interfaces.ExitServiceInterface;

public class ExitService implements ExitServiceInterface{
    @Override
    public void process() {
        System.out.println("Exit from system...");
        System.exit(0);
    }
}
