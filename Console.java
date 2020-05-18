import java.io.*;

public class Console {

    Account[] accounts = new Account[] { };
    int[] deletedAccounts = new int[] { };

    public String getInput(String prompt) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        String userInput = inputReader.readLine();
        return userInput;
    }

    public String getInput() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        String userInput = inputReader.readLine();
        return userInput;
    }

    public void executeCommand(String command) throws IOException {
        String commandArray[] = command.split(" ");
        if (commandArray[0].equals("new")) {
            newAccount();
        }
        else if (commandArray[0].equals("accounts")) {
            showAccounts();
        }
        else if (commandArray[0].equals("showdetails")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    account.viewAccountDetails();
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("showhistory")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    account.viewTransactionHistory();
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("deposit")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    int depositAmount = Integer.parseInt(getInput("Enter Amount to Deposit: "));
                    if (getInput("Are you sure you want to deposit " + depositAmount + " to account number " + accountNumber + " (y/n): ").equals("y")) {
                        account.depositMoney(depositAmount);
                        System.out.println("Successfully deposited " + depositAmount + " to account number " + accountNumber + ".");
                    }
                    else {
                        System.out.println("Deposit cancelled.");
                    }
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("withdraw")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    int withdrawalAmount = Integer.parseInt(getInput("Enter Amount to Withdraw: "));
                    if (getInput("Are you sure you want to withdraw " + withdrawalAmount + " from account number " + accountNumber + " (y/n): ").equals("y")) {
                        account.withdrawMoney(withdrawalAmount);
                        System.out.println("Successfully withdrew " + withdrawalAmount + " from account number " + accountNumber + ".");
                    }
                    else {
                        System.out.println("Withdrawal cancelled.");
                    }
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getfirstname")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    System.out.println(account.getFirstName());
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getlastname")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    System.out.println(account.getLastName());
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getage")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    System.out.println(account.getAge());
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getgender")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    System.out.println(account.getGender());
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getbalance")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    System.out.println(account.getBalance());
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getdob")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    Date DOB = account.getDateOfBirth();
                    System.out.println("dd/mm/yyyy");
                    System.out.println(DOB.getDate() + "/" + DOB.getMonth() + "/" + DOB.getYear());
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getjoindate")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    Date joinDate = account.getJoinDate();
                    System.out.println("dd/mm/yyyy");
                    System.out.println(joinDate.getDate() + "/" + joinDate.getMonth() + "/" + joinDate.getYear());
                }
                else {
                    System.out.println("Invalid command. Please enter account number.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            catch (NullPointerException e) {
                System.out.println("Invalid account number.");
            }
        }
        else if (commandArray[0].equals("getaccountid")) {
            String fullName = "";
            for (int i = 1; i < commandArray.length; i++) {
                fullName += commandArray[i];
                if (i != commandArray.length - 1) {
                    fullName += " ";
                }
            }
            int accountId = getAccountId(accounts, fullName);
            if (accountId == -1) {
                System.out.println("Account with name " + fullName + " does not exist.");
            }
            else {
                System.out.println("The account id is " + accountId);
            }
        }
        else if (commandArray[0].equals("delete")) {
            try {
                int accountId = Integer.parseInt(commandArray[1]);
                deleteAccount(accountId);
                System.out.println("Account deleted successfully");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid account number");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }
        else {
            System.out.println("Command entered invalid or does not exist. Enter \"help\" for a list of valid commands.");
        }
    }

    public void newAccount() throws IOException {
        String firstName = getInput("First Name: ");
        if (firstName.equals("--cancel--")) {
            System.out.println("Operation cancelled.");
            return;
        }
        String lastName = getInput("Last Name: ");
        if (lastName.equals("--cancel--")) {
            System.out.println("Operation cancelled.");
            return;
        }
        String gender = getInput("Gender: ");
        if (gender.equals("--cancel--")) {
            System.out.println("Operation cancelled.");
            return;
        }
        String dateOfBirthString = getInput("Enter Date of Birth (dd/mm/yyyy): ");
        if (dateOfBirthString.equals("--cancel--")) {
            System.out.println("Operation cancelled.");
            return;
        }
        String[] dateOfBirthArray = dateOfBirthString.split("/");
        Date dateOfBirth;
        try {
            dateOfBirth = new Date(Integer.parseInt(dateOfBirthArray[0]), Integer.parseInt(dateOfBirthArray[1]), Integer.parseInt(dateOfBirthArray[2]));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid date entered. Operation cancelled.");
            return;
        }
        Account account = new Account(firstName, lastName, gender, dateOfBirth);
        if (deletedAccounts.length == 0) {
            accounts = addElementAccount(accounts, account);
        }
        else {
            accounts[deletedAccounts[0]] = account;
            deletedAccounts = deleteElementInt(deletedAccounts, 0);
        }
        System.out.println("Account created successfully.");
        System.out.println("The account id is: " + (accounts.length - 1));
    }

    public void showAccounts() {
        System.out.println("All available accounts are listed below:");
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];
            try {
                System.out.println("[" + i + "]" + " " + account.getFirstName() + " " + account.getLastName() + " Age: " + account.getAge() + " Balance: " + account.getBalance());
            }
            catch (NullPointerException e) { }
        }
    }

    public Account[] addElementAccount(Account[] array, Account element) {
        int arrayLength = array.length;
        Account[] newArray = new Account[arrayLength + 1];
        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = array[i];
        }
        newArray[arrayLength] = element;
        return newArray;
    }

    public int getAccountId(Account[] accountArray, String fullName) {
        int id = -1;
        for (int i = 0; i < accountArray.length; i++) {
            String accountFullName = accountArray[i].getFirstName() + " " + accountArray[i].getLastName();
            if (fullName.equals(accountFullName)) {
                id = i;
            }
        }
        return id;
    }

    public void deleteAccount(int accountId) {
        if (accounts[accountId] != null) {
            accounts[accountId] = null;
            deletedAccounts = addElementInt(deletedAccounts, accountId);
        }
    }

    public int[] addElementInt(int[] array, int element) {
        int arrayLength = array.length;
        int[] newArray = new int[arrayLength + 1];
        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = array[i];
        }
        newArray[arrayLength] = element;
        return newArray;
    }

    public int[] deleteElementInt(int[] array, int elementIndex) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i != elementIndex) {
                newArray = addElementInt(newArray, array[i]);
            }
        }
        return newArray;
    }
}