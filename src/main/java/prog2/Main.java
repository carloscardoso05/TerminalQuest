package prog2;

import prog2.game.Game;

public class Main {
    public static void main(String[] args) {
//        final Game game = SaveService.selectGame();
        final Game game = new Game("Terminal Quest");
        game.run();
    }
}