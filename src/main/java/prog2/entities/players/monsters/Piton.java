package prog2.entities.players.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.monsters.Envenenar;
import prog2.game.Dice;

public class Piton extends Monster {

    public Piton(int nivel) {
        super("Píton",
                10 + (4 * (nivel - 1)) + Dice.rollDice(5),
                14 + (5 * (nivel - 1)) + Dice.rollDice(5),
                0,
                0,
                12 + (nivel / 2),
                2 + (nivel / 2),
                2 + (nivel / 2),
                nivel,
                12);
        super.setAtaque(new Attack("Mordida", 6, super.getDestreza()));
        super.getHabilidades().add(new Envenenar());
    }
}
