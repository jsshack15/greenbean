package com.example.swati.greenbean;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Swati on 22-11-2015.
 */
public class LeaderAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<LeaderItem> leadItems;
    private Context context;


    public LeaderAdapter(Context context,Activity activity, ArrayList<LeaderItem> leadItems) {
        this.context=context;
        this.activity = activity;
        this.leadItems = leadItems;
    }

    @Override
    public int getCount() {
        return leadItems.size();
    }

    @Override
    public Object getItem(int location) {
        return leadItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.leader_item, null);
        Log.d("LEAD_ADAPTER", "adapterview updating");

        TextView title = (TextView) convertView
                .findViewById(R.id.txtTitle);
        TextView points = (TextView) convertView.findViewById(R.id.txtPoints);
        TextView rank = (TextView) convertView.findViewById(R.id.rank);
        //ImageView img = (ImageView)convertView.findViewById(R.id.icon);


        LeaderItem item = leadItems.get(position);

        title.setText(item.getmName());
       points.setText(String.valueOf(item.getmPoints()));
        rank.setText(String.valueOf(item.getmRank()));



        return convertView;
    }

}

