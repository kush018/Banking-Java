import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private double balance;
    private int age;
    private String firstName, lastName, gender;
    private Date dateOfBirth, joinDate;

    private double[] transactionHistory = new double[] { };

    public Account(String firstName, String lastName, String gender, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        balance = 0d;
        joinDate = new Date();
        age = joinDate.getYear() - dateOfBirth.getYear();
        if (joinDate.getMonth() < dateOfBirth.getMonth()) {
            age--;
        }
        else if (joinDate.getMonth() == dateOfBirth.getMonth() && joinDate.getDate() < dateOfBirth.getDate()) {
            age--;
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getJoinDate() {
        return joinDate;
    }
    
    public void depositMoney(double deposit) {
        balance += deposit;
        transactionHistory = addElementDouble(transactionHistory, deposit);
    }

    public void withdrawMoney(double withdrawal) {
        balance -= withdrawal;
        transactionHistory = addElementDouble(transactionHistory, -withdrawal);
    }

    public void viewAccountDetails() {
        System.out.println("Account Details: ");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Account Balance: " + balance);
        System.out.println("Date of Birth (dd/mm/yyyy): " + dateOfBirth.getDate() + "/" + dateOfBirth.getMonth() + "/" + dateOfBirth.getYear());
        System.out.println("Date of Joining: (dd/mm/yyyy): " + joinDate.getDate() + "/" + joinDate.getMonth() + "/" + joinDate.getYear());
    }

    public void viewTransactionHistory() {
        System.out.println("Account Transaction History: ");
        for (int i = 0; i < transactionHistory.length; i++) {
            if (transactionHistory[i] < 0) {
                System.out.println("Withdrawal: " + -transactionHistory[i]);
            }
            else {
                System.out.println("Deposit: " + transactionHistory[i]);
            }
        }
    }

    public double[] addElementDouble(double[] array, double element) {
        int arrayLength = array.length;
        double[] newArray = new double[arrayLength + 1];
        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = array[i];
        }
        newArray[arrayLength] = element;
        return newArray;
    }
}