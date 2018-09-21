package Algorithms;

import java.util.Arrays;

public class Josephus {

    public static int[] findOut(int n, int m){
        assert (m < n) : "M has to be smaller than n";

        int[] positions = new int[n];
        int alive = n;
        int i = m - 1;

        while (alive >= 1){

            if (positions[i] == 0) {
                alive -= 1;
                System.out.print((i + 1) + " ");
            }
            positions[i] += 1;

            i += m;
            if (i >= n)
                i -= n;
        }

        return positions;
    }

    static int josephus(int n, int k)
    {
        if (n == 1)
            return 1;
        else
    /* The position returned by josephus(n - 1, k)
    is adjusted because the recursive call
    josephus(n - 1, k) considers the original
    position k%n + 1 as position 1 */
            return (josephus(n - 1, k) + k-1) % n + 1;
    }

    public static void main(String[] args) {

        //System.out.println(Arrays.toString(findOut(7,2)));
        System.out.println(josephus(41, 3));
        //findOut(41, 3);
    }
}
