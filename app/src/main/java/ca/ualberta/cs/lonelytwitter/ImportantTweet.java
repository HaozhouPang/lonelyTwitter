package ca.ualberta.cs.lonelytwitter;

import android.text.BoringLayout;

import java.util.Date;

/**
 * Created by PANG on 2017-01-17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }
    public  Boolean isImportant(){
        return Boolean.TRUE;
    }
    @Override
    public String getMessage(){
        return super.getMessage() + " !!!";
    }
}
