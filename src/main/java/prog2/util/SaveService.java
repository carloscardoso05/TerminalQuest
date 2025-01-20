package prog2.util;

import prog2.game.Game;

import java.io.*;
import java.util.Optional;

public abstract class SaveService {
    private static final File saveFile = new File("game.ser");

    public static boolean save(Game game) {
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(game);

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Optional<Game> loadSave() {
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
