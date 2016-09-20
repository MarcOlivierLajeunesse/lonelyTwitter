package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by malajeun on 9/13/16.
 */
public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<CurrentMood> moodList = new ArrayList<CurrentMood>();

    public Tweet(String message){
        this.message = message;
        this.date = new Date();

    }
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant(); // prototype

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do Something
            throw new TweetTooLongException();
        }
        this.message = message;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void addFirstMood(){
        FirstMood newFMood = new FirstMood(this.getDate());
        moodList.add(newFMood);
    }

    public void addSecondMood(){
        SecondMood newSMood = new SecondMood(this.getDate());
        moodList.add(newSMood);
    }

    public ArrayList<CurrentMood> getMoodList() {
        return moodList;
    }
    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }
}
