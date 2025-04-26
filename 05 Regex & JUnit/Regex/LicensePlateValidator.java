package Regex;

public class LicensePlateValidator {

    public static boolean isValidLicensePlate(String plate) {
        if (plate == null) {
            return false;
        }
        if (plate.length() != 6) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            char ch = plate.charAt(i);
            if (ch < 'A' || ch > 'Z') {
                return false;
            }
        }
        for (int i = 2; i < 6; i++) {
            char ch = plate.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String[] testPlates = {"AB1234", "A12345", "XY9876", "ab1234", "AB12C4", "ABC123"};
        for (String plate : testPlates) {
            System.out.printf("\"%s\" -> %s%n", plate, isValidLicensePlate(plate) ? "Valid" : "Invalid");
        }
    }
}

