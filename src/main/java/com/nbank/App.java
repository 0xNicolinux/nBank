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
        System.out.println();
        System.out.println("===================================================");
        System.out.println("                    nBank");
        System.out.println("                BANCO DIGITAL");
        System.out.println("===================================================");

        System.out.println();
        System.out.println("  1 - Consultar saldo");
        System.out.println("  2 - Realizar depósito");
        System.out.println("  3 - Realizar saque");
        System.out.println("  4 - Sair");

        System.out.println();
        System.out.println("---------------------------------------------------");
    }

    public static void displayBalance(double accountBalance) {
        System.out.println();
        System.out.println("===================================================");
        System.out.println("                  SALDO");
        System.out.println("===================================================");
        System.out.printf("  Saldo atual: R$ %.2f%n", accountBalance);
        System.out.println("===================================================");
        System.out.println();
    }

    public static double deposit(Scanner scanner, double accountBalance) {
        System.out.println();
        System.out.println("===================================================");
        System.out.println("                 DEPOSITO");
        System.out.println("===================================================");

        System.out.print("Informe o valor do deposito: R$ ");
        double depositAmount = scanner.nextDouble();

        if (depositAmount <= 0) {
            System.out.println("Valor de deposito invalido.");
            return accountBalance;
        }

        System.out.println("Deposito realizado: R$ " + depositAmount);
        accountBalance = accountBalance + depositAmount;

        return accountBalance;
    }

    public static double withdraw(Scanner scanner, double accountBalance) {
        System.out.println();
        System.out.println("===================================================");
        System.out.println("                   SAQUE");
        System.out.println("===================================================");

        System.out.print("Informe o valor do saque: R$ ");
        double withdrawalAmount = scanner.nextDouble();

        int[] notes = { 200, 100, 50, 20, 10, 5, 2 };
        int[] noteQuantities = new int[notes.length];

        if (withdrawalAmount <= 0 || withdrawalAmount > accountBalance) {
            System.out.println("Valor de saque invalido.");
            return accountBalance;
        }

        boolean withdrawalPossible = withdrawBacktracking(withdrawalAmount, 0, notes, noteQuantities);

        if (!withdrawalPossible) {
            System.out.println("Valor de saque invalido.");
            return accountBalance;
        }

        accountBalance -= withdrawalAmount;

        System.out.println();
        System.out.println("Cedulas entregues:");
        printNotes(notes, noteQuantities);

        System.out.println();
        System.out.printf("Saque realizado: R$ %.2f%n", withdrawalAmount);
        System.out.println("===================================================");
        System.out.println();

        return accountBalance;
    }

    public static boolean withdrawBacktracking(double remainingAmount, int i, int[] notes, int[] noteQuantities) {
        if (remainingAmount == 0) {
            return true;
        }

        if (i == notes.length) {
            return false;
        }

        if (notes[i] <= remainingAmount) {
            noteQuantities[i]++;

            boolean withdrawalPossible = withdrawBacktracking(remainingAmount - notes[i], i, notes, noteQuantities);

            if (withdrawalPossible) {
                return true;
            }

            noteQuantities[i]--;
        }

        return withdrawBacktracking(remainingAmount, i + 1, notes, noteQuantities);
    }

    public static void printNotes(int[] notes, int[] noteQuantities) {
        for (int i = 0; i < notes.length; i++) {
            if (noteQuantities[i] > 0) {
                System.out.printf("%dx R$ %d%n", noteQuantities[i], notes[i]);
            }
        }
    }
}