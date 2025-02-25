package prog2.util;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;
import java.util.function.Function;

public abstract class ScannerUtil {
    private static final Scanner sc = new Scanner(System.in);

    @SuppressWarnings("SameReturnValue")
    private static String alwaysValid(Object input) {
        return null;
    }

    public static String getString(String title) {
        return getString(title, ScannerUtil::alwaysValid);
    }

    public static String getString(String title, Function<String, String> isValid) {
        while (true) {
            System.out.println(title);
            final String str = sc.nextLine().trim();
            final String error = isValid.apply(str);
            if (error != null) {
                System.out.println(Ansi.ansi().fgBrightRed().a(error).reset());
                continue;
            }
            return str;
        }
    }

    public static int getInt(String title) {
        return getInt(title, ScannerUtil::alwaysValid);
    }

    public static int getInt(String title, Function<Integer, String> isValid) {
        while (true) {
            System.out.println(title);
            try {
                final int input = Integer.parseInt(sc.nextLine().trim());
                final String error = isValid.apply(input);
                if (error != null) {
                    System.out.println(Ansi.ansi()
                            .fgBrightRed()
                            .a(error)
                            .reset());
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Insira um número inteiro válido");
            }
        }
    }

}
