package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by PANG on 2017-01-17.
 */

public class Mood2 extends Mood1 {
    public String Mood() {
        return currentMood;
    }

    public Mood2(String currentMood) {
        super(currentMood);
    }

    public Mood2(Date date, String currentMood) {
        super(date, currentMood);
    }
}
