#language: pt
Funcionalidade: Consultar Agibank nas plataformas

  @plataforma_agibank @smoke
  Esquema do Cenario: Valido que é possivel acessar a agibank na plataforma <plataforma>
    Dado que acesso a plataforma <plataforma>
    Entao valido que sou direcionado para a pagina da plataforma <plataforma>

    Exemplos:
    | plataforma  |
    | "facebook"  |
    | "instagram" |
    | "linkedin"  |