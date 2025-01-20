package prog2.util;

import prog2.game.GameState;

import java.io.*;
import java.util.Optional;

public abstract class GameStateService {
    private static final File saveFile = new File("game.ser");

    public static boolean save(GameState gameState) {
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(gameState);

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Optional<GameState> loadSave() {
        try {
            final FileInputStream fileInputStream = new FileInputStream(saveFile);

            final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            final GameState gameState = (GameState) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            return Optional.of(gameState);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
