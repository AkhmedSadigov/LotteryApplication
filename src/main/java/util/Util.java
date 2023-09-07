package util;

public class Util {

    public static int random(int min, int max) {
        int i = min + (int) (Math.random() * (max - min + 1));
        return i;
    }
}
