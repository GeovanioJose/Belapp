#language: pt
Funcionalidade: Agendar serviço

  @agendamento-feature
  Cenario: TA_02: Agendar um serviço de beleza informando apenas a data.
    Dado que estou na tela de inicial
    Quando eu busco por um servico
    Quando eu escolho um profissional
    Quando eu informo uma data valida
    E eu aperto em agendar
    Entao devo ver a mensagem, Selecione um horario de agendamento!

  @agendamento-feature
  Cenario: TA_01: Agendar um serviço de beleza informando data e horário.
    Dado que estou na tela de inicial
    Quando eu busco por um servico
    Quando eu escolho um profissional
    Quando eu informo uma data valida
    Quando eu seleciono um horario valido
    E eu aperto em agendar
    Entao devo ver a mensagem, Agendamento realizado com sucesso!

    @agendamento-feature
      Cenario: TA_03: Agendar um serviço de beleza informando data ou horário indisponível.
        Dado que estou na tela de inicial
        Quando eu busco por um servico do estabelecimento
        Quando eu escolho um profissional
        E eu informo uma data invalida
        Entao devo ver a mensagem, O estabelecimento estará fechado na data selecionada

