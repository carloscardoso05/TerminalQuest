package prog2.entities.actions.skills.clerigo;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

import java.util.List;

public class Cura extends Skill {
    private static final int MAX_CURA = 10;
    private static final int CUSTO = 5;

    public Cura() {
        super("Cura", CUSTO);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        Player alvo = alvos.get(0);

        int cura = Dice.rollDice(MAX_CURA);
        alvo.setVidaAtual(Math.min(alvo.getVidaAtual() + cura, alvo.getVidaMaxima()));
        return ResultadoAtaque.ACERTOU;
    }
}
