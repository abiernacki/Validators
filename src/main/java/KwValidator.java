public class KwValidator {

    // tworzymy tablicę znaków jakie mogą znaleźć się w księdze, każdy w odpowiednim indeksie
    char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y', 'Z'};

    public boolean valid(String kw) {
        if(kw == null) {
            return false;
        }

        int length = kw.length();

        // numer księgi jest mniejszy niż 15 znaków czyli zbyt krótki
        if (length < 15) {
            return false;
        }


        // numer księgi wieczystej jest większy niż 15 znaków, czyli zbyt długi
        if (length > 15) {
            return false;
        }

        // nie ma separatorów na swoich miejscach, czyli błąd
        if (kw.charAt(4) != '/' || kw.charAt(13) != '/') {
            return false;
        }

        // brak liter w odpowiednich miejscach numeru księgi, czyli błąd
        if (decoding(kw.charAt(0)) < 10 || decoding(kw.charAt(1)) < 10 || decoding(kw.charAt(3)) < 10) {
            return false;
        }

        // brak cyfry w odpowiednim miejscu w księdze, czyli błąd
        if (decoding(kw.charAt(2)) >= 10) {
            return false;
        }

        // nie ma odpowiednich znaków we właściwych miejscach w numerze księgi, czyli błąd
        for (int i = 5; i < 13; i++) {
            if (decoding(kw.charAt(i)) >= 10) {
                return false;
            }
        }

        //przemnażamy kolejne cyfry przez odpowiednie wagi i dodajemy do siebie
        int sum = 1 * decoding(kw.charAt(0)) + 3 * decoding(kw.charAt(1)) + 7 * decoding(kw.charAt(2))
                + 1 * decoding(kw.charAt(3)) + 3 * decoding(kw.charAt(5)) + 7 * decoding(kw.charAt(6))
                + 1 * decoding(kw.charAt(7)) + 3 * decoding(kw.charAt(8)) + 7 * decoding(kw.charAt(9))
                + 1 * decoding(kw.charAt(10)) + 3 * decoding(kw.charAt(11)) + 7 * decoding(kw.charAt(12));

        // dzielimy modulo przez 10
        sum = sum % 10;

        //porównujemy wynik z oststanią cyfrą z kw
        return sum == decoding(kw.charAt(14));
    }

    //metoda zamieniająca znak w numerze księgi na odpowiednią liczbę
    public int decoding(char decode) {

        for (int i = 0; i < chars.length; i++) {
            if (decode == chars[i]) {
                return i;
            }
        }
        return -1;
    }
}
