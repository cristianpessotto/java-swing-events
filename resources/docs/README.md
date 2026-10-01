# @project.name@ ☕

## Descrição

@project.description@

## Tecnologias usadas

- [Java](https://docs.oracle.com/en/java/javase/25/index.html): Linguagem de programação usando a OpenJDK 25 LTS da Eclipse Temurin.
- [Swing](https://docs.oracle.com/en/java/javase/25/docs/api/java.desktop/javax/swing/package-summary.html): API build-in do Java para criação de interfaces gráficas.
- [FlatLaf](https://github.com/JFormDesigner/FlatLaf): Tema moderno para Java Swing.
- [Maven](https://maven.apache.org/): Gerenciador de projetos Java.
- [Visual Studio Code](https://code.visualstudio.com/): Editor de código-fonte multiplataforma.

## Preview

### Eventos de Mouse

![Eventos de Mouse](/resources/images/mouse_events.png)

### Evento de teclado

![Evento de teclado](/resources/images/key_event.png)

## Como executar

A execução do projeto exige que você tenha a JDK instalada no seu computador. Você pode usar o Maven Wrapper que vem junto com o projeto para executar os comandos abaixo, basta apenas troca o utilitário `mvn` para `mvnw.cmd` ou `mvnw.sh` dependendo do seu sistema operacional.

### Clonagem do repositório

```shell
git clone @url@
cd @artifactId@
```

### Instalação de dependências localmente (opcional)

```shell
mvn dependency:go-offline dependency:resolve-plugins
```

### Compilação e execução do projeto

```shell
mvn compile exec:java
```

### Empacotamento e execução do projeto

```shell
mvn clean package && java -jar @name@.@packaging@
```

## Interfaces de Eventos usados

- [ActionListener](/src/dev/pessotto/view/components/containers/NavContainer.java): Evento genérico como um clique de botão.
- [MouseListener](/src/dev/pessotto/view/components/pages/MouseEventsPage.java): Para eventos de entrada, saída e cliques do mouse.
- [MouseMotionListener](/src/dev/pessotto/view/components/pages/MouseEventsPage.java): Lida com eventos de movimento do mouse.
- [MouseWheelListener](/src/dev/pessotto/view/components/pages/MouseEventsPage.java): Detecta gestos com o scroll do mouse.
- [KeyListener](/src/dev/pessotto/view/components/pages/KeyboardEventsPage.java): Qualquer interação com o teclado.
- [WindowListener](/src/dev/pessotto/view/components/Window.java): Comportamentos gerais da janela (minimizada, em foco etc).

## Documentação (apenas para auxílio)

- Catppuccin: https://catppuccin.com/palette/
- FlatLaf: https://www.formdev.com/flatlaf/customizing/
- Maven Jar Plugin: https://maven.apache.org/plugins/maven-jar-plugin/index.html
- Maven Shade Plugin: https://maven.apache.org/plugins/maven-shade-plugin/index.html

## Licença

[@licenses[0].name@ license](./LICENSE)
