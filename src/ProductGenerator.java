import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.IOException;

public class ProductGenerator {
    public static void main(String[] args) {

        // storing Product objects
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Product Generator");

        Scanner in = new Scanner(System.in);

        boolean done = false;

        while (!done) {

            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            // Create and add a Product object with the input data
            Product product = new Product(name, description, id, cost);
            products.add(product);

            done = !SafeInput.getYNConfirm(in, "Do you want to add another product?");
        }

        // Asking for output file name
        String fileName = SafeInput.getNonZeroLenString(in, "Enter output file name");

        Path file = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {

            // Write each Product object to file using toCSV()
            for (Product product : products) {
                writer.write(product.toCSV());
                writer.newLine();
            }

            System.out.println("Your data is successfully written to " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}