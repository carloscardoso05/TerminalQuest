package prog2.entities.status;

import prog2.entities.Player;

public class Ameacador extends Status {
    public Ameacador() {
        super("Ameaçador", 2);
    }

    @Override
    public void aplicarEfeito(Player player) {
        player.setAmeaca(player.getAmeaca() + 2);
    }

    @Override
    public void reverterEfeito(Player player) {
        player.setAmeaca(player.getAmeaca() - 2);
    }
}
