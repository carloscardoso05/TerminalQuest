package prog2.entities.status;

import prog2.entities.Player;
import prog2.util.exceptions.ImpedeAcao;

public class Atordoado extends Status {
    public Atordoado() {
        super("Atordoado", 2);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        throw new ImpedeAcao();
    }

    @Override
    public void reverterEfeito(Player player) {
    }
}
