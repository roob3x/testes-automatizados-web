#language: pt
Funcionalidade: Consultar Categoria

  @consulta_categorias @teste
  Esquema do Cenario: Valido que ao selecionar categoria <categoria> sera carregada a pagina com categoria <categoria>
    Dado que acesso a categoria <categoria>
    Entao valido que sou direcionado para a pagina de categoria <categoria>

    Exemplos:
      | categoria                     |
      | "Institucional"               |
      | "Produtos"                    |
      | "Serviços"                    |
      | "Sua segurança"               |
      | "Sua carreira"                |
      | "Inscreva-se no nosso canal!" |
      | "Seus investimentos"          |