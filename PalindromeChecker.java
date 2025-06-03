
import java.util.Scanner;

public class PalindromeChecker {

    public static String cleanInput(String input) {
        return input.replaceAll("[^A-Za-z]", "").toLowerCase();
    }

    public static boolean isPalindrome(String input) {
        String cleaned = cleanInput(input);
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Palindrome Checker");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }

        scanner.close();
    }
}
