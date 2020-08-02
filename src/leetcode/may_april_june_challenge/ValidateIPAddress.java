package leetcode.may_april_june_challenge;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP == null) return "Neither";
        String[] ipv4 = IP.split("\\.", -1);
        String[] ipv6 = IP.split(":", -1);
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            for (String s : ipv4)
                if (!isIPv4(s)) return "Neither";
            return "IPv4";
        }
        if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            for (String s : ipv6)
                if (!isIPv6(s)) return "Neither";
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isIPv4(String s) {
        try {
            return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isIPv6(String s) {
        if (s.length() > 4) return false;
        try {
            return Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidateIPAddress address = new ValidateIPAddress();
        // Corner Cases
        System.out.println(address.validIPAddress(""));
        System.out.println(address.validIPAddress(" "));
        System.out.println(address.validIPAddress(null));
        // IPv4 Tests
        System.out.println(address.validIPAddress("172.16.254.1"));
        System.out.println(address.validIPAddress("10.0.1.2/32"));
        System.out.println(address.validIPAddress("256.256.256.256"));
        // IPv6 Tests
        System.out.println(address.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(address.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(address.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
        System.out.println(address.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }
}
