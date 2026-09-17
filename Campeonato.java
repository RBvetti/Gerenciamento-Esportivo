import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Campeonato {
    private static final int MAXIMO_DE_TIMES = 20;

    private final String nome;
    private final int temporada;
    private final List<Time> times;

    public Campeonato(String nome, int temporada) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do campeonato é obrigatório.");
        }
        this.nome = nome;
        this.temporada = temporada;
        this.times = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        Objects.requireNonNull(time, "O time não pode ser nulo.");
        if (times.size() >= MAXIMO_DE_TIMES) {
            throw new IllegalStateException(
                "O campeonato já atingiu o limite máximo de " + MAXIMO_DE_TIMES + " times.");
        }
        if (times.contains(time)) {
            throw new IllegalArgumentException("Este time já está inscrito no campeonato.");
        }
        times.add(time);
    }

    public boolean removerTime(Time time) {
        return times.remove(time);
    }

    public int getQuantidadeDeTimes() {
        return times.size();
    }

    public int getVagasRestantes() {
        return MAXIMO_DE_TIMES - times.size();
    }

    public boolean estaCompleto() {
        return times.size() >= MAXIMO_DE_TIMES;
    }

    // Retorna uma lista somente-leitura: quem quiser adicionar/remover time
    // precisa passar pelos métodos acima, que validam as regras do campeonato.
    public List<Time> getTimes() {
        return Collections.unmodifiableList(times);
    }

    // Classificação simples: por pontos, desempatando por saldo de gols.
    public List<Time> gerarClassificacao() {
        List<Time> classificacao = new ArrayList<>(times);
        classificacao.sort(
            Comparator.comparingInt(Time::getPontos)
                .thenComparingInt(Time::getSaldoDeGols)
                .reversed()
        );
        return classificacao;
    }

    public String getNome() { return nome; }
    public int getTemporada() { return temporada; }
    public static int getMaximoDeTimes() { return MAXIMO_DE_TIMES; }
}
