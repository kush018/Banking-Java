import java.io.*;

public class Console implements Serializable {

    private static final long serialVersionUID = 1L;

    Account[] accounts = new Account[] {};
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
            showDetails(Integer.parseInt(commandArray[1]));
        }
        else if (commandArray[0].equals("showhistory")) {
            showHistory(Integer.parseInt(commandArray[1]));
        }
        else if (commandArray[0].equals("deposit")) {
            deposit(Integer.parseInt(commandArray[1]));
        }
        else if (commandArray[0].equals("withdraw")) {
            withdraw(Integer.parseInt(commandArray[1]));
        }
        //removed function
        else if (commandArray[0].equals("getfirstname")) {
            Account account = accounts[Integer.parseInt(commandArray[0])];
            System.out.println(account.getFirstName());
        }
        //removed function
        else if (commandArray[0].equals("getlastname")) {
            Account account = accounts[Integer.parseInt(commandArray[0])];
            System.out.println(account.getLastName());
        }
        else if (commandArray[0].equals("getage")) {
            Account account = accounts[Integer.parseInt(commandArray[0])];
            System.out.println(account.getAge());
        }
        else if (commandArray[0].equals("getgender")) {
            Account account = accounts[Integer.parseInt(commandArray[0])];
            System.out.println(account.getGender());
        }
        else if (commandArray[0].equals("getbalance")) {
            Account account = accounts[Integer.parseInt(commandArray[0])];
            System.out.println(account.getBalance());
        }
        else if (commandArray[0].equals("getdob")) {
            Account account = accounts[Integer.parseInt(commandArray[0])];
            Date dateOfBirth = account.getDateOfBirth();
            System.out.println("dd/mm/yyyy");
            System.out.println(dateOfBirth.getDate() + "/" + dateOfBirth.getMonth() + "/" + dateOfBirth.getYear());
        }
        else if (commandArray[0].equals("getjoindate")) {
            Account account = accounts[Integer.parseInt(commandArray[0])];
            Date joinDate = account.getJoinDate();
            System.out.println("dd/mm/yyyy");
            System.out.println(joinDate.getDate() + "/" + joinDate.getMonth() + "/" + joinDate.getYear());
        }
        else if (commandArray[0].equals("getaccountid")) {
            getAccountId(commandArray);
        }
        else if (commandArray[0].equals("delete")) {
            int accountId = Integer.parseInt(commandArray[1]);
            deleteAccount(accountId);
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
        int accountId;
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
            accountId = accounts.length -1;
        }
        else {
            accountId = deletedAccounts[0];
            accounts[deletedAccounts[0]] = account;
            deletedAccounts = deleteElementInt(deletedAccounts, 0);
        }
        System.out.println("Account created successfully.");
        System.out.println("The account id is: " + accountId);
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

    //optimised
    public void showDetails(int accountId) {
        Account account = accounts[accountId];
        account.viewAccountDetails();
    }

    //optimised
    public void withdraw(int accountId) throws IOException {
        Account account = accounts[accountId];
        int withdrawalAmount = Integer.parseInt(getInput("Enter Amount to Withdraw: "));
        if (getInput("Are you sure you want to withdraw " + withdrawalAmount + " from account number " + accountId + " (y/n): ").equals("y")) {
            account.withdrawMoney(withdrawalAmount);
            System.out.println("Successfully withdrew " + withdrawalAmount + " from account number " + accountId + ".");
        }
        else {
            System.out.println("Withdrawal cancelled.");
        }
    }

    //optimised
    public void deposit(int accountId) throws IOException {
        Account account = accounts[accountId];
        int depositAmount = Integer.parseInt(getInput("Enter Amount to Deposit: "));
        if (getInput("Are you sure you want to deposit " + depositAmount + " to account number " + accountId + " (y/n): ").equals("y")) {
            account.depositMoney(depositAmount);
            System.out.println("Successfully deposited " + depositAmount + " to account number " + accountId + ".");
        }
        else {
            System.out.println("Deposit cancelled.");
        }
    }

    //optimised
    public void showHistory(int accountId) {
        Account account = accounts[accountId];
        account.viewTransactionHistory();
    }

    //already optimised, not possible to optimise more
    public Account[] addElementAccount(Account[] array, Account element) {
        int arrayLength = array.length;
        Account[] newArray = new Account[arrayLength + 1];
        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = array[i];
        }
        newArray[arrayLength] = element;
        return newArray;
    }

    //already optimised, not possible to optimise more
    public int getAccountId(Account[] accountArray, String fullName) {
        int id = -1;
        for (int i = 0; i < accountArray.length; i++) {
            String accountFullName = "";
            try {
                accountFullName = accountArray[i].getFirstName() + " " + accountArray[i].getLastName();
            }
            catch (NullPointerException e) { }
            if (fullName.equals(accountFullName)) {
                id = i;
            }
        }
        return id;
    }

    //already optimised, not possible to optimise more
    public void deleteAccount(int accountId) throws IOException {
        if (getInput(("Are you sure you would like to delete account " + accountId + " (y/n): ")).equals("y")) {
            if (accounts[accountId] != null) {
                accounts[accountId] = null;
                deletedAccounts = addElementInt(deletedAccounts, accountId);
            }
            System.out.println("Account " + accountId + " was deleted successfully");
        }
        else {
            System.out.println("Account deletion cancelled");
        }
    }

    //already optimised, not possible to optimise more
    public int[] addElementInt(int[] array, int element) {
        int arrayLength = array.length;
        int[] newArray = new int[arrayLength + 1];
        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = array[i];
        }
        newArray[arrayLength] = element;
        return newArray;
    }

    //already optimised, not possible to optimise more
    public int[] deleteElementInt(int[] array, int elementIndex) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i != elementIndex) {
                newArray = addElementInt(newArray, array[i]);
            }
        }
        return newArray;
    }

    //already optimised, not possible to optimise more
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

    //already optimised, not possible to optimise more
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
        System.out.println("help : get this list");
        System.out.println("entering x exits program");
        System.out.println("NOTE: entering --cancel-- while creating new account cancels account creation");
        System.out.println("NOTE: extra attributes will be ignored");
    }
}