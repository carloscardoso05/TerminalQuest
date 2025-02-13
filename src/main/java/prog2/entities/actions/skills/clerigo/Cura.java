package prog2.entities.actions.skills.clerigo;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.game.Dice;

import javax.naming.InsufficientResourcesException;
import java.util.MissingResourceException;

public class Cura extends Skill {
    private static final int MAX_CURA = 10;

    public Cura() {
        super("Cura", 5);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        Player alvo = alvos[0];

        origem.setManaAtual(origem.getManaAtual() - this.getCusto());
        int cura = Dice.rollDice(MAX_CURA);
        alvo.setVidaAtual(Math.min(alvo.getVidaAtual() + cura, alvo.getVidaMaxima()));
    }
}
