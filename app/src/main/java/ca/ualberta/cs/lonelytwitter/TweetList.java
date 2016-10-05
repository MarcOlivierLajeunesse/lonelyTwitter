package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Date;

/**
 * This class holds and maintains a list of Tweet objects.
 * @see Tweet
 * @see NormalTweet
 * @see ImportantTweet
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * adds a Tweet object to the Tweet List
     * @throws IllegalArgumentException
     * @param tweet is a tweet objects
     */
    public void add(Tweet tweet) {
        if(this.hasTweet(tweet)) {
            throw new IllegalArgumentException("duplicate tweet");
        }
        else
            tweets.add(tweet);
        
    }

    /**
     * Determines if a Tweet object is present in the list.
     * @param tweet Tweet object
     * @return true if tweet is present. false otherwise
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets the Tweet object at index i
     * @param i index of desired Tweet
     * @return Tweet at index i
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Removes the indicated Tweet object for the Tweet list.
     * @param a Tweet object to be removed
     */
    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }

    /**
     * gets the number of elements in the Tweet list.
     * @return the number of Tweet in the list
     */
    public int getCount() {
        return tweets.size() ;
    }

    /**
     * Makes a copy of the Tweet list, then sorts it in chronological order, then returns the sorted list.
     * @return a list of tweets.
     */
    public List<Tweet> getTweets(){
        List<Tweet> chronoTweets = new ArrayList<Tweet>(tweets);
        //chronoTweets = tweets;
        // comparator based on code from stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
        Collections.sort(chronoTweets, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return chronoTweets;
    }
}
