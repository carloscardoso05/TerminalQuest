package prog2.util;

import prog2.game.Game;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class SaveService {
    private static final String FOLDER = "saves";

    private static String getFileName(Game game) {
        return game.getName() + ".save";
    }

    public static List<File> getSaveFiles(Game game) {
        try (final Stream<Path> paths = Files.list(Paths.get(FOLDER))) {
            return paths.map(Path::toFile).filter(File::isFile).toList();
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
            return List.of();
        }
    }

    public static boolean save(Game game) {
        try {
            final File file = new File(Path.of(FOLDER, getFileName(game)).toString());
            if (!file.exists()) {
                Files.createDirectories(Path.of(file.getParent()));
                Files.createFile(file.toPath());
            }
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(game);

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Optional<Game> load(File saveFile) {
        try {
            final FileInputStream fileInputStream = new FileInputStream(saveFile);

            final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            final Game game = (Game) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            return Optional.of(game);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
