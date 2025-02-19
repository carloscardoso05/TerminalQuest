package prog2.entities.status;

import prog2.entities.Player;
import prog2.util.exceptions.ImpedeAcao;

public class Escondido extends Status {
    public Escondido() {
        super("Escondido", 1);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        throw new ImpedeAcao();
    }

    @Override
    public void reverterEfeito(Player player) {
        // TODO: Criar alguma forma de chamar o execute do ataque novamente
    }
}
