package Regex;

public class BadWordsCensor {

    public static String censorBadWords(String sentence, String[] badWords) {
        if (sentence == null || badWords == null) {
            return sentence;
        }

        for (String badWord : badWords) {

            sentence = sentence.replaceAll("\\b" + badWord + "\\b", "****");
        }

        return sentence;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String censored = censorBadWords(input, badWords);
        System.out.println(censored);
    }
}
