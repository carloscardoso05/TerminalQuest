package prog2;

import prog2.game.Game;
import prog2.util.SaveService;

public class Main {
    public static void main(String[] args) {
        final Game game = new Game("Jogo teste");
        System.out.println(game);
        System.out.println(SaveService.save(game));
    }
}