package prog2.game;

import java.io.*;

public abstract class GameService {
    private final static File saveFile = new File("game.ser");

    public static boolean save() {
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(Game.getInstance());

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean load() {
        try {
            final FileInputStream fileInputStream = new FileInputStream(saveFile);

            final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            final Game game = (Game) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            Game.instance = game;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
