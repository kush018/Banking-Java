import java.io.*;

public class Console {

    Account[] accounts = new Account[] { };

    public String getInput() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        String userInput = inputReader.readLine();
        return userInput;
    }

    public void executeCommand(String command) {
        String commandArray[] = command.split(" ");
        if (commandArray[0].equals("new")) {
            newAccount();
        }
        else if (commandArray[0].equals("accounts")) {
            showAccounts();
        }
    }

    public void newAccount() {
        
    }

    public void showAccounts() {
        System.out.println("All available accounts are listed below:");
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];
            System.out.println("[" + i + "]" + " First Name: " + account.getFirstName() + " Last Name: " + account.getLastName() + " Age: " + account.getAge() + " Balance: " + account.getBalance());
        }
    }
}