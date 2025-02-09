package prog2.entities.status;

public abstract class Status {
    private final String nome;
    private int duracaoRestante;

    protected Status(String nome) {
        this.nome = nome;
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
}
