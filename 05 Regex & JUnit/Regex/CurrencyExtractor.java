package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CurrencyExtractor {

    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return values;
        }

        String regex = "\\$?\\d+\\.\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            values.add(matcher.group());
        }

        return values;
    }

    public static void main(String[] args) {
        String exampleText = "The price is $45.99, and the discount is 10.50.";

        List<String> extractedValues = extractCurrencyValues(exampleText);

        System.out.println(String.join(", ", extractedValues));

    }
}
