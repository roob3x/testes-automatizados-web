#language: pt
Funcionalidade: Consultar Assuntos

  @consulta_assuntos @smoke @dados_validos
  Cenario: Valido que é possivel realizar a busca de um assunto existente de pesquisa
    Dado realizo a busca do assunto "Agibank lança programa interno de diversidade e inclusão"
    Entao valido o titulo da pesquisa bem como sua descricao


  @consulta_assuntos @smoke @titulo_inexistente
  Cenario: Valido retorno do resultado ao inserir assunto inexistente no blog
    Dado realizo a busca do assunto "Automacao"
    Entao valido que é retornado nenhum resultado