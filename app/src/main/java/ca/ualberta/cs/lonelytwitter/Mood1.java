package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by PANG on 2017-01-17.
 */

public abstract class Mood1 {
    private Date date;
    private String currentMood;


    public Mood1(String currentMood) {
        this.currentMood = currentMood;
        this.date = new Date();
    }

    public Mood1(Date date, String currentMood) {
        this.date = date;
        this.currentMood = currentMood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCurrentMood(String currentMood) {
        this.currentMood = currentMood;
    }
}
