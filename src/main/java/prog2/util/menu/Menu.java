package prog2.util.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu<T> {
    final String title;
    final Scanner sc = new Scanner(System.in);
    final Map<String, MenuItem<T>> options = new HashMap<>();

    public Menu(String title, Map<String, MenuItem<T>> options) {
        this.options.putAll(options);
        this.title = title;
    }

    public Menu(Map<String, MenuItem<T>> options) {
        this("", options);
    }

    public MenuResult<T> show() {
        while (true) {
            if (!(title == null || title.isBlank())) {
                System.out.println(title);
            }
            for (Map.Entry<String, MenuItem<T>> option : options.entrySet()) {
                System.out.println(option.getKey() + ": " + option.getValue().getText());
            }
            final String input = sc.nextLine().trim();
            if (!options.containsKey(input)) {
                System.out.println("Invalid input\n");
                continue;
            }
            final MenuItem<T> item = options.get(input);
            return new MenuResult<>(input, item.getText(), item.getAction());
        }
    }
}
