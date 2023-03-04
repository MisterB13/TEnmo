package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ").toLowerCase().trim();
        String password = promptForString("Password: ").toLowerCase().trim();
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public int checkUserId(String prompt, List<User> users, int currentUserId) {
        while (true) {

            System.out.print(prompt);
            if(!scanner.hasNextInt()) {
                System.out.println("Input must be a number.");
                scanner.nextLine();
                continue;
            }

            int userId = Integer.parseInt(scanner.nextLine());
            if(userId == 0) return 0;

            if(userId == currentUserId) {
                System.out.println("You can not select your ID.");
                continue;
            }

            User user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
            if(user == null) {
                System.out.println("Invalid ID.");
                continue;
            }
            return userId;
        }
    }

    public BigDecimal checkAmount(String prompt, BigDecimal balance) {
        while (true) {

            System.out.print(prompt);
            if(!scanner.hasNextBigDecimal()) {
                System.out.println("Input must be a number.");
                scanner.nextLine();
                continue;
            }

            BigDecimal amount = new BigDecimal(scanner.nextLine());

            if(amount.compareTo(balance) > 0 || amount.equals(BigDecimal.ZERO)) {
                System.out.println("Invalid amount.");
                continue;
            }
            return amount;
        }
    }
}
