public class RegonValidator {

    public boolean valid(String regon) {

        int length = regon.length();

        //regon jest różny od liczby 9 i 14 czyli niewłaściwy
        if (length != 9 && length != 14) {
            return false;
        }

        // dzielimy ciąg znaków na znaki
        String[] chars = regon.split("");


        // sprawdzamy regon 9-cio cyfrowy
        if (chars.length == 9) {
            int[] numbers = new int[9];
            for (int i = 0; i < chars.length; i++) {
                numbers[i] = Integer.valueOf(chars[i]);
            }

            //  przemnażamy kolejne cyfry przez odpowiednie wagi i dodajemy do siebie
            int sum9 = numbers[0] * 8 + numbers[1] * 9 + numbers[2] * 2 + numbers[3] * 3 + numbers[4] * 4 +
                    numbers[5] * 5 + numbers[6] * 6 + numbers[7] * 7;

            // wynik dzielimy modulo przez 11 i sprawdzamy czy wyszło 10
            sum9 = sum9 % 11;

            if(sum9 == 10){
                sum9 = 0;
            }



            return sum9 == numbers[8];

            // sprawdzamy regon 14-sto cyfrowy
        }


        if (chars.length == 14) {
            int[] numbers = new int[14];
            for (int i = 0; i < chars.length; i++) {
                numbers[i] = Integer.valueOf(chars[i]);
            }

            //  przemnażamy pierwsze 8 cyfr przez odpowiednie wagi i dodajemy do siebie
            int sum9 = numbers[0] * 8 + numbers[1] * 9 + numbers[2] * 2 + numbers[3] * 3 + numbers[4] * 4 +
                    numbers[5] * 5 + numbers[6] * 6 + numbers[7] * 7;
            sum9 = sum9 % 11;

            // sprawdzamy poprawność pierwszej części regonu
            if (sum9 == numbers[8]) {

                //  przemnażamy wszystkie cyfry przez odpowiednie wagi i dodajemy do siebie
                int sum14 = numbers[0] * 2 + numbers[1] * 4 + numbers[2] * 8 + numbers[3] * 5 +
                        numbers[4] * 0 + numbers[5] * 9 + numbers[6] * 7 + numbers[7] * 3 +
                        numbers[8] * 6 + numbers[9] * 1 + numbers[10] * 2 + numbers[11] * 4 + numbers[12] * 8;

                // wynik dzielimy modulo przez 11 i sprawdzamy czy wyszło 10
                sum14 = sum14 % 11;

                if(sum14 == 10){
                    sum14 = 0;
                }


                return sum14 == numbers[13];
            } else {

                return false;
            }
        }
        return false;
    }
}


