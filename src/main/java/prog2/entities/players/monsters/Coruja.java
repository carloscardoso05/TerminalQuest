package prog2.entities.players.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.monsters.PenasDeAco;
import prog2.game.Dice;

public class Coruja extends Monster {
    public Coruja(int nivel) {
        super("Coruja",
                14 + (5 * (nivel - 1)) + Dice.rollDice(5),
                10 + (5 * (nivel - 1)) + Dice.rollDice(5),
                2 + (nivel / 2),
                2 + (nivel / 2),
                12 + (nivel / 2),
                1 + (nivel / 2),
                0,
                nivel,
                12,
              new PenasDeAco());
            super.setAtaque(new Attack("Ataque com garras", 6, super.getForcaDeAtaque()));
    }
}
