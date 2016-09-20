package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malajeun on 9/13/16.
 */
public class FirstMood extends CurrentMood {
    private String mood = "happy";
    public FirstMood(Date date){
        super(date);
    }
    public FirstMood(){
    }
    public String Mood(){
        return mood;
    }

}
