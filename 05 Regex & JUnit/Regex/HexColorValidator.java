package Regex;

public class HexColorValidator {

    private static final String HEX_COLOR_PATTERN = "^#[a-fA-F0-9]{6}$";

    public static boolean isValidHexColor(String colorCode) {
        if (colorCode == null) {
            return false;
        }
        return colorCode.matches(HEX_COLOR_PATTERN);
    }

    public static void main(String[] args) {
        String[] testColors = {"#FFA500", "#ff4500", "#123", "#123456", "#abcdeG", "123456", "#FFFFF"};

        for (String color : testColors) {
            System.out.printf("\"%s\" -> %s%n", color, isValidHexColor(color) ? "Valid" : "Invalid");
        }
    }
}
