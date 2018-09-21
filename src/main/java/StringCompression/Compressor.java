package StringCompression;

import java.io.*;
import java.sql.Array;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedList;

public class Compressor {

    public static String compressStringBuilder(String text){

        StringBuilder compressedText = new StringBuilder(text);

        for(int i = 0; i < compressedText.length() - 1; i++) {

            int char_count = howManyConsecutiveChars(compressedText.toString(), i);
            if (char_count > 1) {
                int offset = i + 1;
                int char_count_digits = Integer.toString(char_count).length();
                compressedText = compressedText.insert(offset, char_count);
                compressedText.delete(offset + char_count_digits, offset + char_count);
            }
        }

        return compressedText.toString();
    }

    public static char[] compressStringCharArray(char[] compressedText){

        int length = compressedText.length;

        for(int i = 0; i < length - 1; i++) {

            int char_count = howManyConsecutiveChars(compressedText, i, length);
            if (char_count > 1) {

                int offset = i + 1;
                char[] digits = Integer.toString(char_count).toCharArray();

                //Copy the number of consecutive chars to array
                System.arraycopy(digits, 0, compressedText, offset, digits.length);

                offset += char_count - 1;
                //Copy over the consecutive chars
                System.arraycopy(compressedText, offset, compressedText,
                        i + 1 + digits.length, compressedText.length - offset);

                length = length - (char_count - digits.length - 1);
            }
        }

        //Trim the array to size
        char[] tempText = new char[length];
        System.arraycopy(compressedText, 0, tempText, 0, length);

        return tempText;
    }

    public static String compressString(String text){

        for(int i = 0; i < text.length() - 1; i++) {

            int char_count = howManyConsecutiveChars(text, i);
            if (char_count > 1) {
                text = text.substring(0, i + 1) + Integer.toString(char_count) +
                        text.substring(i + char_count);
            }
        }

        return text;
    }

    public static String compressStringQ(String text){

        for(int i = 0; i < text.length() - 1; i++) {

            int char_count = howManyConsecutiveChars(text, i);
            if (char_count > 1) {

                String temp_text;

                temp_text = text.substring(0, i + 1);
                temp_text += Integer.toString(char_count);
                temp_text += text.substring(i + char_count);

                text = temp_text;
            }
        }

        return text;
    }

    public static String compressStringFormatter(String text){

        for(int i = 0; i < text.length() - 1; i++) {

            int char_count = howManyConsecutiveChars(text, i);
            if (char_count > 1) {
                text = String.format("%s%d%s", text.substring(0, i + 1), char_count,
                        text.substring(i + char_count));
            }
        }

        return text;
    }

    public static String compressStringMessageFormatter(String text){

        for(int i = 0; i < text.length() - 1; i++) {

            int char_count = howManyConsecutiveChars(text, i);
            if (char_count > 1) {
                text = MessageFormat.format("{0}{1}{2}", text.substring(0, i + 1), char_count,
                        text.substring(i + char_count));
            }
        }

        return text;
    }

    private static int howManyConsecutiveChars(String text, int index) {

        int j = index;

        while ((j < text.length()) && (text.charAt(j) == text.charAt(index)))
            j += 1;

        return j - index;
    }

    private static int howManyConsecutiveChars(char[] text, int index, int bound) {

        int j = index;

        while ((j < bound) && (text[j] == text[index]))
            j += 1;

        return j - index;
    }


    public static void main(String[] args) {

        TimePassed tp = new TimePassed();
        StringBuilder sBuilder = readFromFile("resources/big_string.txt");
        String text;

//        tp.reset();
//        Compressor.compressStringBuilder(text);
//        System.out.println(String.format("StringBuilder test sec: %.2f\n", tp.getPassedSeconds()));

        text = sBuilder.toString();
        tp.reset();
        Compressor.compressString(text);
        System.out.println(String.format("String test sec: %.2f\n", tp.getPassedSeconds()));

        text = sBuilder.toString();
        tp.reset();
        Compressor.compressStringQ(text);
        System.out.println(String.format("String QQQ test sec: %.2f\n", tp.getPassedSeconds()));

        text = sBuilder.toString();
        char[] charText = text.toCharArray();

        tp.reset();
        Compressor.compressStringCharArray(charText);
        System.out.println(String.format("String char array test sec: %.2f\n", tp.getPassedSeconds()));

//        tp.reset();
//        Compressor.compressStringFormatter(text);
//        System.out.println(String.format("String with formatter test sec: %.2f\n", tp.getPassedSeconds()));

        text = sBuilder.toString();
        tp.reset();
        Compressor.compressStringMessageFormatter(text);
        System.out.println(String.format("String with message formatter test sec: %.2f\n", tp.getPassedSeconds()));
    }

    private static StringBuilder readFromFile(String path) {

        StringBuilder sBuilder = new StringBuilder();

        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(path)),"utf-8"))){

            while (bReader.ready())
                sBuilder.append(bReader.readLine()).append('\n');

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1){
            e1.printStackTrace();
        } catch (IOException e2){
            e2.printStackTrace();
        }

        return sBuilder;
    }
}
