package prog2.game.log;

import prog2.entities.actions.Action;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.players.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Log {
    private static Log instance;

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    private final List<String> lines = new ArrayList<>();

    private static String formatMessage(String message, LogType type) {
        return String.format("[ %s | %s ] %s\n", java.time.LocalDateTime.now(), type.name(), message)
                .replaceAll("\u001B\\[[;\\d]*m", "");
    }

    public void write(Object message, LogType type) {
        if (message == null) {
            return;
        }
        final String formattedMessage = formatMessage(message.toString(), type);
        System.out.print(message + "\n");
        lines.add(formattedMessage);
    }

    public void action(Player origem, List<Player> alvos, Action acao, ResultadoAtaque resultado) {
        final String msg = "%s usou %s em %s. Resultado: %s".formatted(origem, acao, alvos, resultado.name());
        game(msg);
    }

    public void action(Player origem, Player alvo, Action acao, ResultadoAtaque resultado) {
        action(origem, List.of(alvo), acao, resultado);
    }

    public void game(Object message) {
        write(message, LogType.GAME);
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
