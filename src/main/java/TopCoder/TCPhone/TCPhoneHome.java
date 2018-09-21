package TopCoder.TCPhone;

import java.util.Arrays;

public class TCPhoneHome {

    long validNumbers(int digits, String[] specialPrefixes){

        long validNumbersAmount = (long) Math.pow(10, digits);

        if (specialPrefixes.length != 0){
            replaceOverlapsInArray(specialPrefixes);

            for (String s: specialPrefixes){
                if (!s.equals("-1"))
                    validNumbersAmount -= (long) Math.pow(10, digits - s.length());
            }
        }

        return validNumbersAmount;
    }

    private void replaceOverlapsInArray(String[] specialPrefixes) {

        Arrays.sort(specialPrefixes);

        for (int i = specialPrefixes.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (isPrefix(specialPrefixes[i], specialPrefixes[j])) {
                    specialPrefixes[i] = "-1";
                }
            }
        }
    }

    public boolean isPrefix(String str, String prefix){

        if (str.length() < prefix.length())
            return false;

        for (int i = 0; i < prefix.length(); i++) {
            if (str.charAt(i) != prefix.charAt(i))
                return false;
        }

        return true;
    }

}
