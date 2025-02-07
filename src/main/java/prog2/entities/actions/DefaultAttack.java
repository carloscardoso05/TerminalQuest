package prog2.entities.actions;

import prog2.entities.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public class DefaultAttack extends Action{

    private static final int MAX_DANO = 6;

    public DefaultAttack(Player origem, Player[] alvos) {
        super(origem, alvos);
    }

    @Override
    public void execute() {
        Player origem = this.getOrigem();
        Player alvo = this.getAlvo()[0];


        int ataque = Dice.rollAtaque();
        int bonus = origem.getDestreza();
        ResultadoAtaque resultado = getResultadoAtaque(alvo, ataque, bonus);

        int bonus_nivel = (origem.getNivel() - 1) * 2;
        int dano = Dice.rollDano(MAX_DANO + bonus_nivel, origem.getForcaDeAtaque(), resultado);
        alvo.setVidaAtual(alvo.getVidaAtual() - dano);
    }
}
