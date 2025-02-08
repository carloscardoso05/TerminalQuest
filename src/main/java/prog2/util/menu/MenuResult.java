package prog2.util.menu;

import java.util.function.Supplier;

public class MenuResult<T> {
    private final String key;
    private final String text;
    private final Supplier<T> action;

    public MenuResult(String key, String text, Supplier<T> action) {
        this.key = key;
        this.text = text;
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public Supplier<T> getAction() {
        return action;
    }
}
