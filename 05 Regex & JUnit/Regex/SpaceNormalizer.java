package Regex;

public class SpaceNormalizer {

    public static String replaceMultipleSpaces(String input) {
        if (input == null) {
            return null;
        }

        return input.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        String exampleInput = "This                     is   an example    with multiple     spaces.";
        String result = replaceMultipleSpaces(exampleInput);
        System.out.println(result);

    }
}
