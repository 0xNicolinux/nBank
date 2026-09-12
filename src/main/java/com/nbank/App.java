package com.nbank;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double accountBalance = 0.0;
        boolean isRunning = true;
        int menuOption;

        while (isRunning) {
            displayMenu();

            System.out.print("Selecione uma opção (1-4): ");
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1 -> displayBalance(accountBalance);
                case 2 -> accountBalance = deposit(scanner, accountBalance);
                case 3 -> accountBalance = withdraw(scanner, accountBalance);
                case 4 -> isRunning = false;

                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("#".repeat(19));
        System.out.println("Bem-vindo ao nBank!");
        System.out.println("#".repeat(19));

        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Realizar depósito");
        System.out.println("3 - Realizar saque");
        System.out.println("4 - Sair");

        System.out.println("#".repeat(19));
    }

    public static void displayBalance(double accountBalance) {
        System.out.printf("Saldo atual: R$ %.2f%n", accountBalance);
    }

    public static double deposit(Scanner scanner, double accountBalance) {
        System.out.print("Informe o valor do depósito: R$ ");
        double depositAmount = scanner.nextDouble();

        if (depositAmount <= 0) {
            System.out.println("Valor de depósito inválido.");
            return accountBalance;
        }

        System.out.println("Depósito realizado: R$ " + depositAmount);
        accountBalance = accountBalance + depositAmount;

        return accountBalance;
    }

    public static double withdraw(Scanner scanner, double accountBalance) {
        System.out.print("Informe o valor do saque: R$ ");
        double withdrawalAmount = scanner.nextDouble();

        if (withdrawalAmount <= 0 || withdrawalAmount > accountBalance) {
            System.out.println("Valor de saque inválido.");
            return accountBalance;
        }

        System.out.println("Saque realizado: R$ " + withdrawalAmount);
        accountBalance = accountBalance - withdrawalAmount;

        return accountBalance;
    }

}

// Thanks to Bro Code for the inspiration and guidance!
// https://www.youtube.com/@BroCodez