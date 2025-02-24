package prog2.game;

import prog2.entities.players.Player;
import prog2.entities.players.heroes.Hero;
import prog2.entities.players.monsters.Monster;
import prog2.entities.status.Status;
import prog2.game.log.Log;
import prog2.util.PlayerFactory;
import prog2.util.exceptions.ImpedeAcao;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Turno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int turnNumber = 1;
    private int difficulty;

    public boolean todosMortos(List<? extends Player> players) {
        for (Player player : players) {
            if (!player.estaMorto())
                return false;
        }
        return true;
    }

    public boolean hasNextTurn() {
        if (todosMortos(getHeroes())) {
            Log.getInstance().game("Derrota. Todos os heróis morreram.");
            return false;
        }
        if (todosMortos(getMonsters())) {
            Log.getInstance().game("Vitória. Todos os monstros morreram.");
            return false;
        }
        return true;
    }

    public void nextTurn() {
        if (turnNumber == 1) {
            addPlayer(List.of(
                    PlayerFactory.criarMonstroAleatorio("Monstro 1"),
                    PlayerFactory.criarMonstroAleatorio("Monstro 2"),
                    PlayerFactory.criarMonstroAleatorio("Monstro 3"),
                    PlayerFactory.criarMonstroAleatorio("Monstro 4")
            ));
            organizaPlayersEmOrdemDeAcao();
        }

        if (!hasNextTurn()) {
            return;
        }

        for (Player player : this.getPlayers()) {
            // Aplica os efeitos de status e verifica possibilidade de ação
            Iterator<Status> statusIter = player.getStatus().iterator();
            boolean acao = true;
            while (statusIter.hasNext()) {
                Status status = statusIter.next();
                if (status.getDuracaoRestante() < 1) {
                    status.removerEfeito(player);
                    continue;
                }
                try {
                    status.diminuirDuracaoRestante();
                    status.aplicarEfeito(player);
                } catch (ImpedeAcao e) {
                    acao = false;
                }
            }
            if (!acao || player.estaMorto()) {
                continue;
            }
            player.ia.realizarAcao(players);
        }
        turnNumber += 1;
    }

    public void organizaPlayersEmOrdemDeAcao() {
        players.sort((p1, p2) -> Integer.compare(
                Dice.rollDice(20, p2.getVelocidade()),
                Dice.rollDice(20, p1.getVelocidade())));
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

    public void addPlayer(List<? extends Player> players) {
        for (final Player player : players) {
            addPlayer(player);
        }
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    @Override
    public String toString() {
        return "Turno %s - %s".formatted(getTurnNumber(), getPlayers());
    }
}
