package prog2.entities.status;

import prog2.entities.Player;

public class Inspirado extends Status{
    public Inspirado() {
        super("Inspirado", 2);
    }

    @Override
    public void aplicarEfeito(Player player) {
        player.setDestreza(player.getDestreza() + 2);
    }

    @Override
    public void removerEfeito(Player player) {
        player.setDestreza(player.getDestreza() - 2);
    }
}
