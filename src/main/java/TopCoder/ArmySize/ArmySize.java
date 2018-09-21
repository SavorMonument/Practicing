package TopCoder.ArmySize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmySize {

    private static HashMap<String, Range> QUALIFIERS;

    public ArmySize(){

        QUALIFIERS = new HashMap<>();

        QUALIFIERS.put("Few", new Range(1, 4));
        QUALIFIERS.put("Several", new Range(5, 9));
        QUALIFIERS.put("Pack", new Range(10, 19));
        QUALIFIERS.put("Lots", new Range(20, 49));
        QUALIFIERS.put("Horde", new Range(50, 99));
        QUALIFIERS.put("Throng", new Range(100, 249));
        QUALIFIERS.put("Swarm", new Range(250, 499));
        QUALIFIERS.put("Zounds", new Range(500, 999));
        QUALIFIERS.put("Legion", new Range(1000, Integer.MAX_VALUE));
    }

    public String[] getSum(String[] qualifiers){

        List<String> possibleSizesList = new ArrayList<>();

        if (!check(qualifiers))
            throw new IllegalArgumentException("Invalid qualifiers");

        Range armySizeRange = calculateArmyRange(qualifiers);

        for(Map.Entry<String, Range> entry: QUALIFIERS.entrySet()){

            if (containsRange(armySizeRange, entry.getValue()) || intersectsRange(armySizeRange, entry.getValue()))
                possibleSizesList.add(entry.getKey());
        }

        String[] pSizes = possibleSizesList.toArray(new String[0]);

        return pSizes;
    }

    private Range calculateArmyRange(String[] qual) {

        Range range = new Range(0,0);

        for (String q: qual){

            Range tempRage = QUALIFIERS.get(q);
            range.l += tempRage.l;
            range.r += tempRage.r;
        }

        return range;
    }

    private boolean containsRange(Range big, Range small){

        if ((big.l < small.l) && (big.r > small.r))
            return true;

        return false;
    }

    private boolean intersectsRange(Range big, Range small){

        if (small.isContained(big.l) || small.isContained(big.r))
            return true;

        return false;
    }

    private boolean check(String[] qual){

        for(String q: qual){
            if (null == QUALIFIERS.get(q))
                return false;
        }

        return true;
    }

    private class Range{

        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public boolean isContained(int value){

            return ((value >= l) && (value <= r));
        }

        public int l;
        public int r;
    }
}
