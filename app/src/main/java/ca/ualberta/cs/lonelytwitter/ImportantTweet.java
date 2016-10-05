package ca.ualberta.cs.lonelytwitter;
/**
 * This class is a subclass of Tweet. it differs from Normal tweet in that isImportant return True.
 * @see Tweet
 * @see NormalTweet
 * @see #isImportant()
 */
public class ImportantTweet extends Tweet {

    /**
     * this constructor makes the normal tweet parameter.
     * @param message this parameter is the string for the tweet.
     */
    public ImportantTweet(String message){
        super(message);
    }

    @Override
    /**
     * this method return a Boolean, FALSE, as the tweet is not an important tweet
     */
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
