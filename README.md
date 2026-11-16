# SaborExpress

Sistema de gerenciamento de pedidos de um restaurante, desenvolvido em Java como atividade acadêmica da disciplina de Programação Orientada a Objetos.

O projeto aplica conceitos de orientação a objetos e os cinco princípios SOLID, buscando uma estrutura organizada, extensível e de fácil manutenção.

## Funcionalidades

- Cadastro e representação de clientes.
- Diferentes tipos de pratos com regras próprias de cálculo de preço.
- Criação de pedidos associados a clientes.
- Adição de vários pratos em um mesmo pedido.
- Controle dos pedidos registrados.
- Cálculo do valor total dos pedidos.
- Geração de relatório de fechamento.
- Identificação do pedido de maior valor.
- Exibição de relatórios no console ou gravação em arquivo.
- Validação de preços e tratamento de exceções.

## Tipos de pratos

O sistema possui diferentes implementações da classe abstrata `Prato`:

| Classe | Regra de cálculo |
|---|---|
| `PratoExecutivo` | Mantém o preço base. |
| `Combo` | Aplica desconto de 15% sobre o preço base. |
| `PratoEspecial` | Soma o custo do ingrediente premium ao preço base. |
| `PratoDiet` | Utiliza o preço base. |

## Estrutura do projeto

```text
Trabalho-POO/
│
├── excecao/
│   └── PrecoInvalidoException.java
│
├── modelo/
│   ├── Cliente.java
│   ├── Combo.java
│   ├── Pedido.java
│   ├── Prato.java
│   ├── PratoDiet.java
│   ├── PratoEspecial.java
│   └── PratoExecutivo.java
│
├── principal/
│   └── Principal.java
│
├── relatorio/
│   ├── ArquivoRelatorio.java
│   ├── ConsoleRelatorio.java
│   └── DestinoRelatorio.java
│
└── servico/
    ├── ControlePedidos.java
    └── FechamentoDia.java
```

## Organização dos pacotes

- **excecao:** contém as exceções personalizadas do sistema.
- **modelo:** contém as classes que representam clientes, pedidos e pratos.
- **principal:** contém a classe principal responsável pela execução e demonstração do sistema.
- **relatorio:** contém a abstração e as implementações dos destinos dos relatórios.
- **servico:** contém as classes responsáveis pelo controle dos pedidos e pelo fechamento.

## Aplicação dos princípios SOLID

### 1. SRP — Single Responsibility Principle

Cada classe possui uma responsabilidade específica.

- `Pedido` representa um pedido e calcula seu valor.
- `ControlePedidos` administra os pedidos registrados.
- `FechamentoDia` gera o relatório de fechamento.
- `ConsoleRelatorio` exibe relatórios no console.
- `ArquivoRelatorio` grava relatórios em arquivos.

Dessa forma, as responsabilidades ficam separadas, facilitando a manutenção.

### 2. OCP — Open/Closed Principle

O sistema permite adicionar novos tipos de pratos sem precisar modificar as classes de pratos já existentes.

A classe abstrata `Prato` define o método `calcularPreco()`, que é implementado individualmente por cada tipo de prato.

Como demonstração prática, foi criada a classe `PratoDiet`, que estende `Prato` e implementa sua própria regra de cálculo.

Para adicionar esse novo tipo, foi necessário criar uma nova classe e integrá-la à demonstração em `Principal.java`, sem alterar as implementações anteriores de `PratoExecutivo`, `Combo` e `PratoEspecial`.

Isso demonstra que o sistema pode ser estendido sem modificar sua lógica existente de pedidos e cálculo de valores.

### 3. LSP — Liskov Substitution Principle

As subclasses de `Prato` podem ser utilizadas no lugar da classe abstrata sem comprometer o funcionamento do sistema.

Isso pode ser observado no método `testarSubstituicao(Prato prato)`, presente em `Principal.java`.

O método recebe qualquer objeto que herde de `Prato` e utiliza seu método `calcularPreco()`, independentemente do tipo específico de prato.

### 4. ISP — Interface Segregation Principle

A interface `DestinoRelatorio` possui apenas o método necessário para enviar o conteúdo de um relatório.

As classes `ConsoleRelatorio` e `ArquivoRelatorio` implementam essa interface, sem depender de métodos desnecessários.

### 5. DIP — Dependency Inversion Principle

O sistema utiliza a abstração `DestinoRelatorio` para representar os destinos de saída dos relatórios.

A classe principal trabalha com referências do tipo interface, permitindo utilizar diferentes implementações sem depender diretamente de uma única forma de saída.

Assim, novos destinos podem ser criados implementando `DestinoRelatorio`.

## Tecnologias e conceitos utilizados

- Java
- Programação Orientada a Objetos
- Classes abstratas e herança
- Polimorfismo
- Interfaces
- Encapsulamento
- Tratamento de exceções
- `BigDecimal` para operações monetárias
- `LocalDateTime` para registro de datas
- Java NIO para gravação de arquivos

## Como executar

É necessário ter o JDK instalado.

Abra o terminal na pasta raiz do projeto.

### Compilar

No Windows PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java).FullName
```

### Executar

```powershell
java -cp out principal.Principal
```

## Relatórios

O sistema disponibiliza duas implementações de destino:

- `ConsoleRelatorio`: exibe o relatório no terminal.
- `ArquivoRelatorio`: salva o relatório em `relatorios/fechamento.txt`.

A utilização da interface `DestinoRelatorio` permite adicionar novas formas de saída sem modificar a lógica responsável pela geração do relatório.

## Objetivo acadêmico

O projeto tem como objetivo demonstrar a aplicação dos conceitos de Programação Orientada a Objetos e dos cinco princípios SOLID em um sistema de gerenciamento de pedidos.

Além de implementar as funcionalidades propostas, busca apresentar uma estrutura que facilite a manutenção, a reutilização e a expansão do código.
