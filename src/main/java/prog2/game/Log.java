package prog2.game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public abstract class Log {
    private static final File file = new File("log.txt");

    private static String formatMessage(String message) {
        return String.format("[%s] %s\n", java.time.LocalDateTime.now(), message);
    }

    private static void createFileIfDontExist() {
        if (!file.exists()) {
            try {
                Files.createFile(file.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void write(String message) {
        createFileIfDontExist();
        try {
            Files.writeString(file.toPath(), formatMessage(message), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
