package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class EmailExtractor {

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return emails;
        }
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        String exampleText = "Contact us at support@example.com and info@company.org";

        List<String> extractedEmails = extractEmails(exampleText);

        for (String email : extractedEmails) {
            System.out.println(email);
        }
    }
}
