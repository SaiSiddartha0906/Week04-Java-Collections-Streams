package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Abcd1234"));
    }

    @Test
    void testInvalidPasswordShort() {
        assertFalse(validator.isValid("A1b"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(validator.isValid("abcd1234"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(validator.isValid("Abcdefgh"));
    }
}
