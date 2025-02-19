package prog2.game.log;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Log implements Serializable {
    private static Log instance;

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    @Serial
    private final static long serialVersionUID = 1L;
    private final List<String> lines = new ArrayList<>();

    private static String formatMessage(String message, LogType type) {
        return String.format("[ %s | %s ] %s\n", java.time.LocalDateTime.now(), type.name(), message);
    }

    public void write(Object message, LogType type) {
        final String formattedMessage = formatMessage(message.toString(), type);
        System.out.printf(formattedMessage);
        lines.add(formattedMessage);
    }

    public void game(Object message) {
        write(message, LogType.GAME);
    }

    public void error(Object message) {
        write(message, LogType.ERROR);
    }

    public Optional<File> export() {
        try {
            final Path path = Path.of("log.txt");
            Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            return Optional.of(path.toFile());
        } catch (IOException e) {
            System.out.println("Error writing log file");
            return Optional.empty();
        }
    }
}
