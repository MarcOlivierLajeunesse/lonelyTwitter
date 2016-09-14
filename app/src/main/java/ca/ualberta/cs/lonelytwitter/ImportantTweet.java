package ca.ualberta.cs.lonelytwitter;

/**
 * Created by malajeun on 9/13/16.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet(String message){
        super(message);
    }

    @Override
    // @Overide doesn't do anything, but it indicates that the following method overides the parent's method
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
