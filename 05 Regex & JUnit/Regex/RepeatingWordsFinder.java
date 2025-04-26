package Regex;

import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {

    public static List<String> findRepeatingWords(String text) {
        List<String> repeatingWords = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return repeatingWords;
        }
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> uniqueWords = new LinkedHashSet<>();

        while (matcher.find()) {
            uniqueWords.add(matcher.group(1).toLowerCase());
        }

        repeatingWords.addAll(uniqueWords);
        return repeatingWords;
    }

    public static void main(String[] args) {
        String exampleInput = "This is a repeated repeated word test.";

        List<String> repeats = findRepeatingWords(exampleInput);

        System.out.println(String.join(", ", repeats));

    }
}
