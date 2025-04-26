package Regex;

public class SSNValidator {


    private static final String SSN_PATTERN = "^\\d{3}-\\d{2}-\\d{4}$";

    public static boolean isValidSSN(String ssn) {
        if (ssn == null) {
            return false;
        }
        return ssn.matches(SSN_PATTERN);
    }

    public static void main(String[] args) {
        String[] testSSNs = {"123-45-6789", "123456789", "000-00-0000", "987-65-4321"};

        for (String ssn : testSSNs) {
            System.out.printf("\"%s\" → %s%n", ssn, isValidSSN(ssn) ? "Valid" : "Invalid");
        }
    }
}
