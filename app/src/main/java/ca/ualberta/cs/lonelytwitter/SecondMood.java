package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malajeun on 9/13/16.
 */
public class SecondMood extends CurrentMood {
    private String mood = "hungry";
    public SecondMood(Date date){
        super(date);
    }
    public SecondMood(){
    }
    public String Mood(){
        return mood;
    }

}
