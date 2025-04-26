package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return links;
        }


        String urlRegex = "(https?://[\\w\\-.]+\\.\\w{2,6}(:\\d{1,5})?(/[\\w\\-.~:/?#\\[\\]@!$&'()*+,;=%]*)?)";

        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group(1));
        }

        return links;
    }

    public static void main(String[] args) {
        String exampleText = "Visit https://www.google.com and http://example.org for more info.";
        List<String> extractedLinks = extractLinks(exampleText);
        System.out.println(String.join(", ", extractedLinks)); 

    }
}
