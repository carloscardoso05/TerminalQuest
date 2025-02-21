package prog2.entities.players.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.game.Dice;

public class Minion extends Monster {
    public Minion(int nivel) {
        super(null,
                5 + (nivel - 1) + Dice.rollDice(3),
                0,
                1 + (nivel / 2),
                0,
                1 + (nivel / 2),
                0,
                1 + (nivel / 2),
                nivel,
                10);
        super.setAtaque(new Attack("Ataque", 4, super.getForcaDeAtaque()));

        int opc = Dice.rollDice(3);
        switch (opc) {
        case 1:
            super.setNome("Rato");
            break;
        case 2:
            super.setNome("Goblin");
            break;
        case 3:
            super.setNome("Xunda");
        }
    }
}
