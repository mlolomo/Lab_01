import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Mbathio Lo
 */
class PersonTest {

    private Person testPerson1;
    private Person testPerson2;
    private Person testPerson3;

    @BeforeEach
    void setUp() {
        // Create test instances to use in tests
        testPerson1 = new Person("John", "Doe", "000001", "Mr.", 1990);
        testPerson2 = new Person("Jane", "Smith", "000002", "Dr.", 1985);
        testPerson3 = new Person("Bob", "Johnson", "000003", 1995);
    }

    @Test
    void testFullConstructor() {
        Person person = new Person("Alice", "Williams", "000004", "Ms.", 2000);
        assertEquals("Alice", person.getFirstName());
        assertEquals("Williams", person.getLastName());
        assertEquals("000004", person.getID());
        assertEquals("Ms.", person.getTitle());
        assertEquals(2000, person.getYOB());
    }

    @Test
    void testConstructorWithoutTitle() {
        Person person = new Person("Tom", "Brown", "000005", 1988);
        assertEquals("Tom", person.getFirstName());
        assertEquals("Brown", person.getLastName());
        assertEquals("000005", person.getID());
        assertEquals("", person.getTitle());
        assertEquals(1988, person.getYOB());
    }

    @Test
    void testDefaultConstructor() {
        Person person = new Person();
        assertEquals("", person.getFirstName());
        assertEquals("", person.getLastName());
        assertEquals("", person.getID());
        assertEquals("", person.getTitle());
        assertEquals(2000, person.getYOB());
    }

    @Test
    void testSetFirstName() {
        testPerson1.setFirstName("Michael");
        assertEquals("Michael", testPerson1.getFirstName());
    }

    @Test
    void testSetLastName() {
        testPerson1.setLastName("Anderson");
        assertEquals("Anderson", testPerson1.getLastName());
    }

    @Test
    void testSetTitle() {
        testPerson1.setTitle("Prof.");
        assertEquals("Prof.", testPerson1.getTitle());
    }

    @Test
    void testSetYOB() {
        testPerson1.setYOB(1992);
        assertEquals(1992, testPerson1.getYOB());
    }

    @Test
    void testFullName() {
        String expected = "John Doe";
        assertEquals(expected, testPerson1.fullName());
    }

    @Test
    void testFormalName() {
        String expected = "Mr. John Doe";
        assertEquals(expected, testPerson1.formalName());
    }

    @Test
    void testFormalNameWithoutTitle() {
        String expected = " Bob Johnson";
        assertEquals(expected, testPerson3.formalName());
    }

    @Test
    void testGetAge() {
        String age = testPerson1.getAge();
        int expectedAge = 2026 - 1990;
        assertEquals(String.valueOf(expectedAge), age);
    }

    @Test
    void testGetAgeWithYear() {
        String age = testPerson1.getAge(2020);
        String expected = "30";
        assertEquals(expected, age);
    }

    @Test
    void testGetAgeWithYearDifferentPerson() {
        String age = testPerson2.getAge(2025);
        String expected = "40";
        assertEquals(expected, age);
    }

    @Test
    void testToCSV() {
        String expected = "000001, John, Doe, Mr., 1990";
        assertEquals(expected, testPerson1.toCSV());
    }

    @Test
    void testToCSVPerson2() {
        String expected = "000002, Jane, Smith, Dr., 1985";
        assertEquals(expected, testPerson2.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\n" +
                "  \"ID\": \"000001\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"title\": \"Mr.\",\n" +
                "  \"YOB\": 1990\n" +
                "}";
        assertEquals(expected, testPerson1.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Person>\n" +
                "  <ID>000001</ID>\n" +
                "  <firstName>John</firstName>\n" +
                "  <lastName>Doe</lastName>\n" +
                "  <title>Mr.</title>\n" +
                "  <YOB>1990</YOB>\n" +
                "</Person>";
        assertEquals(expected, testPerson1.toXML());
    }

    @Test
    void testToString() {
        String result = testPerson1.toString();
        assertTrue(result.contains("000001"));
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Doe"));
        assertTrue(result.contains("Mr."));
        assertTrue(result.contains("1990"));
    }

    @Test
    void testEquals() {
        Person person1 = new Person("John", "Doe", "000001", "Mr.", 1990);
        Person person2 = new Person("John", "Doe", "000001", "Mr.", 1990);
        assertEquals(person1, person2);
    }

    @Test
    void testNotEquals() {
        Person person1 = new Person("John", "Doe", "000001", "Mr.", 1990);
        Person person2 = new Person("Jane", "Doe", "000002", "Ms.", 1990);
        assertNotEquals(person1, person2);
    }

    @Test
    void testEqualsSameObject() {
        assertEquals(testPerson1, testPerson1);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(null, testPerson1);
    }
}