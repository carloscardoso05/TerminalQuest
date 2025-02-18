package prog2.game;

import prog2.entities.Hero;
import prog2.entities.Monster;
import prog2.entities.Player;
import prog2.entities.status.Status;
import prog2.util.ToString;
import prog2.util.exceptions.ImpedeAcao;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Turno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int turnNumber;

    public void nextTurn() {
        if (turnNumber == 1) {
            getPlayerEmOrdemDeAcao();
        }
        for (Player p : this.getPlayers()) {
            // Aplica os efeitos de status e verifica possibilidade de ação
            List<Status> status = p.getStatus();
            boolean acao = true;
            for (Status s : status) {
                if (s.getDuracaoRestante() < 1) {
                    s.removerEfeito(p);
                    // Talvez quebre remover no meio da iteração
                    status.remove(s);
                    continue;
                }
                try {
                    s.diminuirDuracaoRestante();
                    s.aplicarEfeito(p);
                } catch (ImpedeAcao e) {
                    acao = false;
                }
            }
            if (!acao) {
                continue;
            }

            if (p instanceof Hero) {
                // Get ação e alvo
                int tipoAcao = 0;
                List<Player> alvos = null;
                switch (tipoAcao) {
                    case 0:
                        p.getAtaque().execute(p, alvos);
                        break;
                    case 1:
                        p.getHabilidades().get(0).execute(p, alvos);
                        break;
                    case 2:
                        // ITEM
                }
            }
            else {
                // IA do monstro
            }
        }
        turnNumber += 1;
    }

    public List<Player> getPlayerEmOrdemDeAcao() {
        final List<Player> players = new ArrayList<>(getPlayers());
        players.sort((p1, p2) -> Integer.compare(
                Dice.rollDice(20, p2.getVelocidade()),
                Dice.rollDice(20, p1.getVelocidade())));
        return players;
    }

    private final List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public List<Monster> getMonsters() {
        return getPlayers().stream()
                .filter(p -> p instanceof Monster)
                .map(p -> (Monster) p)
                .collect(Collectors.toList());
    }

    public List<Hero> getHeroes() {
        return getPlayers().stream()
                .filter(p -> p instanceof Hero)
                .map(p -> (Hero) p)
                .collect(Collectors.toList());
    }

    public int getPlayersCount() {
        return getPlayers().size();
    }

    public int getMonstersCount() {
        return getMonsters().size();
    }

    public int getHeroesCount() {
        return getHeroes().size();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addPlayer(List<Player> players) {
        for (final Player player : players) {
            addPlayer(player);
        }
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    @Override
    public String toString() {
        return ToString.fromGetters(this);
    }
}