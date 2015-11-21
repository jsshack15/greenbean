package com.example.swati.greenbean;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Swati on 21-11-2015.
 */
public class PinAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<PinItem> pinItems;
    private Context context;


    public PinAdapter(Context context,Activity activity, ArrayList<PinItem> pinItems) {
        this.context=context;
        this.activity = activity;
        this.pinItems = pinItems;
    }

    @Override
    public int getCount() {
        return pinItems.size();
    }

    @Override
    public Object getItem(int location) {
        return pinItems.get(location);
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
            convertView = inflater.inflate(R.layout.pin_item, null);
        Log.d("SEARCH_ADAPTER", "adapterview updating");

        TextView title = (TextView) convertView
                .findViewById(R.id.txtTitle);
        TextView description = (TextView) convertView.findViewById(R.id.txtDes);
        ImageView img = (ImageView)convertView.findViewById(R.id.icon);

        String uri_water = "@drawable/img_water";
        int imageResourceGreen = context.getResources().getIdentifier(uri_water, null, context.getPackageName());
        Drawable reswater = context.getResources().getDrawable(imageResourceGreen);

        String uri_transport = "@drawable/img_transport";
        int imageResourceTrans = context.getResources().getIdentifier(uri_transport, null, context.getPackageName());
        Drawable restrans = context.getResources().getDrawable(imageResourceTrans);

        String uri_waste = "@drawable/img_waste";
        int imageResourceWaste = context.getResources().getIdentifier(uri_waste, null, context.getPackageName());
        Drawable reswaste = context.getResources().getDrawable(imageResourceWaste);

        String uri_energy = "@drawable/img_energy";
        int imageResourceEne = context.getResources().getIdentifier(uri_energy, null, context.getPackageName());
        Drawable resene = context.getResources().getDrawable(imageResourceEne);


        PinItem item = pinItems.get(position);

        title.setText(item.getmTitle());
        description.setText(item.getmDescription());
        if(item.getmCategory().equals("Water")==true)
            img.setImageDrawable(reswater);
        else if(item.getmCategory().equals("Transport")==true)
            img.setImageDrawable(restrans);
        else if(item.getmCategory().equals("Energy")==true)
            img.setImageDrawable(resene);
        else if(item.getmCategory().equals("Waste")==true)
            img.setImageDrawable(reswaste);



        return convertView;
    }

}
