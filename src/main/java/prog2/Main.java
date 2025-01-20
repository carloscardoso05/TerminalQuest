package prog2;

import prog2.game.Game;
import prog2.util.SaveService;
import prog2.util.PlayerFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Game game = SaveService.loadSave().orElseThrow();
        game.addPlayer(PlayerFactory.criarPlayerAleatorio("Jogador 1"));
        game.addPlayer(PlayerFactory.criarPlayerAleatorio("Jogador 2"));
        SaveService.save(game);
        System.out.println(game);
    }
}