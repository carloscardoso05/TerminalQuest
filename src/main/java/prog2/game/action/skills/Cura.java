package prog2.game.action.skills;

import prog2.entities.Player;
import prog2.game.Dice;
import prog2.game.action.Action;

public class Cura extends Action {
    private static final int MAX_CURA = 10;
    private static final int CUSTO = 5;

    public Cura(Player origem, Player alvo) {
        super(origem, alvo);
    }

    @Override
    public void execute() {
        Player origem = getOrigem();
        Player alvo = getAlvo();

        // TODO: CRIAR ATRIBUTO MANA NA CLASSE PLAYER
        // TODO: POSSIVELMENTE ADICIONAR ATRIBUTO DE MAGIA PARA BÔNUS
        int cura = Dice.rollDice(MAX_CURA);
        alvo.setVidaAtual(Math.min(alvo.getVidaAtual() + cura, alvo.getVidaMaxima()));
    }
}
