import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Mbathio Lo
 */
class ProductTest {

    private Product testProduct1;
    private Product testProduct2;
    private Product testProduct3;

    @BeforeEach
    void setUp() {
        testProduct1 = new Product("Laptop", "High-performance laptop", "P001", 1299.99);
        testProduct2 = new Product("Mouse", "Wireless mouse", "P002", 29.99);
        testProduct3 = new Product("Keyboard", "P003", 79.99);
    }

    @Test
    void testFullConstructor() {
        Product product = new Product("Monitor", "27-inch 4K monitor", "P004", 499.99);
        assertEquals("Monitor", product.getName());
        assertEquals("27-inch 4K monitor", product.getDescription());
        assertEquals("P004", product.getID());
        assertEquals(499.99, product.getCost(), 0.01);
    }

    @Test
    void testConstructorWithoutDescription() {
        Product product = new Product("Headphones", "P005", 149.99);
        assertEquals("Headphones", product.getName());
        assertEquals("", product.getDescription());
        assertEquals("P005", product.getID());
        assertEquals(149.99, product.getCost(), 0.01);
    }

    @Test
    void testDefaultConstructor() {
        Product product = new Product();
        assertEquals("", product.getName());
        assertEquals("", product.getDescription());
        assertEquals("", product.getID());
        assertEquals(0.0, product.getCost(), 0.01);
    }

    @Test
    void testSetName() {
        testProduct1.setName("Gaming Laptop");
        assertEquals("Gaming Laptop", testProduct1.getName());
    }

    @Test
    void testSetDescription() {
        testProduct1.setDescription("Ultra high-performance gaming laptop");
        assertEquals("Ultra high-performance gaming laptop", testProduct1.getDescription());
    }

    @Test
    void testSetCost() {
        testProduct1.setCost(1499.99);
        assertEquals(1499.99, testProduct1.getCost(), 0.01);
    }

    @Test
    void testToCSV() {
        String expected = "P001, Laptop, High-performance laptop, 1299.99";
        assertEquals(expected, testProduct1.toCSV());
    }

    @Test
    void testToCSVProduct2() {
        String expected = "P002, Mouse, Wireless mouse, 29.99";
        assertEquals(expected, testProduct2.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\n" +
                "  \"ID\": \"P001\",\n" +
                "  \"name\": \"Laptop\",\n" +
                "  \"description\": \"High-performance laptop\",\n" +
                "  \"cost\": 1299.99\n" +
                "}";
        assertEquals(expected, testProduct1.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Product>\n" +
                "  <ID>P001</ID>\n" +
                "  <name>Laptop</name>\n" +
                "  <description>High-performance laptop</description>\n" +
                "  <cost>1299.99</cost>\n" +
                "</Product>";
        assertEquals(expected, testProduct1.toXML());
    }

    @Test
    void testToString() {
        String result = testProduct1.toString();
        assertTrue(result.contains("P001"));
        assertTrue(result.contains("Laptop"));
        assertTrue(result.contains("High-performance laptop"));
        assertTrue(result.contains("1299.99"));
    }

    @Test
    void testEquals() {
        Product product1 = new Product("Laptop", "High-performance laptop", "P001", 1299.99);
        Product product2 = new Product("Laptop", "High-performance laptop", "P001", 1299.99);
        assertEquals(product1, product2);
    }

    @Test
    void testNotEquals() {
        Product product1 = new Product("Laptop", "High-performance laptop", "P001", 1299.99);
        Product product2 = new Product("Mouse", "Wireless mouse", "P002", 29.99);
        assertNotEquals(product1, product2);
    }

    @Test
    void testEqualsSameObject() {
        assertEquals(testProduct1, testProduct1);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(null, testProduct1);
    }

    @Test
    void testEqualsDifferentCost() {
        Product product1 = new Product("Laptop", "High-performance laptop", "P001", 1299.99);
        Product product2 = new Product("Laptop", "High-performance laptop", "P001", 1399.99);
        assertNotEquals(product1, product2);
    }
}