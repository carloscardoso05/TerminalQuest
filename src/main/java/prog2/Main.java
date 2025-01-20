package prog2;

import prog2.game.Game;
import prog2.game.GameService;
import prog2.players.PlayerFactory;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final File saveFile = new File("game.ser");
        final Game game = Game.getInstance();
        game.addPlayer(PlayerFactory.criarPlayerAleatorio("Jogador 1"));
        game.addPlayer(PlayerFactory.criarPlayerAleatorio("Jogador 2"));
        GameService.save();
        System.out.println(game);
    }
}