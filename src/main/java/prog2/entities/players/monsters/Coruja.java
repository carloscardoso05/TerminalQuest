package prog2.entities.players.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.monsters.PenasDeAco;
import prog2.game.Dice;

public class Coruja extends Monster {
    public Coruja(int nivel) {
        super("Coruja",
                14 + (2 * nivel) + Dice.rollDice(5),
                10 + (2 * nivel) + Dice.rollDice(5),
                2 + (nivel / 2),
                2 + (nivel / 2),
                12 + (nivel / 2),
                1 + (nivel / 2),
                0,
                nivel,
                12);
            super.setAtaque(new Attack("Ataque com garras", 6, super.getForcaDeAtaque()));
            super.getHabilidades().add(new PenasDeAco());
    }
}
