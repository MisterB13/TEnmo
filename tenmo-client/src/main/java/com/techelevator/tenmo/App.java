package com.techelevator.tenmo;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;
<<<<<<< HEAD
import com.techelevator.tenmo.services.*;
=======
<<<<<<< HEAD
import com.techelevator.tenmo.services.*;
=======
import com.techelevator.tenmo.services.AccountService;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;
import com.techelevator.tenmo.services.UserService;
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b

import java.math.BigDecimal;
import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private final AccountService accountService = new AccountService();

    private final UserService userService = new UserService();

<<<<<<< HEAD
    private final TransferService transferService = new TransferService();

=======
<<<<<<< HEAD
    private final TransferService transferService = new TransferService();

=======
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }

    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
    private void viewCurrentBalance() {
        int id = currentUser.getUser().getId();
        Account account = accountService.getUserAccount(id);
        if (account != null)
            System.out.println("Your current account balance is: $" + account.getBalance());
    }
<<<<<<< HEAD
=======
=======
	private void viewCurrentBalance() {
        int id = currentUser.getUser().getId();
        Account account = accountService.getUserAccount(id);
        if(account != null)
            System.out.println("Your current account balance is: $" + account.getBalance());
	}
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b

    private void viewTransferHistory() {
        // TODO Auto-generated method stub

    }

<<<<<<< HEAD
    private void viewPendingRequests() {
        // TODO Auto-generated method stub

=======
<<<<<<< HEAD
    private void viewPendingRequests() {
        // TODO Auto-generated method stub
=======
	private void sendBucks() {
        List<User> users = userService.getAllUsers();

        if(users != null) {

            System.out.println("-------------------------------------------");
            System.out.println("Users");
            System.out.println("ID          Name");
            System.out.println("-------------------------------------------");

            for (User user :
                    users) {
                System.out.println(user.getId() + "        " + user.getUsername());
            }
            System.out.println("---------" + System.lineSeparator());

            int Id = consoleService.promptForInt("Enter ID of user you are sending to (0 to cancel): ");
            BigDecimal amount = consoleService.promptForBigDecimal("Enter amount: ");

            System.out.println("Id: " + Id + " Amount: " + amount);
        }

		
	}
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b

>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
    }

    private void sendBucks() {
        List<User> users = userService.getAllUsers();

        if (users != null) {

            System.out.println("-------------------------------------------");
            System.out.println("Users");
            System.out.println("ID          Name");
            System.out.println("-------------------------------------------");

            for (User user :
                    users) {
                System.out.println(user.getId() + "        " + user.getUsername());
            }
            System.out.println("---------" + System.lineSeparator());

            int transferUserId = consoleService.checkUserId("Enter ID of user you are sending to (0 to cancel): ", users, currentUser.getUser().getId());

            if (transferUserId != 0) {
                BigDecimal balance = accountService.getUserAccount(currentUser.getUser().getId()).getBalance();

                BigDecimal amount = consoleService.checkAmount("Enter amount: ", balance);

<<<<<<< HEAD
                BigDecimal userBalance = accountService.getUserAccount(transferUserId).getBalance();

                BigDecimal transactionBalance = amount.add(userBalance);

                BigDecimal yourBalanceAfterTransaction = userBalance.subtract(amount);



                System.out.println("Id: " + transferUserId + " Amount: " + amount +  " Your Balance:  " +  yourBalanceAfterTransaction + " Users Amount: " + transactionBalance);
=======
                System.out.println("Id: " + transferUserId + " Amount: " + amount);
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
            }
        }
    }

    private void requestBucks() {
        // TODO Auto-generated method stub

    }

}
