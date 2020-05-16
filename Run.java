public class Run {
    public static void main(String[] args) throws java.io.IOException {
        Console console = new Console();
        while (true) {
            String command = console.getInput();
            if (command.equals("x")) {
                System.exit(0);
            }
            else {
                try {
                    console.executeCommand(command);
                }
                catch (Exception e) {
                    System.out.println("There was an exception.");
                    e.printStackTrace();
                }
            }
        }
    }
}