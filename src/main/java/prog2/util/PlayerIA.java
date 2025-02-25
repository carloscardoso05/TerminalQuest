package prog2.util;

import prog2.entities.actions.Action;
import prog2.entities.actions.skills.arqueiro.AtaqueMultiplo;
import prog2.entities.actions.skills.bardo.Inspiracao;
import prog2.entities.actions.skills.clerigo.Cura;
import prog2.entities.actions.skills.tanque.ChamarAtencao;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.players.Player;
import prog2.entities.players.heroes.Hero;
import prog2.entities.players.monsters.Monster;
import prog2.game.SemAlvoDisponivelException;
import prog2.game.log.Log;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PlayerIA {
    private final Player player;

    public PlayerIA(Player player) {
        this.player = player;
    }

    private boolean ehOposto(Player outro) {
        if (player instanceof Hero) {
            return outro instanceof Monster;
        } else {
            return outro instanceof Hero;
        }
    }

    private boolean ehAliado(Player outro) {
        return !ehOposto(outro);
    }


    protected List<Player> filtrarAlvos(List<Player> alvos, Action acao) {
        if (acao instanceof AtaqueMultiplo) {
            return alvos.stream()
                    .filter((p) -> ehOposto(p) && !p.estaMorto())
                    .sorted(Comparator.comparingInt(Player::getVidaAtual))
                    .limit(3)
                    .toList();
        } else if (acao instanceof ChamarAtencao) {
            return List.of();
        } else if (List.of(Inspiracao.class, Cura.class).contains(acao.getClass())) {
            return alvos.stream().filter((p) -> ehAliado(p) && !p.estaMorto()).findFirst().stream().toList();
        } else {
            return alvos.stream().filter((p) -> ehOposto(p) && !p.estaMorto()).findFirst().stream().toList();
        }
    }

    protected void usarAtaque(List<Player> players) {
        final Player alvo = filtrarAlvos(players, player.getAtaque()).stream()
                .findFirst()
                .orElseThrow(SemAlvoDisponivelException::new);
        final ResultadoAtaque resultado = player.realizarAtaque(alvo);
        Log.getInstance().action(player, alvo, player.getAtaque(), resultado);
    }

    protected void usarHabilidade(List<Player> players) {
        final List<Player> alvos = filtrarAlvos(players, player.getHabilidade());
        final ResultadoAtaque resultado = player.getHabilidade().execute(player, alvos);
        Log.getInstance().action(player, alvos, player.getHabilidade(), resultado);
    }

    public void realizarAcao(List<Player> players) {
        while (true) {
            try {
                if (player.getHabilidade() == null || player.getHabilidade().getCusto() > player.getManaAtual()) {
                    usarAtaque(players);
                    return;
                }
                final int tipoAcao = new Random().nextInt(3);
                switch (tipoAcao) {
                    case 0, 1 -> usarAtaque(players);
                    case 2 -> usarHabilidade(players);
                    default ->
                            throw new IllegalStateException("Unexpected value: " + tipoAcao);
                }
                return;
            } catch (SemAlvoDisponivelException e){
                Log.getInstance().game("Sem alvo disponível para " + player);
                return;
            }
            catch (Exception ignored) {
            }
        }
    }
}
