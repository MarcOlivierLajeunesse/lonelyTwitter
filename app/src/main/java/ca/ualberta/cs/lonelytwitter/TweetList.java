package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Date;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        if(this.hasTweet(tweet)) {
            throw new IllegalArgumentException("duplicate tweet");
        }
        else
            tweets.add(tweet);
        
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }


    public int getCount() {
        return tweets.size() ;
    }

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
