package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Abstract class that defines Tweet. Parent class for NormalTweet and ImportantTweet. Maintains information contained in object.
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet {
    private String message;
    private Date date;

    /**
     * this constructor makes the tweet object.
     * @param message this parameter is the string for the tweet.
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * this constructor make the tweet object
     * @param message this parameter is the string for the tweet.
     * @param date this parameter is the date for the tweet.
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * abstract method that determines if the tweet is important or not.
     */
    public abstract Boolean isImportant();


    /**
     * sets message for the tweet object.
     * @param message message to be inserted into the Tweet object
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * sets a date for the Tweet object
     * @param date date to be set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * retrieves the Tweet's message
     * @return String message from Tweet
     */
    public String getMessage() {
        return message;
    }

    /**
     * retrieves the Tweet's date
     * @return Date date from Tweet
     */
    public Date getDate() {
        return date;
    }

    @Override
    /**
     * converts the tweet's message and date into Strings and formats them
     */
    public String toString(){
        return  date.toString() + " | " + message;
    }
}
