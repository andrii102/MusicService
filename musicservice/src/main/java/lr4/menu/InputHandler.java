package lr4.menu;
import java.util.Scanner;

public class InputHandler {
    private static InputHandler instance;
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputHandler getInstance() {
        if (instance == null) { // Check if instance already exists
            instance = new InputHandler(new Scanner(System.in)); // Create a new instance if it does not exist
        }
        return instance; // Return the existing instance
    }

    // Method to set the scanner for testing
    public static void setInstance(Scanner scanner) {
        instance = new InputHandler(scanner);
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();            
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        return value;
    }
}


