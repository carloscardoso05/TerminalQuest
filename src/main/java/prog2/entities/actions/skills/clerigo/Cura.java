package prog2.entities.actions.skills.clerigo;

import java.util.List;

import prog2.entities.players.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public class Cura extends Skill {
    private static final int MAX_CURA = 10;

    public Cura() {
        super("Cura", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        this.checarMana(origem.getManaAtual(), origem.getNome());
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        int cura = Dice.rollDice(MAX_CURA);
        alvo.setVidaAtual(Math.min(alvo.getVidaAtual() + cura, alvo.getVidaMaxima()));
        registrarLog(origem.getNome(), alvos);
        return ResultadoAtaque.ACERTOU;
    }
}
