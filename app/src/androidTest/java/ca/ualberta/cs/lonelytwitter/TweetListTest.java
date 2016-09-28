package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Marco on 27-Sep-2016.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void  testAddTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("hello");
        Tweet b = new NormalTweet("hi");

        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testDeleteTweet(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("hello");

        list.add(a);
        assertTrue(list.hasTweet(a));

        list.removeTweet(a);
        assertFalse(list.hasTweet(a));
    }

    public void testDuplicateTweet(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("hello");
        list.add(a);
        try{
            list.add(a);
            fail();
        } catch(IllegalArgumentException e){

        }
    }
    public void testCount(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("hello");
        Tweet b = new NormalTweet("hi");

        assertEquals(list.getCount(),0);
        list.add(a);
        assertEquals(list.getCount(),1);
        list.add(b);
        assertEquals(list.getCount(), 2 );
    }
    public void testGetTweetByDate(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("hello", new Date(5000));
        Tweet b = new NormalTweet("hi", new Date(20000));
        Tweet c = new NormalTweet("boo!", new Date(30000));
        list.add(b);
        list.add(c);
        list.add(a);

        List<Tweet> timedTweets = new ArrayList<Tweet>();
        timedTweets = list.getTweets();
        assertEquals(timedTweets.get(0), a);
        assertEquals(timedTweets.get(1), b);
        assertEquals(timedTweets.get(2), c);
        //check orriginal list
        assertEquals(list.getTweet(0),b);
        assertEquals(list.getTweet(1),c);
        assertEquals(list.getTweet(2),a);
    }

}
