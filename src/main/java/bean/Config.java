package bean;

import java.util.Scanner;

public class Config {

    private static Config config = null;

    public Competitor[] competitors = new Competitor[0];

    public static Config instance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public Competitor[] add(int number) {
        Competitor[] newCompetitors = new Competitor[number + competitors.length];
        for (int i = 0; i < competitors.length; i++) {
            newCompetitors[i] = competitors[i];
        }
        for (int i = competitors.length; i < newCompetitors.length; i++) {
            System.out.println((i+1)+". Competitor");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            Scanner sc2 = new Scanner(System.in);
            System.out.print("Enter surname: ");
            String surname = sc2.nextLine();

            Scanner sc3 = new Scanner(System.in);
            System.out.print("Enter age: ");
            int age = sc3.nextInt();

            newCompetitors[i] = new Competitor(name, surname, age);
        }
        System.out.println("Registered successfully!");
        competitors = newCompetitors;
        showAllCompetitors();
        return competitors;
    }

    public void showAllCompetitors() {
        for (int i = 0; i < competitors.length; i++) {
            System.out.println((i + 1) + ". " + competitors[i]);
        }
    }
}
