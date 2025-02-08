package prog2.util;

import java.util.Scanner;
import java.util.function.Function;

public abstract class ScannerUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String title) {
        return getString(title, (str) -> null);
    }

    public static String getString(String title, Function<String, String> isValid) {
        while (true) {
            System.out.println(title);
            final String str = sc.nextLine();
            final String error = isValid.apply(str);
            if (error != null) {
                System.out.println(error);
                continue;
            }
            return str;
        }
    }
}
