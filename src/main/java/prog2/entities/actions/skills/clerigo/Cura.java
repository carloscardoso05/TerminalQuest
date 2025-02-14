package prog2.entities.actions.skills.clerigo;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.game.Dice;
import prog2.entities.actions.Action;

public class Cura extends Skill {
    private static final int MAX_CURA = 10;
    private static final int CUSTO = 5;

    public Cura() {
        super("Cura", CUSTO);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        Player alvo = alvos[0];

        // TODO: CRIAR ATRIBUTO MANA NA CLASSE PLAYER
        // TODO: POSSIVELMENTE ADICIONAR ATRIBUTO DE MAGIA PARA BÔNUS
        int cura = Dice.rollDice(MAX_CURA);
        alvo.setVidaAtual(Math.min(alvo.getVidaAtual() + cura, alvo.getVidaMaxima()));
    }
}
