package com.example.swati.greenbean;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

/**
 * Created by Swati on 21-11-2015.
 */
public class Twitterama extends ListFragment {
    private static final String ARG_PARAM="query";
    private String querystring="#sustainabledevelopment";
    public  static Twitterama newInstance(String param1) {
        Twitterama fragment = new Twitterama();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            querystring = getArguments().getString(ARG_PARAM);

        }

        String TAG="TWITTERAMA";
        Log.d(TAG, "inside twitterama");
        final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query(querystring)
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
                .setTimeline(searchTimeline)
                .build();
        /*final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("fabric")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
                .setTimeline(userTimeline)
                .build();*/
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.twitter_timeline, container, false);
    }
}


