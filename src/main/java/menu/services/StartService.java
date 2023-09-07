package menu.services;

import bean.Competitor;
import bean.Config;
import java.util.Scanner;
import menu.service.interfaces.StartServiceInterface;
import util.MenuUtil;
import util.Util;

public class StartService implements StartServiceInterface {

    @Override
    public void process() {
        try {
            if (Config.instance().competitors.length >= 2) {

                Competitor[] competitors = Config.instance().competitors;

                Competitor winner = null;

                int winnerNumber = Util.random(1, competitors.length);
                for (int i = 0; i < competitors.length; i++) {
                    if (winnerNumber == i + 1) {
                        winner = competitors[i];
                    }
                }

                Scanner sc = new Scanner(System.in);
                System.out.print("Write your predict: ");
                int predict = sc.nextInt();
                if (predict < 1 || predict > competitors.length) {
                    System.out.println("Please enter suitable number!");
                } else {
                    if (predict == winnerNumber) {
                        System.out.println("Congratulations you won!\nWinner is " + winner);
                    } else {
                        System.out.println("Sorry, you predict is false.\nWinner is " + winner);
                    }
                }
            } else {
                System.out.println("Please register at least 2 competitors!");
            }
        } catch (Exception ex) {
            System.out.println("Please enter required type message!");
        }
        MenuUtil.showMenu();
    }
}
