package prog2.entities.players;

import org.fusesource.jansi.Ansi;
import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Status;
import prog2.game.log.Log;
import prog2.util.PlayerIA;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public final PlayerIA ia = new PlayerIA(this);
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
    protected int exp;
    protected int ameaca;
    protected Attack ataque;
    protected final Skill habilidade;
    protected final List<Status> status = new ArrayList<>();

    public Player(String nome, int vidaMaxima, int manaMaxima, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca, Skill habilidade) {
        this(nome, vidaMaxima, manaMaxima, forcaDeAtaque, inteligencia, defesa, velocidade, destreza, nivel, ameaca, new Attack("Ataque", 6, forcaDeAtaque), habilidade);
    }

    public Player(String nome, int vidaMaxima, int manaMaxima, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca, Attack ataque, Skill habilidade) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaMaxima;
        this.forcaDeAtaque = forcaDeAtaque;
        this.inteligencia = inteligencia;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.nivel = nivel;
        this.exp = 0;
        this.ameaca = ameaca;
        this.ataque = ataque;
        this.habilidade = habilidade;
    }

    // TODO implementar ataque do player
    public ResultadoAtaque realizarAtaque(Player alvo) {
        final ResultadoAtaque resultado = ataque.execute(this, List.of(alvo));
        return resultado;
    }

    public boolean estaMorto() {
        return vidaAtual <= 0;
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
        this.vidaAtual = Math.max(vidaAtual, 0);
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAmeaca() {
        return ameaca;
    }

    public void setAmeaca(int ameaca) {
        this.ameaca = ameaca;
    }

    public Attack getAtaque() {
        return ataque;
    }

    public void setAtaque(Attack ataque) {
        this.ataque = ataque;
    }

    public Skill getHabilidade() {
        return habilidade;
    }

    public List<Status> getStatus() {
        return status;
    }

    @Override
    public String toString() {
        if (estaMorto())
            return Ansi.ansi().fgRed().a("%s (MORTO)").reset().toString().formatted(getNome());
        return "%s %d/%d".formatted(getNome(), getVidaAtual(), getVidaMaxima());
    }
}
