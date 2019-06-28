public class IsbnValidator {

    public boolean valid(String isbn) {

        try {
            int length = isbn.length();

            // nip ma równo 13 znaków
            if (length == 13) {
                isbn = isbn.replace("-", "");
                length = isbn.length();
            }

            // nip ma równo 15 znaków
            if (length == 15) {
                isbn = isbn.substring(0, 10);
                length = isbn.length();
            }

            // nip ma równo 19 znaków
            if (length == 19) {
                isbn = isbn.replaceAll("(-| )", "");
                isbn = isbn.substring(0, 10);
                length = isbn.length();
            }

            // isbn jest mniejszy niz 10 znaków czyli zbyt krótki
            if (length < 10) {
                return false;
            }

            // isbn jest większy niz 10 znaków czyli zbyt krótki
            if (length > 10) {
                return false;
            }


            // dzielimy ciag znaków na znaki
            String[] chars = isbn.split("");

            int[] numbers = new int[10];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i].equals("X")) {
                    chars[i] = "111";
                }
                numbers[i] = Integer.valueOf(chars[i]);
            }

            // przemnażamy kolejne cyfry przez odpowiednie wagi i dodajemy do siebie
            int sum = numbers[0] * 10 + numbers[1] * 9 + numbers[2] * 8 + numbers[3] * 7 + numbers[4] * 6 + numbers[5] * 5 + numbers[6] * 4
                    + numbers[7] * 3 + numbers[8] * 2;

            // wynik dzielimy modulo przez 11
            sum = sum % 11;

            // wynik odejmujemy od 11
            sum = 11 - sum;

            // znowu dzielimy modulo przez 11
            sum = sum % 11;

            if (sum == 10) {
                sum = 111;
            }

            return sum == numbers[9];

        }catch (NumberFormatException e){
            return false;
        }
    }
}
