package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return capitalizedWords;
        }

        // Regex to match words starting with uppercase letter followed by zero or more lowercase letters
        // \b - word boundary, [A-Z] - uppercase letter, [a-z]* - zero or more lowercase letters
        String regex = "\\b[A-Z][a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        String exampleText = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> capitalizedWords = extractCapitalizedWords(exampleText);

        // Join and print with commas
        System.out.println(String.join(", ", capitalizedWords));
    }
}
