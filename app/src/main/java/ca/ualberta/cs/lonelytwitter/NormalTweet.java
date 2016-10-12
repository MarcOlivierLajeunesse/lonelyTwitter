package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

/**
 * this class is a subclass of Tweet. it differs from Important tweet in that isImportant return false.
 * @see Tweet
 * @see ImportantTweet
 * @see #isImportant()
 */
public class NormalTweet extends Tweet implements Tweetable, Serializable {
    /**
     * this constructor makes the normal tweet object.
     * @param message this parameter is the string for the tweet.
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * this constructor make the normal tweet object
     * @param message this parameter is the string for the tweet.
     * @param date this parameter is the date for the tweet.
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    /**
     * this method return a Boolean, FALSE, as the tweet is not an important tweet
     */
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
