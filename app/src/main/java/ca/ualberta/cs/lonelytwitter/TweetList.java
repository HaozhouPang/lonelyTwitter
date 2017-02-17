/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ca.ualberta.cs.lonelytwitter;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by PANG on 2017-02-16.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

    public void add(NormalTweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);

    }

    public boolean hasTweet (Tweet tweet){
        return tweets.contains(tweet);

    }
    public NormalTweet getTweet(int index){
        //return new NormalTweet("not the tweet");
        return tweets.get(0);
    }

    public void delete(NormalTweet tweet){
        tweets.remove(tweet);
    }

    public int getCount(){
        return tweets.size();
    }

    public ArrayList getTweets(){
        return tweets;
    }
    public boolean hasTweet2(Tweet tweet){
        if (tweets.contains(tweet)){
            return true;
        }
        else {
            return false;
        }

    }
}
