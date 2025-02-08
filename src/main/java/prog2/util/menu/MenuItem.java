package prog2.util.menu;

import java.util.function.Supplier;

public class MenuItem<T> {
    private final String text;
    private final Supplier<T> action;

    public MenuItem(String text) {
        this.text = text;
        this.action = () -> null;
    }

    public MenuItem(String text, Supplier<T> action) {
        this.text = text;
        this.action = action;
    }

    public String getText() {
        return text;
    }

    public Supplier<T> getAction() {
        return action;
    }
}
