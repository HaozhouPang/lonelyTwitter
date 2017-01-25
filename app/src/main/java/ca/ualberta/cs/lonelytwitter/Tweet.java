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


    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public abstract Boolean isImportant();



    ArrayList<Mood1> arraylist2 = new ArrayList<Mood1>();

    public void addMood(Mood1 mood){

        this.arraylist2.add(mood);
    }
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }



}
