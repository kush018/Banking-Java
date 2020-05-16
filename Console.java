import java.io.*;

public class Console {

    Account[] accounts = new Account[] { };

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
        }
        else if (commandArray[0].equals("getdob")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    DateClass DOB = account.getDateOfBirth();
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
        }
        else if (commandArray[0].equals("getjoindate")) {
            try {
                if (commandArray.length == 2) {
                    int accountNumber = Integer.parseInt(commandArray[1]);
                    Account account = accounts[accountNumber];
                    DateClass joinDate = account.getJoinDate();
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
        }
    }

    public void newAccount() throws IOException {
        String firstName = getInput("First Name: ");
        String lastName = getInput("Last Name: ");
        String gender = getInput("Gender: ");
        String dateOfBirthString = getInput("Enter Date of Birth (dd/mm/yyyy): ");
        String[] dateOfBirthArray = dateOfBirthString.split("/");
        DateClass dateOfBirth = new DateClass(Integer.parseInt(dateOfBirthArray[0]), Integer.parseInt(dateOfBirthArray[1]), Integer.parseInt(dateOfBirthArray[2]));
        Account account = new Account(firstName, lastName, gender, dateOfBirth);
        accounts = addElementAccount(accounts, account);
        System.out.println("Account created successfully.");
    }

    public void showAccounts() {
        System.out.println("All available accounts are listed below:");
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];
            System.out.println("[" + i + "]" + " " + account.getFirstName() + " " + account.getLastName() + " Age: " + account.getAge() + " Balance: " + account.getBalance());
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
}