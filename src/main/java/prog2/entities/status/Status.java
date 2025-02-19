package prog2.entities.status;

import prog2.entities.Player;
import prog2.util.exceptions.ImpedeAcao;

public abstract class Status {
    private final String nome;
    private int duracaoRestante;

    protected Status(String nome, int duracaoRestante) {
        this.nome = nome;
        this.duracaoRestante = duracaoRestante;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoRestante() {
        return duracaoRestante;
    }

    public void diminuirDuracaoRestante() {
        this.duracaoRestante -= 1;
    }

    public abstract void aplicarEfeito(Player player) throws ImpedeAcao;

    public void removerEfeito(Player player) {
        player.getStatus().remove(this);
        reverterEfeito(player);
    }

    protected abstract void reverterEfeito(Player player);
}
