package prog2;

import prog2.game.GameState;
import prog2.util.GameStateService;
import prog2.util.PlayerFactory;

public class Main {
    public static void main(String[] args) {
        final GameState gameState = GameStateService.loadSave().orElseThrow();
        gameState.addPlayer(PlayerFactory.criarPlayerAleatorio("Jogador 1"));
        gameState.addPlayer(PlayerFactory.criarPlayerAleatorio("Jogador 2"));
        GameStateService.save(gameState);
        System.out.println(gameState);
    }
}