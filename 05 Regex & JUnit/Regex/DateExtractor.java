package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class DateExtractor {

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return dates;
        }


        String dateRegex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        String exampleText = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        List<String> extractedDates = extractDates(exampleText);


        System.out.println(String.join(", ", extractedDates));
    }
}
