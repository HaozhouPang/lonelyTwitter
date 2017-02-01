package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view class <br> In this class, user interaction
 * and file manipulation is performed.
 * all files are in the form of "json: files that are stored in Emulator;s accessible from
 * Android Device Monitor.
 * <pre>
 * 	pre-formatted text: <br>
 * 		file Explorer -> data -> data -> ca.ualberta.cs.lonelytweeter ->fles -> file.save
 * </pre>
 * <code> begin <br>
 * some pseudo code <br>
 * end </code>
 * This file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant
 * <ul>
 * <ol>
 * <li> item1 </li>
 * <li> item2 </li>
 * <li> item3 </li>
 * </ol>
 *
 * @version 1.0
 * @authur haozhou
 * @@see Tweet
 * @since 0.5
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are stored there, the format of file is JSON
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */


	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {
		/**
		 * Date ascending tweet list ordering.
		 */
		DATE_ASCENDING, /**
		 * Date descending tweet list ordering.
		 */
		DATE_DESCENDING, /**
		 * Text ascending tweet list ordering.
		 */
		TEXT_ASCENDING, /**
		 * Text descending tweet list ordering.
		 */
		TEXT_DESCENDING}
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);

		Button clearButton = (Button) findViewById(R.id.clear);

		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		try {
			Tweet tweet = new NormalTweet("First tweet");
			tweet.setMessage("hello");
			ImportantTweet importanttweet = new ImportantTweet("very important");
			importanttweet.getDate();
			NormalTweet normalTweet = new NormalTweet("I'm normal");

			ArrayList<Tweet> arraylist = new ArrayList<Tweet>();
			arraylist.add(tweet);
			arraylist.add((Tweet) importanttweet);
			arraylist.add(normalTweet);

		} catch (TweetTooLongException e) {
			e.printStackTrace();
		}

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();


				text = trimExtraSpace(text);


				Tweet tweet = new NormalTweet(text);


				tweetList.add(tweet);
//adapter.add(tweetList);
				adapter.notifyDataSetChanged();
				saveInFile();


//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();

			}
		});
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//setResult(RESULT_OK);
				//String text = bodyText.getText().toString();

				//Tweet tweet = new NormalTweet(text);


				tweetList.clear();
//adapter.add(tweetList);
				adapter.notifyDataSetChanged();
				saveInFile();


//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		//tweetList = new ArrayList<Tweet>();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}


	/**
	 *This method trims extra spaces using regular expression
	 * @param inputString string that needs to be cleared of extra spaces
	 * @return string
     */
	private String trimExtraSpace (String inputString){
		inputString = inputString.replaceAll("\\s+", " ");
		return inputString;
	}


	/**
	 * This method sorts the items in tweet list and refreshes the adapter.
	 * @param ordering to be used.
     */
	private void sortTweetListItems(TweetListOrdering ordering){

	}

	/**
	 * Loads tweets from specified file
	 *
	 * @throws TweetTooLongException if the tweet is too long.
	 * @exception FileNotFoundException if the file is not created first.
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>() {}.getType());

			fis.close();



		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * save tweets into a specified file in JSON format.
	 * @throws FileNotFoundException if file is not created.
	 */

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();

			gson.toJson(tweetList, out);

			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}