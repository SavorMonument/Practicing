package StringCompression;

public class TimePassed {

    private long now;

    public TimePassed(){

        now = System.nanoTime();
    }

    public void reset(){

        now = System.nanoTime();
    }

    public int getPassedMili(){

        return (int)((System.nanoTime() - now) / 1e+6);
    }

    public int getPassedSecondsRounded(){

        return (int) getPassedSeconds();
    }

    public float getPassedSeconds(){

        return (float) ((System.nanoTime() - now) / 1e+9);
    }
}
