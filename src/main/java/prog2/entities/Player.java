package prog2.entities;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Status;
import prog2.util.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected String nome;
    protected final int vidaMaxima;
    protected int vidaAtual;
    protected final int manaMaxima;
    protected int manaAtual;
    protected int forcaDeAtaque;
    protected int inteligencia;
    protected int defesa;
    protected int velocidade;
    protected int destreza;
    protected int nivel;
    protected int ameaca;
    protected Attack ataque;
    protected final List<Skill> habilidades = new ArrayList<>();
    protected final List<Status> status = new ArrayList<>();

    public Player(String nome, int vidaMaxima, int vidaAtual, int manaMaxima, int manaAtual, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaAtual;
        this.forcaDeAtaque = forcaDeAtaque;
        this.inteligencia = inteligencia;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.nivel = nivel;
        this.ameaca = ameaca;
        this.ataque = new DefaultAttack();
    }

    public Player(String nome, int vidaMaxima, int vidaAtual, int manaMaxima, int manaAtual, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca, Attack ataque) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaAtual;
        this.forcaDeAtaque = forcaDeAtaque;
        this.inteligencia = inteligencia;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.nivel = nivel;
        this.ameaca = ameaca;
        this.ataque = ataque;
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

    @Override
    public String toString() {
        return ToString.fromGetters(this);
    }
}
