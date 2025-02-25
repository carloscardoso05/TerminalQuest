package prog2.entities.players.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.monsters.Congelar;
import prog2.game.Dice;

public class Pinguim extends Monster {

    public Pinguim(int nivel) {
        super("Pinguim",
                12 + (2 * nivel) + Dice.rollDice(5),
                10 + (2 * nivel) + Dice.rollDice(5),
                1 + (nivel / 2),
                0,
                12 + (nivel / 2),
                1 + (nivel / 2),
                1 + (nivel / 2),
                nivel,
                12,
              new Congelar());
        super.setAtaque(new Attack("Mordida", 6, super.getForcaDeAtaque()));
    }
}
