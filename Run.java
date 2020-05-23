import java.io.*;

public class Run {
    public static void main(String[] args) throws java.io.IOException, ClassNotFoundException {
        Console console;
        try {
            console = readConsoleObject("accounts.acc");
            System.out.println("Save found. " + console.accounts.length + " accounts loaded");
        }
        catch (FileNotFoundException e) {
            console = new Console();
            System.out.println("No save found. No accounts loaded.");
        }
        System.out.println("Welcome to banking console! Enter \"help\" to get a list of all valid commands.");
        while (true) {
            String command = console.getInput();
            if (command.equals("x")) {
                writeConsoleObject(console, "accounts.acc");
                System.out.println("Accounts saved successfully");
                System.out.println("Bye!");
                System.exit(0);
            }
            else {
                try {
                    console.executeCommand(command);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid account number");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number");
                } catch (NullPointerException e) {
                    System.out.println("Invalid account number.");
                } catch (Exception e) {
                    System.out.println("There was an exception.");
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeConsoleObject(Console console, String filePath) throws FileNotFoundException, IOException {
        ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(filePath));
        objectWriter.writeObject(console);
        objectWriter.close();
    }

    private static Console readConsoleObject(String filePath) throws ClassNotFoundException, IOException {
        ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(filePath));
        Console console = (Console) objectReader.readObject();
        objectReader.close();
        return console;
    }
}