import java.rmi.Naming;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Client {
    public static void main(String[] args) {
     int fromBase;
     int number;
     int toBase;
        try {
            Scanner scanner = new Scanner(System.in);
            //verify if the from-base and to-base is valid 
            while (true) {
                System.out.print("Enter the base of the number (2, 8, 10, 16): ");
                try {
                    fromBase = scanner.nextInt();
                    if (fromBase == 2 || fromBase == 8 || fromBase == 10 || fromBase == 16) break; // valid base
                    System.out.println("Invalid base! Please enter 2, 8, 10, or 16.");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Enter an integer."); // handle non-integer input
                    scanner.next(); // clear invalid input
                }
            }
            while (true) {
                System.out.print("Enter the base to convert to (2, 8, 10, 16): ");
                try {
                    toBase = scanner.nextInt();
                    if (toBase == 2 || toBase == 8 || toBase == 10 || toBase == 16) break; // valid base
                    System.out.println("Invalid base! Please enter 2, 8, 10, or 16.");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Enter an integer."); // handle non-integer input
                    scanner.next();
                }
            }
            // valid the number entered
            while (true) {
                System.out.print("Enter a positive number to convert: ");
                try {
                    number = scanner.nextInt();
                    if (number >= 0) break; 
                    System.out.println("Number must be positive!");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Enter an integer.");
                    scanner.next();
                }
            }
            // Lookup the RMI service
            Convertingnumb service = (Convertingnumb) Naming.lookup("rmi://localhost/NumberService");
            String result = service.convert(number, fromBase, toBase); // call RMI method
            System.out.println("Converted number: " + result); // display result
        } catch (Exception e) {
            System.out.println("Error during conversion:"); 
            e.printStackTrace();
        }
    }
}
