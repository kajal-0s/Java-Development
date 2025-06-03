import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");
        System.out.print("Enter the temperature (e.g., 100C or 212F): ");
        String input = scanner.nextLine().trim().toUpperCase();

        try {
            if (input.endsWith("C")) {
                double celsius = Double.parseDouble(input.substring(0, input.length() - 1));
                double fahrenheit = celsiusToFahrenheit(celsius);
                System.out.printf("%.2f°C is %.2f°F\n", celsius, fahrenheit);
            } else if (input.endsWith("F")) {
                double fahrenheit = Double.parseDouble(input.substring(0, input.length() - 1));
                double celsius = fahrenheitToCelsius(fahrenheit);
                System.out.printf("%.2f°F is %.2f°C\n", fahrenheit, celsius);
            } else {
                System.out.println("Invalid input. Please end your input with 'C' or 'F'.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric value. Please try again.");
        }

        scanner.close();
    }
}
