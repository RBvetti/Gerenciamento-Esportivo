classDiagram
    class RegraDePontuacao {
        <<interface>>
        +calcularPontos(partida: Partida)
    }

    class Campeonato {
        -String nome
        -int temporada
        +adicionarTime(Time)
        +gerarRodadas()
    }

    class Time {
        -String nome
        -int pontos
        +adicionarPontos(int)
        +obterEstatisticas()
    }

    class Partida {
        -Date dataJogo
        -int placarMandante
        -int placarVisitante
        -StatusPartida status
        +atualizarPlacar(int, int)
        +finalizarPartida()
    }

    class Jogador {
        -String nome
        -String posicao
        -int numeroCamisa
    }

    Campeonato "1" o-- "*" Time : possui >
    Time "1" o-- "*" Jogador : contrata >
    Partida "*" --> "1" Time : mandante
    Partida "*" --> "1" Time : visitante
    RegraDePontuacao <|.. Campeonato : utiliza
