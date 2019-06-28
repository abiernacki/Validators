public class EanValidator {

    public boolean valid(String ean) {

        int length = ean.length();

        if (length < 14) {
            return false;
        }

        if (length > 14) {
            return false;
        }

        // dzielimy ciąg znaków na znaki
        String[] chars = ean.split("");


        // przemnażamy kolejne cyfry przez odpowiednie wagi i dodajemy do siebie
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

        // dodajemy liczby mnożone przez 3 i liczby mnożone przez 1
        int sum = sum1 + sum2;

        // wynik dzielimy modulo przez 10
        sum = sum % 10;

        // od dziesięciu odejmujemy wynik
        sum = 10 - sum;

        return sum == numbers[13];

    }
}
