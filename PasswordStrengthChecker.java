import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.print("Enter a password to check: ");
        String password = scanner.nextLine();

        int score = 0;

        
        if (password.length() >= 8) {
            score++;
        }

        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        if (password.matches(".*[a-z].*")) {
            score++;
        }

        if (password.matches(".*\\d.*")) {
            score++;
        }

        if (password.matches(".*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?].*")) {
            score++;
        }

        System.out.println("Password Strength Score: " + score + " out of 5");

        if (score <= 2) {
            System.out.println("Weak password. Try adding uppercase letters, numbers, or special characters.");
        } else if (score == 3 || score == 4) {
            System.out.println("Moderate password. Could be stronger with more variety.");
        } else {
            System.out.println("Strong password!");
        }

        scanner.close();
    }
}
