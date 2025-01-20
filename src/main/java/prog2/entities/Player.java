package prog2.entities;

import prog2.entities.enums.ResultadoAtaque;
import prog2.util.PlayerFactory;

import java.io.Serial;
import java.io.Serializable;

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int forcaDeAtaque;
    protected int defesa;
    protected int velocidade;
    protected int destreza;
    protected int nivel;

    public Player(String nome, int vidaMaxima, int vidaAtual, int forcaDeAtaque, int defesa, int velocidade, int destreza, int nivel) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.forcaDeAtaque = forcaDeAtaque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.nivel = nivel;
    }

    public static Player criarAleatorio(String nome) {
        return PlayerFactory.criarPlayerAleatorio(nome);
    }

    // TODO implementar ataque do player
    public ResultadoAtaque realizarAtaque(Player alvo) {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getForcaDeAtaque() {
        return forcaDeAtaque;
    }

    public void setForcaDeAtaque(int forcaDeAtaque) {
        this.forcaDeAtaque = forcaDeAtaque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
