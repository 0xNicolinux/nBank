# nBank

Um sistema bancário simples desenvolvido em **Java** para praticar conceitos básicos da linguagem.

## 📋 Funcionalidades

* Consultar saldo
* Realizar depósitos
* Realizar saques
* Encerrar o programa

## 📁 Estrutura

```text
nBank/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── nbank/
│                   └── App.java
├── .gitignore
└── README.md
```

## ▶️ Como executar

### Pré-requisito

É necessário ter o **Java JDK** instalado.

Verifique a instalação com:

```bash
java --version
javac --version
```

### Compilar

Na raiz do projeto:

```bash
mkdir -p out
javac -d out src/main/java/com/nbank/App.java
```

### Executar

```bash
java -cp out com.nbank.App
```

## 💻 Exemplo

```text
###################
Bem-vindo ao nBank!
###################
1 - Consultar saldo
2 - Realizar depósito
3 - Realizar saque
4 - Sair
###################
Selecione uma opção (1-4):
```

## 📚 Objetivo

Este projeto foi criado como uma forma simples de praticar **Java**, especialmente:

* Variáveis
* Condicionais
* Loops
* Métodos
* `Scanner`
* `switch`
* Operações com valores

## 🙏 Créditos

Inspirado pelo conteúdo de **Bro Code**.

[Bro Code no YouTube](https://www.youtube.com/@BroCodez)
