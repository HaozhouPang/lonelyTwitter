package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by PANG on 2017-01-17.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
