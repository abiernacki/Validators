/*
 The PESEL number is an identification number given to every Polish citizen
 when they are born and registered in Poland.
 Moreover, expats that meet certain criteria or apply for it also can get the PESEL number.
 Every PESEL number consists of eleven digits.
 */

public class Pesel {


    public boolean valid(String pesel) {

        int length = pesel.length();

        // the pesel is shorter than eleven characters
        if (length < 11) {
            return false;
        }


        // the pesel is longer than eleven characters
        if (length > 11) {
            return false;
        }

        // divide the string into single characters
        String[] chars = pesel.split("");

        int[] numbers = new int[11];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.valueOf(chars[i]);
        }

        // multiply subsequent digits by appropriate weights and add to each other
        int sum = numbers[0] * 1 + numbers[1] * 3 + numbers[2] * 7 + numbers[3] * 9 + numbers[4] * 1 +
                numbers[5] * 3 + numbers[6] * 7 + numbers[7] * 9 + numbers[8] * 1 + numbers[9] * 3;

        // divide the result into modulo by ten
        sum = sum % 10;

        // subtract the result from ten
        sum = 10 - sum;

        // divide the result into modulo by ten
        sum = sum % 10;

        return sum == numbers[10];
    }


}
