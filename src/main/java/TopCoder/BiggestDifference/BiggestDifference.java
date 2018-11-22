package TopCoder.BiggestDifference;

public class BiggestDifference {

    public static int findDifference(int[] numbers){

        int max = numbers[numbers.length - 1];
        int maxDiff = max - getSmallestInRange(numbers, 0, numbers.length - 1);

        for (int i = numbers.length - 2; i >= 1; i--) {

            if (numbers[i] > max){

                int tempDiff = numbers[i] - getSmallestInRange(numbers, 0, i);
                if (tempDiff > maxDiff) {
                    max = numbers[i];
                    maxDiff = tempDiff;
                }
            }
        }
        if (maxDiff <= 0)
            return -1;
        return maxDiff;
    }

    public static int getSmallestInRange(int[] numbers, int l, int r){
        assert (numbers.length >= r && l < r): "Empty array";

        int min = numbers[l];

        for (int i = l; i < r; i++) {

            if (numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }
}
