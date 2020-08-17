# language: pt

Funcionalidade: Buscar Informação
  Como cliente da getnet
  Eu quero tirar dúvidas
  Para que eu possa proceder de forma adequada

  Cenário: Buscar Informação de portabilidade
    Dado que acesso o site da getnet
    Quando faço a pesquisa de "Como faço a portabilidade da minha maquininha"
    Então devo visualizar a mensagem "Como faço a portabilidade da minha maquininha"