import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class PersonReader {
    public static void main(String[] args) {

        // ArrayList to store Person objects
        ArrayList<Person> people = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.println("Person Reader");

        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("Program ending because no file was selected.");
            return;
        }

        Path file = chooser.getSelectedFile().toPath();

        try (BufferedReader reader = Files.newBufferedReader(file)) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(",");

                String id = fields[0].trim();
                String firstName = fields[1].trim();
                String lastName = fields[2].trim();
                String title = fields[3].trim();
                int yob = Integer.parseInt(fields[4].trim());

                // Creating and add Person object from the CSV data
                Person person = new Person(firstName, lastName, id, title, yob);
                people.add(person);
            }

        } catch (IOException e) {
            System.out.println("Error in reading file: " + e.getMessage());
        }

        // table header
        System.out.printf("%-10s %-15s %-15s %-8s %4s%n",
                "ID#", "Firstname", "Lastname", "Title", "YOB");
        System.out.println("========================================================");

        // show all Person objects from the ArrayList
        for (Person person : people) {
            System.out.printf("%-10s %-15s %-15s %-8s %4d%n",
                    person.getID(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getTitle(),
                    person.getYOB());
        }
    }
}