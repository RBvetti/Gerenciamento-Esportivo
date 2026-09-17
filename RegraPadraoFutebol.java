public class RegraPadraoFutebol implements RegraDePontuacao {

    @Override
    public void calcularPontos(Partida partida) {
        Time mandante = partida.getTimeMandante();
        Time visitante = partida.getTimeVisitante();
        int golsMandante = partida.getPlacarMandante();
        int golsVisitante = partida.getPlacarVisitante();

        mandante.registrarGols(golsMandante, golsVisitante);
        visitante.registrarGols(golsVisitante, golsMandante);

        if (golsMandante > golsVisitante) {
            mandante.registrarVitoria();
            visitante.registrarDerrota();
        } else if (golsVisitante > golsMandante) {
            visitante.registrarVitoria();
            mandante.registrarDerrota();
        } else {
            mandante.registrarEmpate();
            visitante.registrarEmpate();
        }
    }
}
