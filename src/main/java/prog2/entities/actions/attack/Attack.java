package prog2.entities.actions.attack;

import prog2.entities.actions.Action;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.players.Player;
import prog2.game.Dice;

import java.util.List;

public class Attack extends Action {
    protected final int danoBase;
    private final int bonus;

    public Attack(String name, int danoBase, int bonus) {
        super(name);
        this.danoBase = danoBase;
        this.bonus = bonus;
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        Player alvo = alvos.get(0);

        int ataque = Dice.rollAtaque();
        ResultadoAtaque resultado = getResultadoAtaque(alvo, ataque, this.bonus);

        int bonus_nivel = (origem.getNivel() - 1) * 2;
        int dano = Dice.rollDano(danoBase + bonus_nivel, this.bonus, resultado);
        alvo.setVidaAtual(alvo.getVidaAtual() - dano);
        return resultado;
    }
}
