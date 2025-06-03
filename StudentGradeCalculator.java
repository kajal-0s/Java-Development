import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");

        // Ask for number of grades
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        // Validate input
        if (numberOfGrades <= 0) {
            System.out.println("Number of grades must be greater than zero.");
            return;
        }

        double[] grades = new double[numberOfGrades];
        double sum = 0;

        // Input grades
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();

            // Optional: Validate grade range (0 to 100)
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Grade must be between 0 and 100.");
                i--; // Re-prompt for this grade
                continue;
            }

            sum += grades[i];
        }

        // Calculate average
        double average = sum / numberOfGrades;

        // Display result
        System.out.printf("Average grade: %.2f\n", average);

        scanner.close();
    }
}
