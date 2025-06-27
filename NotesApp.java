import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Simple Notes App ===");

        do {
            System.out.println("\n1. Write a Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeNote(scanner);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes App...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        scanner.close();
    }

    // Method to write a note to the file
    public static void writeNote(Scanner scanner) {
        System.out.println("Enter your note:");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + "\n");
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the note.");
            e.printStackTrace();
        }
    }

    // Method to read all notes from the file
    public static void readNotes() {
        System.out.println("\n--- All Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(count + ". " + line);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Start by writing a note.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the notes.");
            e.printStackTrace();
        }
    }
}
