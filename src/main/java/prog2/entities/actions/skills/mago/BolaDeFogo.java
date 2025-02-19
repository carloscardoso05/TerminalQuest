package prog2.entities.actions.skills.mago;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

import java.util.List;

public class BolaDeFogo extends Skill {
    private static final int DANO_BASE = 10;

    public BolaDeFogo() {
        super("Bola de fogo", 10);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        Player alvo = alvos.get(0);

        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        int ataque = Dice.rollAtaque();
        ResultadoAtaque resultado = getResultadoAtaque(alvo, ataque, origem.getInteligencia());

        int bonus_nivel = (origem.getNivel() - 1) * 2;
        int dano = Dice.rollDano(DANO_BASE + bonus_nivel, origem.getForcaDeAtaque(), resultado);
        alvo.setVidaAtual(alvo.getVidaAtual() - dano);

        return resultado;
    }
}
