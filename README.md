# nBank

Simulador bancário de terminal desenvolvido em **Java**. O projeto apresenta um menu interativo para consultar saldo, realizar depósitos e executar saques, mantendo o saldo durante a execução do programa.

## Funcionalidades

- Consulta do saldo atual.
- Depósito com validação de valor positivo.
- Saque com validação de valor e verificação do saldo disponível.
- Exibição das cédulas utilizadas em um saque.
- Menu de operações em loop até o usuário escolher sair.

## Destaque técnico: backtracking no saque

O saque utiliza uma busca recursiva com **backtracking** para encontrar uma combinação de cédulas que corresponda ao valor solicitado. As denominações consideradas no código são:

~~~java
int[] notes = { 200, 100, 50, 20, 10, 5, 2 };
~~~

A função `withdrawBacktracking()` tenta utilizar cada denominação e retorna quando encontra uma combinação exata. Quando um caminho não funciona, desfaz a escolha e tenta outra possibilidade.

Como consequência do conjunto de cédulas implementado, valores que não possam ser compostos exatamente por essas denominações são recusados.

## Tecnologias

- Java
- JDK com suporte a switch expressions (Java 14 ou superior).
- API padrão: `java.util.Scanner`.

## Executar localmente

Tenha um JDK instalado e disponível no terminal. Na raiz do repositório:

~~~bash
mkdir -p out
javac -d out src/main/java/com/nbank/App.java
java -cp out com.nbank.App
~~~

No Windows, crie a pasta `out` caso necessário e execute os mesmos comandos `javac` e `java` no terminal compatível.

## Estrutura

~~~text
nBank/
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── nbank/
                    └── App.java
~~~

## Escopo atual

O nBank é um exercício de programação em terminal. O saldo é mantido em memória durante a execução; o projeto não representa uma instituição financeira real e não implementa persistência de contas, autenticação ou integração bancária.

## Conceitos praticados

- Estruturas de repetição e seleção.
- Métodos e decomposição de responsabilidades.
- Validação de entradas numéricas.
- Recursão e backtracking.
- Arrays e controle de estado.