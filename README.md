# nBank

Um banco digital simples feito em **Java** para praticar programação.

## Funcionalidades

* Consultar saldo
* Depositar
* Sacar
* Sair

O saque usa **backtracking** para encontrar uma combinação de cédulas.

## Como executar

Tenha o **Java JDK** instalado.

```bash
mkdir -p out
javac -d out src/main/java/com/nbank/App.java
java -cp out com.nbank.App
```
