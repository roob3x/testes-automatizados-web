# testes-automatizados-web
Projeto de automacao de teste java web com junit,selenium, cucumber, padrao page object, gerenciamento de logs, bem como
gerecao de evidencias a cada passo executado

##  DOWNLOADS E INSTALACAO
* Java 8+ JDK deve estar instalado
    * https://www.java.com/pt_BR/download/
* Maven deve estar instalado e configurado no path da aplicação
    * Realize download https://maven.apache.org/download.cgi e descompacte
    * No seu terminal, insira o comando: defaults write com.apple.finder AppleShowAllFiles -bool true

## Configurando variaveis de ambiente
* Caso nao exista o arquivo .profile crie
    * touch ~/.profile
    * nano ~/.profile
    * adicione as variáveis de ambiente: JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home
      export JAVA_HOME
      J6=$JAVA_HOME/bin
      M3_HOME=/Users/robertofilho/downloads/apache-maven-3.9.1
      export M3_HOME
      M3=$M3_HOME/bin
      PATH=$M3:$PATH:$J6
      export PATH
    * Agora carregue o arquivo com comando: source ~/.profile
    * Para salvar clique: Ctlr+X depois Y e por fim ENTER
    * source ~/.profile
    * verifique se o maven foi instalado com comando mvn - version
    * Caso nao seja possivel visualizar o maven, instale via terminal com:
        * brew install maven
    * Ao final volte as configuracoes com:
        * defaults write com.apple.finder AppleShowAllFiles -bool false

## Baixando as dependencias do projeto
* Baixe as dependencias no arquivo pom.xml


## Regras de desenvolvimento
* Afim de obter a melhor experiencia, escalabilidade e melhor manutencao no codigo, siga os passos para que seja implementados novos cenarios de automacao:
    * Crie o arquivo com extensao.feature com o nome da funcionalidade que deseja validar em src/test/resources
    * Crie o arquivo com os steps com o nome da pagina que deseja automatizar em src/test/java/steps
        * Obs: Assegure que seja implementado o step com apenas o que ele deve realmente fazer. nada mais nada menos.
    * Para inserir regras e logicas de metodos, utilize o arquivo src/test/java/pages/BasePage
        * Obs: Assegure que a logica que voce deseja nao esta realmente implementada nessa classe
    * Para mapear os elementos de uma nova pagina, crie um novo arquivo em src/test/java/pages/<nomePaginaPage>
    * Para mapear os elementos siga o mesmo padrao de locators com By(caso precise manipular de outra forma, alinhar com a lideranca)
        * Abaixo crie os metodos das acoes que deseja fazer nessa pagina
    * Para utilizar os metodos da pagina nos steps, instancie a pagina deseja. por ex: HomePage homePage new HomePage(), e assim podera usar a funcao por ex: homePage.searchSubject() no step desejado;
    * Caso seus testes tenham mais de uma URL, centralize no arquivo src/test/java/constants/Url
    * Para manipular diferentes versoes de drivers ou navegadores, adicionar em src/test/java/common/drivers
    * O Arquivo CustomData tem o intuito de centralizar as mensagens fixas ou outros parametros que deseja. caso tenha muitas constantes diferentes, é aconselhavel criar um Arquivo de constante para cada funcionalidade.
    * O arquivo ServiceHooks tem o intuito de executar acoes antes e depois dos cenarios. Tenha cautela caso necessite inserir algo para nao impactar outros cenarios.
    * A cada step executado, sera disparado o metodo takeScreenshot antes e depois do mesmo. e sera armazenada as evidencias em target/evidencia e separado
      por cenarios e respectiva data de execucao
    * Adicione ao gitignore arquivos desnecessarios para que nao polua o projeto


## Como executar o projeto
* execute no terminal na raiz do projeto:
    * mvn test -Dtest=TestRunner cluecumber-report:reporting
* Ou voce pode executar direto no arquivo TestRunner
* Obs 1: O projeto esta apontando para o ambiente local, a automacao vai verificar o host da maquina para selecionar o driver adequada do mac ou linux.
* Para alterar a execucao para utilizar o browserstack, basta alterar ENVIRONMENT no arquivo config para browserstack.
* Obs 2: a tag smoke é comum em todos os cenarios. para executar cenario especifico altere para a tag desejada.
    * No caso de execucao no arquivo TestRunner altear o parametro da tags.
* O projeto esta configurado para execucao na pipeline em ambiente de teste controlado no github actions. voce pode acompanhar execucao,
direto no github na sessao Actions.
* O relatorio com o resultado da execucao estara disponivel no caminho target/formated-report/index.html