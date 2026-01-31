import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Mbathio Lo
 */
class SafeInputObjTest {

    private SafeInputObj createWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        return new SafeInputObj(scanner);
    }

    @Test
    void testDefaultConstructor() {
        SafeInputObj obj = new SafeInputObj();
        assertNotNull(obj);
    }

    @Test
    void testConstructorWithScanner() {
        Scanner scanner = new Scanner(System.in);
        SafeInputObj obj = new SafeInputObj(scanner);
        assertNotNull(obj);
    }

    @Test
    void testGetNonZeroLenString() {
        SafeInputObj obj = createWithInput("Hello\n");
        String result = obj.getNonZeroLenString("Enter text");
        assertEquals("Hello", result);
    }

    @Test
    void testGetNonZeroLenStringWithEmptyFirst() {
        SafeInputObj obj = createWithInput("\nWorld\n");
        String result = obj.getNonZeroLenString("Enter text");
        assertEquals("World", result);
    }

    @Test
    void testGetInt() {
        SafeInputObj obj = createWithInput("42\n");
        int result = obj.getInt("Enter number");
        assertEquals(42, result);
    }

    @Test
    void testGetIntWithInvalidFirst() {
        SafeInputObj obj = createWithInput("abc\n123\n");
        int result = obj.getInt("Enter number");
        assertEquals(123, result);
    }

    @Test
    void testGetRangedInt() {
        SafeInputObj obj = createWithInput("5\n");
        int result = obj.getRangedInt("Enter number", 1, 10);
        assertEquals(5, result);
    }

    @Test
    void testGetRangedIntOutOfRangeThenValid() {
        SafeInputObj obj = createWithInput("15\n7\n");
        int result = obj.getRangedInt("Enter number", 1, 10);
        assertEquals(7, result);
    }

    @Test
    void testGetDouble() {
        SafeInputObj obj = createWithInput("3.14\n");
        double result = obj.getDouble("Enter decimal");
        assertEquals(3.14, result, 0.001);
    }

    @Test
    void testGetDoubleWithInvalidFirst() {
        SafeInputObj obj = createWithInput("abc\n2.5\n");
        double result = obj.getDouble("Enter decimal");
        assertEquals(2.5, result, 0.001);
    }

    @Test
    void testGetRangedDouble() {
        SafeInputObj obj = createWithInput("25.5\n");
        double result = obj.getRangedDouble("Enter temperature", 0, 100);
        assertEquals(25.5, result, 0.001);
    }

    @Test
    void testGetRangedDoubleOutOfRangeThenValid() {
        SafeInputObj obj = createWithInput("150.0\n75.5\n");
        double result = obj.getRangedDouble("Enter temperature", 0, 100);
        assertEquals(75.5, result, 0.001);
    }

    @Test
    void testGetYNConfirmYes() {
        SafeInputObj obj = createWithInput("Y\n");
        boolean result = obj.getYNConfirm("Confirm");
        assertTrue(result);
    }

    @Test
    void testGetYNConfirmNo() {
        SafeInputObj obj = createWithInput("N\n");
        boolean result = obj.getYNConfirm("Confirm");
        assertFalse(result);
    }

    @Test
    void testGetYNConfirmInvalidThenYes() {
        SafeInputObj obj = createWithInput("maybe\nY\n");
        boolean result = obj.getYNConfirm("Confirm");
        assertTrue(result);
    }

    @Test
    void testGetYNConfirmLowerCase() {
        SafeInputObj obj = createWithInput("y\n");
        boolean result = obj.getYNConfirm("Confirm");
        assertTrue(result);
    }

    @Test
    void testGetRegExString() {
        SafeInputObj obj = createWithInput("test@email.com\n");
        String result = obj.getRegExString("Enter email", "\\w+@\\w+\\.\\w+");
        assertEquals("test@email.com", result);
    }

    @Test
    void testGetRegExStringInvalidThenValid() {
        SafeInputObj obj = createWithInput("notanemail\nvalid@email.com\n");
        String result = obj.getRegExString("Enter email", "\\w+@\\w+\\.\\w+");
        assertEquals("valid@email.com", result);
    }

    @Test
    void testGetRegExStringWithDigits() {
        SafeInputObj obj = createWithInput("12345\n");
        String result = obj.getRegExString("Enter 5 digits", "\\d{5}");
        assertEquals("12345", result);
    }
}