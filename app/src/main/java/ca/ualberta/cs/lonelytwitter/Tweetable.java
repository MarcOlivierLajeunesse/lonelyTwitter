package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * interface for Tweet object. sets it as tweetable
 * @see Tweet
 */
public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
