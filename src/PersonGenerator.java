import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.IOException;

public class PersonGenerator {
    public static void main(String[] args) {

        // storing Person objects
        ArrayList<Person> people = new ArrayList<>();

        System.out.println("Person Generator");

        Scanner in = new Scanner(System.in);

        boolean done = false;

        while (!done) {

            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title");
            int yob = SafeInput.getInt(in, "Enter Year of Birth");

            // Create and add a Person object with the input data
            Person person = new Person(firstName, lastName, id, title, yob);
            people.add(person);

            done = !SafeInput.getYNConfirm(in, "Do you want to add another person?");
        }

        // Asking for user to enter an output file name
        String fileName = SafeInput.getNonZeroLenString(in, "Enter output file name");

        Path file = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {

            // Write each Person object to file using toCSV() method
            for (Person person : people) {
                writer.write(person.toCSV());
                writer.newLine();
            }

            System.out.println("The data you entered is successfully written to " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}