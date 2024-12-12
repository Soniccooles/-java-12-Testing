package task01;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests
{
    @Test
    void test_zero_length_string() {
        Throwable exception = Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""));
        Assertions.assertEquals("Zero length string", exception.getMessage());
    }

    @Test
    void test_first_sign() {
        Assertions.assertEquals(-1, Integer.decode("-1"));
        Assertions.assertEquals(2, Integer.decode("+2"));
    }

    @Test
    void test_hex_number_system() {
        Assertions.assertEquals(1000, Integer.decode("0x3E8"));
        Assertions.assertEquals(-1000, Integer.decode("-0x3E8"));
        Assertions.assertEquals(1000, Integer.decode("+0x3E8"));

        Assertions.assertEquals(1000, Integer.decode("#3E8"));
        Assertions.assertEquals(-1000, Integer.decode("-#3E8"));
        Assertions.assertEquals(1000, Integer.decode("+#3E8"));
    }

    @Test
    void test_decimal_system() {
        Assertions.assertEquals(1000, Integer.decode("1000"));
        Assertions.assertEquals(-1000, Integer.decode("-1000"));
        Assertions.assertEquals(1000, Integer.decode("+1000"));
    }

    @Test
    void test_octal_number_system() {
        Assertions.assertEquals(1000, Integer.decode("01750"));
        Assertions.assertEquals(-1000, Integer.decode("-01750"));
        Assertions.assertEquals(1000, Integer.decode("+01750"));
    }

    @Test
    void test_sign_character_in_wrong_position() {

        Assertions.assertEquals("java.lang.NumberFormatException: Sign character in wrong position", Assertions.assertThrows(NumberFormatException.class, () ->
                Integer.decode("0x-3E8")).toString());

        Assertions.assertEquals("java.lang.NumberFormatException: Sign character in wrong position", Assertions.assertThrows(NumberFormatException.class, () ->
                Integer.decode("0x+3E8")).toString());

        Assertions.assertEquals("java.lang.NumberFormatException: Sign character in wrong position", Assertions.assertThrows(NumberFormatException.class, () ->
                Integer.decode("0-1750")).toString());

        Assertions.assertEquals("java.lang.NumberFormatException: Sign character in wrong position", Assertions.assertThrows(NumberFormatException.class, () ->
                Integer.decode("0+1750")).toString());

        Assertions.assertEquals("java.lang.NumberFormatException: Sign character in wrong position", Assertions.assertThrows(NumberFormatException.class, () ->
                Integer.decode("#-3E8")).toString());

        Assertions.assertEquals("java.lang.NumberFormatException: Sign character in wrong position", Assertions.assertThrows(NumberFormatException.class, () ->
                Integer.decode("#+3E8")).toString());
    }

    @Test
    void test_incorrect_number_format() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("0x0-2sf!sjkz"));
    }

    @Test
    void test_bigger_type_format() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("0x80000000"));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("2147483648"));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("020000000000"));
    }
}
