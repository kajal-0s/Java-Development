import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        System.out.println("Random Password Generator");


        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLowercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUppercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecial = scanner.nextLine().equalsIgnoreCase("y");


        String charPool = "";
        if (useNumbers) charPool += numbers;
        if (useLowercase) charPool += lowercase;
        if (useUppercase) charPool += uppercase;
        if (useSpecial) charPool += specialChars;


        if (charPool.isEmpty()) {
            System.out.println("Error: No character types selected. Cannot generate password.");
            return;
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }
        System.out.println("Generated Password: " + password.toString());

        scanner.close();
    }
}
