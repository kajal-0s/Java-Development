import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {

    private static final int SHIFT_KEY = 3;  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Encryption/Decryption Program");
        System.out.print("Choose (E)ncrypt or (D)ecrypt: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        if (!choice.equals("E") && !choice.equals("D")) {
            System.out.println("Invalid choice. Exiting.");
            scanner.close();
            return;
        }

        System.out.print("Enter input file path: ");
        String inputFilePath = scanner.nextLine();

        File inputFile = new File(inputFilePath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Input file does not exist or is invalid.");
            scanner.close();
            return;
        }

        String outputFilePath;
        if (choice.equals("E")) {
            outputFilePath = inputFilePath + ".encrypted.txt";
        } else {
            outputFilePath = inputFilePath + ".decrypted.txt";
        }

        try {
            String content = readFile(inputFilePath);
            String processedContent;

            if (choice.equals("E")) {
                processedContent = encrypt(content);
            } else {
                processedContent = decrypt(content);
            }

            writeFile(outputFilePath, processedContent);
            System.out.println("Operation successful! Output saved to: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }

        scanner.close();
    }

    private static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    private static void writeFile(String path, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        }
    }

    private static String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char)(c + SHIFT_KEY));
        }
        return encrypted.toString();
    }

    private static String decrypt(String text) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            decrypted.append((char)(c - SHIFT_KEY));
        }
        return decrypted.toString();
    }
}
