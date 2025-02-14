package prog2;

import prog2.game.Game;
import prog2.util.SaveService;

public class Main {
    public static void main(String[] args) {
//        final Game game = SaveService.selectGame();
        final Game game = new Game("Jogo");
        game.run();
    }
}