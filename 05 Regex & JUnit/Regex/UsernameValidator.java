package Regex;
public class UsernameValidator {

    public static boolean isValidUsername(String username) {

        if (username == null || username.length() < 5 || username.length() > 15) {
            return false;
        }
        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }
        for (char ch : username.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] testUsernames = {"user_123", "123user", "us", "valid_User1", "invalid-user", "UserName_15"};

        for (String username : testUsernames) {
            System.out.printf("\"%s\" -> %s%n", username, isValidUsername(username) ? "Valid" : "Invalid");
        }
    }
}
