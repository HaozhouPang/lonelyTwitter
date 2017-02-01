package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by PANG on 2017-01-17.
 */
public abstract class Mood1 {
    private Date date;
    private String currentMood;


    /**
     * Instantiates a new Mood 1.
     *
     * @param currentMood the current mood
     */
    public Mood1(String currentMood) {
        this.currentMood = currentMood;
        this.date = new Date();
    }

    /**
     * Instantiates a new Mood 1.
     *
     * @param date        the date
     * @param currentMood the current mood
     */
    public Mood1(Date date, String currentMood) {
        this.date = date;
        this.currentMood = currentMood;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets current mood.
     *
     * @param currentMood the current mood
     */
    public void setCurrentMood(String currentMood) {
        this.currentMood = currentMood;
    }
}
