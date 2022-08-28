package com.codepath.apps.restclienttemplate.models;

import androidx.room.Embedded;

import java.util.ArrayList;
import java.util.List;

public class TweetWithUser {

    //@Embedded notations flattens the properties of the User object into the object, preserving encapsulation
    @Embedded
    User user;

    @Embedded(prefix = "tweet_")
    Tweet tweet;

    public static List<Tweet> getTweetList(List<TweetWithUser> tweetWithUser) {
        List<Tweet> tweets = new ArrayList<>();
        for(int i = 0; i < tweetWithUser.size(); i++){
            Tweet tweet = tweetWithUser.get(i).tweet;
            tweet.user = tweetWithUser.get(i).user;
            tweets.add(tweet);
        }
        return tweets;
    }
}
