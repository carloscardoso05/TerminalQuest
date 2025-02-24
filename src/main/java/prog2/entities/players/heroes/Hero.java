package prog2.entities.players.heroes;

import prog2.entities.actions.skills.Skill;
import prog2.entities.players.Player;

import java.io.Serial;

public class Hero extends Player {
    @Serial
    private static final long serialVersionUID = 1L;

    public Hero(String nome, int vidaMaxima, int manaMaxima, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca, Skill habilidade) {
        super(nome, vidaMaxima, manaMaxima, forcaDeAtaque, inteligencia, defesa, velocidade, destreza, nivel, ameaca, habilidade);
    }
}
