import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {

        // ArrayList to store Product objects
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Product Reader");

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
                String name = fields[1].trim();
                String description = fields[2].trim();
                double cost = Double.parseDouble(fields[3].trim());

                // Create and add a Product object from the CSV data
                Product product = new Product(name, description, id, cost);
                products.add(product);
            }

        } catch (IOException e) {
            System.out.println("Error in reading file: " + e.getMessage());
        }

        // table header
        System.out.printf("%-10s %-15s %-30s %8s%n",
                "ID#", "Name", "Description", "Cost");
        System.out.println("==============================================================");

        for (Product product : products) {
            System.out.printf("%-10s %-15s %-30s %8.2f%n",
                    product.getID(),
                    product.getName(),
                    product.getDescription(),
                    product.getCost());
        }
    }
}