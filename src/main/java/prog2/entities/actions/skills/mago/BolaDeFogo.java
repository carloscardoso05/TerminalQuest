package prog2.entities.actions.skills.mago;

import prog2.entities.Player;
import prog2.entities.actions.Action;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public class BolaDeFogo extends Action {

    private static final int MAX_DANO = 10;

    public BolaDeFogo(Player origem, Player[] alvos) {
        super(origem, alvos);
    }

    @Override
    public void execute() {
        Player origem = super.getOrigem();
        Player alvo = super.getAlvo()[0];

        int ataque = Dice.rollAtaque();
        // TODO: ATRIBUTO PARA BÔNUS NOS ATAQUES MÁGICOS
        ResultadoAtaque resultado = super.getResultadoAtaque(alvo, ataque, 0);

        int bonus_nivel = (origem.getNivel() - 1) * 2;
        int dano = Dice.rollDano(MAX_DANO + bonus_nivel, origem.getForcaDeAtaque(), resultado);
        alvo.setVidaAtual(alvo.getVidaAtual() - dano);
    }
}
