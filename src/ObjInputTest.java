/**
 *
 * @author: Mbathio Lo
 */
public class ObjInputTest {
    public static void main(String[] args) {

        // Creating a SafeInputObj using default constructor
        SafeInputObj input = new SafeInputObj();

        // getNonZeroLenString
        System.out.println("Testing getNonZeroLenString():");
        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("You entered: " + name);

        // getInt
        System.out.println("\nTesting getInt():");
        int age = input.getInt("Enter your age");
        System.out.println("You entered: " + age);

        // getRangedInt
        System.out.println("\nTesting getRangedInt():");
        int favoriteNum = input.getRangedInt("Enter your favorite number", 1, 10);
        System.out.println("You entered: " + favoriteNum);

        // getDouble
        System.out.println("\nTesting getDouble():");
        double height = input.getDouble("Enter your height in meters");
        System.out.println("You entered: " + height);

        // getRangedDouble
        System.out.println("\nTesting getRangedDouble():");
        double temperature = input.getRangedDouble("Enter temperature in Celsius", -50, 50);
        System.out.println("You entered: " + temperature);

        // getYNConfirm
        System.out.println("\nTesting getYNConfirm():");
        boolean confirm = input.getYNConfirm("Do you like programming?");
        System.out.println("You answered: " + (confirm ? "Yes" : "No"));

        // getRegExString
        System.out.println("\nTesting getRegExString():");
        String email = input.getRegExString("Enter your email", "\\w+@\\w+\\.\\w+");
        System.out.println("You entered: " + email);

        System.out.println("\n=== All tests completed successfully! ===");
    }
}