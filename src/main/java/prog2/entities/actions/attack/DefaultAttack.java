package prog2.entities.actions.attack;

import prog2.entities.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public class DefaultAttack extends Attack {
    public DefaultAttack() {
        super("Ataque", 6);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        Player alvo = alvos[0];

        int ataque = Dice.rollAtaque();
        int bonus = origem.getDestreza();
        ResultadoAtaque resultado = getResultadoAtaque(alvo, ataque, bonus);

        int bonus_nivel = (origem.getNivel() - 1) * 2;
        int dano = Dice.rollDano(danoBase + bonus_nivel, origem.getForcaDeAtaque(), resultado);
        alvo.setVidaAtual(alvo.getVidaAtual() - dano);
    }
}
