package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malajeun on 9/13/16.
 */
public abstract class CurrentMood {
    private Date date;

    public CurrentMood(Date date){
        this.date = date;
    }
    public CurrentMood(){
        this.date = new Date();
    }

    public abstract String Mood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
