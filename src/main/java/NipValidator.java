/*
 NIP is the Polish Tax Identification Number.
 A NIP number consists of 10 digits and it is used to identify the tax payers of Poland.
 A NOP number is mandated if you pay taxes in Poland.
 It can also be used as your additional Polish identification number,
 */

public class NipValidator {

    public boolean valid(String nip) {

        int length = nip.length();

        //nip has 15 characters, the first two characters are different from "PL"
        if (length == 15 && !nip.substring(0, 2).equals("PL")) {
            return false;
        }

        //nip has 15 characters, the first two characters are "PL"
        if (length == 15 && nip.substring(0, 2).equals("PL")) {
            nip = nip.substring(2, 15);
            if (nip.charAt(3) != '-' || nip.charAt(7) != '-' || nip.charAt(10) != '-') {
                return false;
            } else {
                nip = nip.replace("-", "");
                length = nip.length();
            }
        }

        // nip has 13 characters
        if (length == 13) {
            if (nip.charAt(3) != '-' || nip.charAt(7) != '-' || nip.charAt(10) != '-') {
                return false;
            } else {
                nip = nip.replace("-", "");
                length = nip.length();
            }
        }

        // nip is less than 10 characters
        if (length < 10) {
            return false;
        }

        // nip is greater than 10 characters
        if (length > 10) {
            return false;
        }

        // we divide the string into characters
        String[] chars = nip.split("");

        int[] numbers = new int[10];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.valueOf(chars[i]);
        }

        // multiply subsequent digits by appropriate weights and add to each other
        int sum = numbers[0] * 6 + numbers[1] * 5 + numbers[2] * 7 + numbers[3] * 2 + numbers[4] * 3 + numbers[5] * 4 + numbers[6] * 5
                + numbers[7] * 6 + numbers[8] * 7;

        // divide the result into modulo by eleven
        sum = sum % 11;

        // the result of the division is 10 or 11
        if (sum == 10 || sum == 11) {
            return false;
        }

        return sum == numbers[9];
    }
}
