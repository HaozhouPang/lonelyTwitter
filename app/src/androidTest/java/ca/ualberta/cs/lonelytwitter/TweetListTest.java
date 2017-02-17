/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;

import java.util.ArrayList;

/**
 * Created by PANG on 2017-02-16.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super (LonelyTwitterActivity.class);
    }


    public void testAddTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet= new NormalTweet("some tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet= new NormalTweet("some tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet= new NormalTweet("some tweet");

        tweets.add(tweet);
        NormalTweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());

    }
    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet= new NormalTweet("some tweet");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));

    }

    public void testDuplicate(){
        TweetList tweets = new TweetList();
        NormalTweet tweet= new NormalTweet("some tweet");


        try{
            tweets.add(tweet);
            tweets.add(tweet);
            fail();
        }
        catch (Exception e){
            assertEquals(e instanceof IllegalArgumentException, true);
        }


    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        NormalTweet tweet1= new NormalTweet("some tweet 1");
        NormalTweet tweet2= new NormalTweet("some tweet 2");
        NormalTweet tweet3= new NormalTweet("some tweet 3");
        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);

        ArrayList<NormalTweet> testList = new ArrayList<NormalTweet>();
        testList.add(tweet1);
        testList.add(tweet2);
        testList.add(tweet3);

        assertEquals(testList, tweets.getTweets());

    }


    public void testGetCount(){
        TweetList tweets = new TweetList();
        NormalTweet tweet= new NormalTweet("some tweet");
        tweets.add(tweet);

        int count = tweets.getCount();
        assertEquals(count,1);
    }

    public void testHasTweet2(){
        TweetList tweets = new TweetList();
        NormalTweet tweet= new NormalTweet("some tweet");

        assertFalse(tweets.hasTweet2(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet2(tweet));

    }

}

   /** addTweet() -- should throw an IllegalArgumentException when one tries to add a duplicate tweet
        getTweets() -- should return a list of tweets in chronological order
        hasTweet() -- should return true if there is a tweet that equals() another tweet
        getCount() -- should accurately count up the tweets
*/
