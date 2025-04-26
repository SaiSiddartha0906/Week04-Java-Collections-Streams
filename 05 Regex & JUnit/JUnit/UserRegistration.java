package JUnit;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException("Username required");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        if (password == null || password.length() < 8)
            throw new IllegalArgumentException("Password must be at least 8 characters");
    }
}
