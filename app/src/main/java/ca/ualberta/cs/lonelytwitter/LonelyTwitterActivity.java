/*
Copyright (c)2016 Team 20, CMPUT301, University of Alberta - All Rights Reserved
You may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the Code of Student Behavior.
You can find the copy of license at http://www.github/.....
For further information, contact me at email@email.ca
* */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * This is the main view class of LonelyTwitter project. <p> It handles all
 * user interactions as well as file manipulations. </p>
 * <pre> All the files are stored in the form of "json". Files stored in Emulator,
 * accessible from    device monitor. </pre>
 * <code> Pseudo code sample:
 * open someFile       <br>
 * attach some text...    <br>
 * close the file     <br>
 * </code>
 * <ul>
 *     <li>item</li>
 *     <li>another item</li>
 *     <li>some other item</li>
 * </ul>
 * @since 1.0
 * @see NormalTweet
 * @author Marc-Olivier Lajeunesse
 * */
public class LonelyTwitterActivity extends Activity {

	/**
	 * This is the fie name that is being saved / loaded and contains all the tweets.
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 *
	 * */

	private Activity activity = this;
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	private ArrayAdapter<Tweet> adapter;

	public ListView getOldTweetsList(){
		return oldTweetsList;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/* Create the save, or "Tweet" button. */
		Button saveButton = (Button) findViewById(R.id.save);
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                bodyText.setText("");

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		/* Clear all the tweets and their data. */
		Button clearButton = (Button) findViewById(R.id.clear);
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});


		oldTweetsList.setOnItemClickListener(new
				AdapterView.OnItemClickListener(){
					public void onItemClick(AdapterView<?> parent, View view, int position, long id){
						Intent intent = new Intent(activity , EditTweetActivity.class);
//						intent.putExtra("selectedTweet", (Serializable) adapter.getItem((int) id));
						Tweet selectedTweet = tweetList.get((int) id);
//						intent.putExtra("selectedTweet", (Serializable) tweetList.get((int) id));
						intent.putExtra("selectedTweet", tweetList.get((int) id).getMessage());
//						intent.putExtra("selectedTweet", tweetList.get((int) id).toString());
						startActivity(intent);
					}
				});

	}

	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method loads the tweets from FILE_NAME (file.save) into tweetList array list
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file. */
			tweetList = new ArrayList<Tweet>();
		}
	}

	/**
	 * This method opens the file FILE_NAME (file.sav), inserts the tweetList array list, and then closes the file
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			/* Rethrow. */
			throw new RuntimeException(e);
		} catch (IOException e) {
			/* Rethrow. */
			throw new RuntimeException(e);
		}
	}
}