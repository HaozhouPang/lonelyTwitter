package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Date;
/**
 * Created by PANG on 2017-01-17.
 */

public abstract class  Tweet implements Tweetable{
    private Date date;
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 144) {
            // todo throw new error here
            throw new TweetTooLongException();

        } else {
            this.message = message;
        }

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Tweet(String message, Date date) throws TweetTooLongException {
        this.setMessage(message);
        this.date = date;
    }

    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date();
    }

    public abstract Boolean isImportant();

    ArrayList<Mood1> arraylist = new ArrayList<Mood1>();
    public void addMood(Mood1 mood){
        this.arraylist.add(mood);
    }

}
