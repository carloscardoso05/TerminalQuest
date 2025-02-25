package prog2.entities.players.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.game.Dice;

public class Minion extends Monster {
    private static int ratoCount = 0;
    private static int goblinCount = 0;
    private static int xundaCount = 0;

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
              10,
              null);
        super.setAtaque(new Attack("Ataque", 4, super.getForcaDeAtaque()));

        int opc = Dice.rollDice(3);
        switch (opc) {
        case 1:
            ratoCount++;
            super.setNome("Rato-" + ratoCount);
            break;
        case 2:
            goblinCount++;
            super.setNome("Goblin-" + goblinCount);
            break;
        case 3:
            xundaCount++;
            super.setNome("Xunda-" + xundaCount);
        }
    }

    public static void resetMinionsCount() {
        ratoCount = 0;
        goblinCount = 0;
        xundaCount = 0;
    }
}
