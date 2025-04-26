package Regex;

import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {


    private static final String[] LANGUAGES = {
        "Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Ruby", "Swift",
        "Kotlin", "PHP", "TypeScript", "Scala", "Perl", "Rust", "Dart", "Objective-C"
    };

    public static List<String> extractLanguages(String text) {
        List<String> foundLanguages = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return foundLanguages;
        }


        String patternString = "\\b(" + String.join("|", LANGUAGES) + ")\\b";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> uniqueMatches = new LinkedHashSet<>(); // preserve order, avoid duplicates

        while (matcher.find()) {

            String match = matcher.group();
            for (String lang : LANGUAGES) {
                if (lang.equalsIgnoreCase(match)) {
                    uniqueMatches.add(lang);
                    break;
                }
            }
        }

        foundLanguages.addAll(uniqueMatches);
        return foundLanguages;
    }

    public static void main(String[] args) {
        String exampleText = "I love Java, C, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = extractLanguages(exampleText);
        System.out.println(String.join(", ", languages));

    }
}
