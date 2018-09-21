package PPerlas;

public class RVector {

    public static String rotate(String str, int n) {

        while(n != 0){
            char c = str.charAt(0);
            str = str.substring(1, str.length()) + c;
            n--;
        }

        return str;
    }

    public static String rotateV2(String str, int n) {

        n = n % str.length();

        StringBuilder sBuilder = new StringBuilder(str.toString());
        StringBuilder subBuilder = new StringBuilder(sBuilder.subSequence(n, sBuilder.length()));

        sBuilder = subBuilder.append(sBuilder.subSequence(0, n));

        return sBuilder.toString();
    }

    public static String rotateV3(String str, int n) {

        n = n % str.length();

        StringBuilder sBuilder = new StringBuilder();

        sBuilder.append(str.substring(n, str.length()));
        sBuilder.append(str.substring(0, n));

        return sBuilder.toString();
    }
}
