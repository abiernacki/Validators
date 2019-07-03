/*
 Land and Mortgage Register is a public register that reveals the legal status of the property.
 It allows you to determine who it belongs to and what rights your property has.
 The land registry is quite common to the family of continental legal systems,
 although the registers of perpetual usufruct in different countries differ significantly.
 */

public class KwValidator {

    // we create an array of characters
    char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y', 'Z'};

    public boolean valid(String kw) {
        if(kw == null) {
            return false;
        }

        int length = kw.length();

        // the kw is shorter than 15 characters
        if (length < 15) {
            return false;
        }


        // the kw is longer than 15 characters
        if (length > 15) {
            return false;
        }

        // there are no separators in their places
        if (kw.charAt(4) != '/' || kw.charAt(13) != '/') {
            return false;
        }

        // no letters in the right places
        if (decoding(kw.charAt(0)) < 10 || decoding(kw.charAt(1)) < 10 || decoding(kw.charAt(3)) < 10) {
            return false;
        }

        // no numbers in the right places
        if (decoding(kw.charAt(2)) >= 10) {
            return false;
        }

        // no characters in the right places
        for (int i = 5; i < 13; i++) {
            if (decoding(kw.charAt(i)) >= 10) {
                return false;
            }
        }

        // multiply subsequent digits by appropriate weights and add to each other
        int sum = 1 * decoding(kw.charAt(0)) + 3 * decoding(kw.charAt(1)) + 7 * decoding(kw.charAt(2))
                + 1 * decoding(kw.charAt(3)) + 3 * decoding(kw.charAt(5)) + 7 * decoding(kw.charAt(6))
                + 1 * decoding(kw.charAt(7)) + 3 * decoding(kw.charAt(8)) + 7 * decoding(kw.charAt(9))
                + 1 * decoding(kw.charAt(10)) + 3 * decoding(kw.charAt(11)) + 7 * decoding(kw.charAt(12));

        // divide the result into modulo by ten
        sum = sum % 10;

        // we compare the result with the last digit
        return sum == decoding(kw.charAt(14));
    }

    // method that replaces the sign
    public int decoding(char decode) {

        for (int i = 0; i < chars.length; i++) {
            if (decode == chars[i]) {
                return i;
            }
        }
        return -1;
    }
}
