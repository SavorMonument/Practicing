package IMultiCoreProc;

public class MulticoreProcessing {

    public long fastestTime(long jobLength, int corePenalty, int[] speed, int[] cores) {

        long[] tTable = generateTimeTable(jobLength, speed, cores);
        addPenalty(tTable, corePenalty, cores);

        return pickSmallest(tTable);
    }

    private long pickSmallest(long[] table) {
        long min = table[0];

        for (int i = 1; i < table.length; i++) {

            if (table[i] < min)
                min = table[i];
        }

        return min;
    }


    private void addPenalty(long[] table, int corePenalty, int[] cores) {

        for (int i = 0; i < table.length; i++) {
            table[i] += corePenalty * (cores[i] - 1);
        }
    }

    private long[] generateTimeTable(long jobLength, int[] speed, int[] cores) {

        long[] tTable = new long[speed.length];

        for (int i = 0; i < speed.length; i++) {

            tTable[i] = generateTime(jobLength, cores[i], speed[i]);
        }

        return tTable;
    }

    private long generateTime(long jobLength, int core, int speed) {

        float job = jobLength / core;

        return (long) Math.ceil(job / (float) speed);
    }

}
