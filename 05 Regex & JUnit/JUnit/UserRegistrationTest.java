package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration reg = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> reg.registerUser("john", "john@example.com", "Password1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> reg.registerUser("", "john@example.com", "Password1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> reg.registerUser("john", "johnexample.com", "Password1"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> reg.registerUser("john", "john@example.com", "123"));
    }
}
