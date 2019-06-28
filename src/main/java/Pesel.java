

public class Pesel {


    public boolean valid(String pesel) {

        int length = pesel.length();

        // pesel jest mniejszy niż 11 znaków czyli zbyt krótki
        if (length < 11) {
            return false;
        }


        // pesel jest większy niż 11 znaków czyli jest zbyt długi
        if (length > 11) {
            return false;
        }

        // dzielimy ciąg znaków na znaki
        String[] chars = pesel.split("");

        int[] numbers = new int[11];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.valueOf(chars[i]);
        }

        // przemnażamy kolejne cyfry przez odpowiednie wagi i dodajemy do siebie
        int sum = numbers[0] * 1 + numbers[1] * 3 + numbers[2] * 7 + numbers[3] * 9 + numbers[4] * 1 +
                numbers[5] * 3 + numbers[6] * 7 + numbers[7] * 9 + numbers[8] * 1 + numbers[9] * 3;

        // wynik dzielimy modulo przez 10
        sum = sum%10;

        // od dziesięciu odejmujemy wynik
        sum = 10 - sum;

        // wynik dzielimy modulo 10
        sum = sum%10;

        return sum == numbers[10];
    }


}
