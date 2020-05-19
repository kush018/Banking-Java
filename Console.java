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
            showDetails(commandArray);
        }
        else if (commandArray[0].equals("showhistory")) {
            showHistory(commandArray);
        }
        else if (commandArray[0].equals("deposit")) {
            deposit(commandArray);
        }
        else if (commandArray[0].equals("withdraw")) {
            withdraw(commandArray);
        }
        else if (commandArray[0].equals("getfirstname")) {
            getFirstName(commandArray);
        }
        else if (commandArray[0].equals("getlastname")) {
            getLastName(commandArray);
        }
        else if (commandArray[0].equals("getage")) {
            getAge(commandArray);
        }
        else if (commandArray[0].equals("getgender")) {
            getGender(commandArray);
        }
        else if (commandArray[0].equals("getbalance")) {
            getBalance(commandArray);
        }
        else if (commandArray[0].equals("getdob")) {
            getDob(commandArray);
        }
        else if (commandArray[0].equals("getjoindate")) {
            getJoinDate(commandArray);
        }
        else if (commandArray[0].equals("getaccountid")) {
            getAccountId(commandArray);
        }
        else if (commandArray[0].equals("delete")) {
            int accountId = Integer.parseInt(commandArray[1]);
            deleteAccount(accountId);
            System.out.println("Account deleted successfully");
        }
        else if (commandArray[0].equals("help")) {
            help();
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

    public void getFirstName(String[] commandArray) {
        if (commandArray.length == 2) {
            int accountNumber = Integer.parseInt(commandArray[1]);
            Account account = accounts[accountNumber];
            System.out.println(account.getFirstName());
        }
        else {
            System.out.println("Invalid command. Please enter account number.");
        }
    }

    public void showDetails(String[] commandArray) {
        if (commandArray.length == 2) {
            int accountNumber = Integer.parseInt(commandArray[1]);
            Account account = accounts[accountNumber];
            account.viewAccountDetails();
        }
        else {
            System.out.println("Invalid command. Please enter account number.");
        }
    }

    public void withdraw(String[] commandArray) throws IOException {
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

    public void getAge(String[] commandArray) {
        if (commandArray.length == 2) {
            int accountNumber = Integer.parseInt(commandArray[1]);
            Account account = accounts[accountNumber];
            System.out.println(account.getAge());
        }
        else {
            System.out.println("Invalid command. Please enter account number.");
        }
    }

    public void getLastName(String[] commandArray) {
        if (commandArray.length == 2) {
            int accountNumber = Integer.parseInt(commandArray[1]);
            Account account = accounts[accountNumber];
            System.out.println(account.getLastName());
        }
        else {
            System.out.println("Invalid command. Please enter account number.");
        }
    }

    public void deposit(String[] commandArray) throws IOException {
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

    public void showHistory(String[] commandArray) {
        if (commandArray.length == 2) {
            int accountNumber = Integer.parseInt(commandArray[1]);
            Account account = accounts[accountNumber];
            account.viewTransactionHistory();
        }
        else {
            System.out.println("Invalid command. Please enter account number.");
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

    public void getGender(String[] commandArray) {
        if (commandArray.length == 2) {
            int accountNumber = Integer.parseInt(commandArray[1]);
            Account account = accounts[accountNumber];
            System.out.println(account.getGender());
        }
        else {
            System.out.println("Invalid command. Please enter account number.");
        }
    }

    public void getBalance(String[] commandArray) {
        if (commandArray.length == 2) {
            int accountNumber = Integer.parseInt(commandArray[1]);
            Account account = accounts[accountNumber];
            System.out.println(account.getBalance());
        }
        else {
            System.out.println("Invalid command. Please enter account number.");
        }
    }

    public void getDob(String[] commandArray) {
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

    public void getJoinDate(String[] commandArray) {
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

    public void getAccountId(String[] commandArray) {
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

    public void help() {
        System.out.println("new : creates new account");
        System.out.println("getaccountid [full name] : gives account id based on full name");
        System.out.println("delete [account id] : deletes account");
        System.out.println("accounts : gives list of all accounts");
        System.out.println("showdetails [account id] : shows details of account");
        System.out.println("deposit [account id] : deposits money to account");
        System.out.println("withdraw [account id] : withdraws money from account");
        System.out.println("get[attribute] [account id] : get attribute of account");
        System.out.println("attributes : age, gender, firstname, lastname, balance, dob, joindate");
        System.out.println("showhistory [account id] : shows transaction history of an account");
        System.out.println("entering x exits program");
        System.out.println("NOTE: entering --cancel-- while creating new account cancels account creation");
    }
}