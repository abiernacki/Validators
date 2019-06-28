public class NipValidator {

    public boolean valid(String nip) {

        int length = nip.length();

        // nip ma równo 15 znaków i pierwsze dwa znaki sa różne od "PL" czyli błąd
        if (length == 15 && !nip.substring(0, 2).equals("PL")) {
            return false;
        }

        // nip ma równo 15 znaków i pierwsze dwa znaki to "PL" czyli ok
        if (length == 15 && nip.substring(0, 2).equals("PL")) {
            nip = nip.substring(2, 15);
            if (nip.charAt(3) != '-' || nip.charAt(7) != '-' || nip.charAt(10) != '-') {
                return false;
            } else {
                nip = nip.replace("-", "");
                length = nip.length();
            }
        }

        // nip ma równo 13 znaków
        if (length == 13) {
            if (nip.charAt(3) != '-' || nip.charAt(7) != '-' || nip.charAt(10) != '-') {
                return false;
            } else {
                nip = nip.replace("-", "");
                length = nip.length();
            }
        }

        // nip jest mniejszy niz 10 znaków czyli zbyt krótki
        if (length < 10) {
            return false;
        }

        // nip jest większy niz 10 znaków czyli zbyt krótki
        if (length > 10) {
            return false;
        }


        // dzielimy ciag znaków na znaki
        String[] chars = nip.split("");

        int[] numbers = new int[10];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.valueOf(chars[i]);
        }

        // przemnażamy kolejne cyfry przez odpowiednie wagi i dodajemy do siebie
        int sum = numbers[0] * 6 + numbers[1] * 5 + numbers[2] * 7 + numbers[3] * 2 + numbers[4] * 3 + numbers[5] * 4 + numbers[6] * 5
                + numbers[7] * 6 + numbers[8] * 7;

        // wynik dzielimy modulo przez 11
        sum = sum % 11;

        // sprawdzamy czy wynikiem dzielenia modulo jest 10 bądź 11
        if (sum == 10 || sum == 11) {
            return false;
        }

        return sum == numbers[9];
    }
}
