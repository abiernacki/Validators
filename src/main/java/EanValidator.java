/*
A European Article numbering code (EAN) is used to help build credibility for your eCommerce store.

It’s a series of letters and numbers in a unique order that helps identify specific products
within your own inventory.
 */

public class EanValidator {

    public boolean valid(String ean) {

        int length = ean.length();

        if (length < 14) {
            return false;
        }

        if (length > 14) {
            return false;
        }

        // we divide the string into characters
        String[] chars = ean.split("");


        // multiply subsequent digits by appropriate weights and add to each other
        int sum1 = 0;
        int sum2 = 0;
        int[] numbers = new int[14];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.valueOf(chars[i]);
            if (i == 0 || i % 2 == 0) {
                sum1 = sum1 + numbers[i] * 3;
            } else if (i % 2 != 0 && i != 13) {
                sum2 = sum2 + numbers[i] * 1;
            }
        }

        //we add numbers multiplied by 3 and numbers multiplied by 1
        int sum = sum1 + sum2;

        // divide the result into modulo by ten
        sum = sum % 10;

        //ten subtract the result
        sum = 10 - sum;

        return sum == numbers[13];

    }
}
