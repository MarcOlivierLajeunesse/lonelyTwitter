package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    private TextView tweetTextView;
    private Tweet currentTweet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        tweetTextView = (TextView) findViewById(R.id.editTweetView);
        Intent intent = getIntent();
//        currentTweet = (Tweet) intent.getSerializableExtra("currentTweet");
//        String text = currentTweet.getMessage();
        String text = (String) intent.getStringExtra("selectedTweet");
        tweetTextView.setText(text);


    }
}
