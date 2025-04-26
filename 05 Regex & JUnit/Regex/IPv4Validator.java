package Regex;

public class IPv4Validator {

    public static boolean isValidRegex(String ip) {
        if (ip == null) return false;
        return ip.matches("^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])(\\.(?!$)|$)){4}$");
    }


    public static boolean isValidManual(String ip) {
        if (ip == null || ip.isEmpty()) return false;
        
        String[] octets = ip.split("\\.");
        if (octets.length != 4) return false;

        for (String octet : octets) {
            if (octet.length() < 1 || octet.length() > 3) return false;
            if (octet.startsWith("0") && octet.length() > 1) return false;  // No leading zeros
            
            try {
                int num = Integer.parseInt(octet);
                if (num < 0 || num > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] validIPs = {"192.168.1.1", "0.0.0.0", "255.255.255.255"};
        String[] invalidIPs = {"256.0.0.0", "01.02.03.04", "192.168.1", "192.168.1.1.1"};

        System.out.println("Regex Validation:");
        testValidator(IPv4Validator::isValidRegex, validIPs, invalidIPs);
        
        System.out.println("\nManual Validation:");
        testValidator(IPv4Validator::isValidManual, validIPs, invalidIPs);
    }

    private static void testValidator(java.util.function.Function<String, Boolean> validator, 
                                     String[] valid, String[] invalid) {
        for (String ip : valid) {
            System.out.printf("%-15s → %s%n", ip, validator.apply(ip) ? "Valid" : "Invalid");
        }
        for (String ip : invalid) {
            System.out.printf("%-15s → %s%n", ip, validator.apply(ip) ? "Valid" : "Invalid");
        }
    }
}
