package prog2.game.action;

import prog2.entities.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public class DefaultAttack extends Action{

    private static final int MAX_DANO = 6;

    public DefaultAttack(Player origem, Player alvo) {
        super(origem, alvo);
    }

    @Override
    public void execute() {
        Player origem = this.getOrigem();
        Player alvo = this.getAlvo();

        ResultadoAtaque resultado;
        int ataque = Dice.rollDice(20);
        int bonus = origem.getDestreza();
        if (ataque + bonus >= alvo.getDefesa()) {
            if (ataque == 20)
                resultado = ResultadoAtaque.CRITICAL_HIT;
            else
                resultado = ResultadoAtaque.ACERTOU;
        } else {
            resultado = ResultadoAtaque.ERROU;
        }
        int dano = Dice.rollDano(MAX_DANO + (origem.getNivel() - 1) * 2, origem.getForcaDeAtaque(), resultado);
        alvo.setVidaAtual(alvo.getVidaAtual() - dano);
    }
}
