package com.techelevator.tenmo;

import com.techelevator.tenmo.model.*;
import com.techelevator.tenmo.model.dto.TransferDto;
import com.techelevator.tenmo.services.*;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.System.out;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private final AccountService accountService = new AccountService();

    private final UserService userService = new UserService();

    private final TransferService transferService = new TransferService();

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
        if(currentUser != null)
            HttpEntityService.setToken(currentUser.getToken());
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

	private void viewCurrentBalance() {
        int id = currentUser.getUser().getId();
        Account account = accountService.getUserAccount(id);
        if(account != null)
            System.out.println("Your current account balance is: $" + account.getBalance());
	}

    private void viewTransferHistory() {
        Account myAccount = accountService.getUserAccount(currentUser.getUser().getId());
        List<TransferDto> transfers = transferService.getTransferDtoHistory(myAccount.getId());

        System.out.println("--------------------------------");
        System.out.println("Transfers");
        System.out.println("ID         From/To        Amount");
        System.out.println("--------------------------------");

        for (TransferDto transfer : transfers) {
            int accountFromId = transfer.getAccountFrom().getId();
            int accountToId = transfer.getAccountTo().getId();
            if (accountFromId == myAccount.getId()) {
                String accountFromUsername = transfer.getAccountFrom().getUserName();
                System.out.println(transfer.getId() + "\t\t" + "From: " + accountFromUsername + "         "
                        + transfer.getAmount());
            } else if (accountToId == myAccount.getId()) {
                String accountToUsername = transfer.getAccountTo().getUserName();
                System.out.println(transfer.getId() + "\t\t" +
                        "To: " + accountToUsername + "         " + transfer.getAmount());
            }
        }
            System.out.println("---------");
            System.out.println();

        int requestedTransferId = consoleService.promptForInt("Please enter transfer ID to view details (0 to cancel): ");

        for (TransferDto transfer : transfers) {
            if (transfer.getId() == requestedTransferId) {
                    System.out.println("--------------------------------------------");
                    out.println("Transfer Details: ");
                    out.println("Transfer ID: " + transfer.getId());
                    out.println("From Account: " + transfer.getAccountFrom().getUserName());
                    out.println("To Account: " + transfer.getAccountTo().getUserName());
                    out.println("Type: " + transfer.getTransferType());
                    out.println("Status: " + transfer.getTransferStatus());
                    out.println("Amount: " + transfer.getAmount());
                    out.println("--------------------------------------------");
                }
            }
        }



    private void viewPendingRequests() {
        // TODO Auto-generated method stub
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

                BigDecimal userBalance = accountService.getUserAccount(transferUserId).getBalance();

                BigDecimal transactionBalance = amount.add(userBalance);

                BigDecimal yourBalanceAfterTransaction = userBalance.subtract(amount);

                out.println("Id: " + transferUserId);
                out.println("Amount: " + amount);
                out.println("Your Balance:  " + yourBalanceAfterTransaction);

                int accountFromId = accountService.getUserAccount(currentUser.getUser().getId()).getId();
                int accountToId = accountService.getUserAccount(transferUserId).getId();

                accountService.createTransaction(accountFromId, accountToId, amount);
            }
        }
    }

    private void requestBucks() {
        // TODO Auto-generated method stub

    }

    private void sendBuckss() {
        List<User> users = userService.getAllUsers();

        if (users != null) {
            printUserList(users);
            int transferUserId = consoleService.checkUserId("Enter ID of user you are sending to (0 to cancel): ", users, currentUser.getUser().getId());

            if (transferUserId != 0) {

                BigDecimal balance = accountService.getUserAccount(currentUser.getUser().getId()).getBalance();
                BigDecimal amountToTransfer = consoleService.checkAmount("Enter amount: ", balance);

                Account userAccount = accountService.getUserAccount(currentUser.getUser().getId());
                Account accountToTransfer = accountService.getUserAccount(transferUserId);

                System.out.printf("User Balance: %s  Transfer Balance: %s\n", userAccount.getBalance(), accountToTransfer.getBalance());

                userAccount.setBalance(userAccount.getBalance().subtract(amountToTransfer));
                accountToTransfer.setBalance(accountToTransfer.getBalance().add(amountToTransfer));

                System.out.printf("New User Balance: %s  New Transfer Balance: %s\n", userAccount.getBalance(), accountToTransfer.getBalance());

                Account updatedUserAccount = accountService.updateAccountBalance(userAccount);
                if(updatedUserAccount == null)
                    System.out.println("Transfer was unsuccessful for user account.");

                Account updatedTransferAccount = accountService.updateAccountBalance(accountToTransfer);
                if(updatedTransferAccount == null)
                    System.out.println("Transfer was unsuccessful for transfer account.");

                System.out.printf("User Balance: %s  Transfer Balance: %s\n", updatedUserAccount.getBalance(), updatedTransferAccount.getBalance());
            }
        }
    }

    private void printUserList(List<User> users) {
            System.out.println("-------------------------------------------");
            System.out.println("Users");
            System.out.println("ID          Name");
            System.out.println("-------------------------------------------");

            for (User user : users)
                System.out.printf("%-11S %s\n", user.getId(), user.getUsername());

            System.out.println("---------" + System.lineSeparator());
    }

    private void viewTransferHistoryy() {
        Account myAccount = accountService.getUserAccount(currentUser.getUser().getId());
        List<TransferDto> transfers = transferService.getTransferDtoHistory(myAccount.getId());

        System.out.println("-------------------------------------------");
        System.out.println("Transfers");
        System.out.println("ID          From/To                 Amount");
        System.out.println("-------------------------------------------");

        for (TransferDto transfer : transfers) {
            System.out.printf("%-11s %s %-17s $%.2f\n", transfer.getId(),
                    transfer.getAccountFrom().getId() == myAccount.getId() ? "To:  " : "From:",
                    transfer.getAccountFrom().getUserId() != currentUser.getUser().getId() ? transfer.getAccountFrom().getUserName() : transfer.getAccountTo().getUserName(),
                    transfer.getAmount());
        }


    }

}
