package Regex;

public class CreditCardValidator {

    public static boolean isValidCard(String cardNumber) {

        String cleaned = cardNumber.replaceAll("[^0-9]", "");
        

        if (!cleaned.matches("^(?:4[0-9]{15}|5[1-5][0-9]{14})$")) {
            return false;
        }

        return luhnCheck(cleaned);
    }

    private static boolean luhnCheck(String number) {
        int sum = 0;
        boolean alternate = false;
        
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i));
            
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }
            
            sum += digit;
            alternate = !alternate;
        }
        
        return (sum % 10 == 0);
    }

    public static void main(String[] args) {
        String[] testCards = {
            "4111111111111111",  
            "5555555555554444",  
            "4012888888881881",  
            "5105105105105100",  
            "1234567890123456",  
            "4222222222222"      
        };

        for (String card : testCards) {
            System.out.printf("%-20s → %s%n", card, isValidCard(card) ? "Valid" : "Invalid");
        }
    }
}
