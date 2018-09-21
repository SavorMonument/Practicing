package Algorithms;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class BinaryCounter {

        public static int rank(int key, int[] a, Counter c)
        { // Array must be sorted.
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi)
            { // Key is in a[lo..hi] or not present.
                int mid = lo + (hi - lo) / 2;
                c.increment();
                if (key < a[mid])
                    hi = mid - 1;
                else
                    if (key > a[mid])
                        lo = mid + 1;
                    else
                        return mid;
            }
            return -1;
        }


        public static void main(String[] args)
        {
            int[] whitelist = In.readInts(args[0]);
            Counter count = new Counter("0");

            Arrays.sort(whitelist);
            while (!StdIn.isEmpty())
            { // Read key, print if not in whitelist.
                int key = StdIn.readInt();
                if (rank(key, whitelist, count) < 0) {
                    StdOut.println(String.format("Key = %d, keys examined: %d", key, count.tally()));
                    count = new Counter("0");
                }
            }
        }
}