package com.example.swati.greenbean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PinActivity extends AppCompatActivity implements AbsListView.OnItemClickListener{
    ArrayList<PinItem> pinitems;
    ListView listView;
    PinAdapter listAdapter;
    final String TAG="PIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        listView = (ListView) findViewById(R.id.list);
        pinitems = new ArrayList<PinItem>();
        listAdapter = new PinAdapter(getApplicationContext(),this, pinitems);
        listView.setAdapter(listAdapter);
        PinItem item1=new PinItem();
        item1.setmCategory("Water");
        item1.setmTitle("Drivin' Dirty");
        item1.setmDescription("Skip washing your car or visit a carwash that uses reclaimed water!");
        item1.setmValue(5);
        listView.setOnItemClickListener(this);

        PinItem item3=new PinItem();
        item3.setmCategory("Energy");
        item3.setmTitle("Laptop Battery Saver");
        item3.setmDescription("Shut down your laptop when not in use!");
        item3.setmValue(5);


        PinItem item4=new PinItem();
        item4.setmCategory("Waste");
        item4.setmTitle("Reusable Mug");
        item4.setmDescription("Visit Starbucks or McDonalds and let them serve coffee in YOUR mug!");
        item4.setmValue(5);


        PinItem item5=new PinItem();
        item5.setmCategory("Transport");
        item5.setmTitle("Carpooling");
        item5.setmDescription("Take your friends to work, in your car, or tag along with them!");
        item5.setmValue(15);


        PinItem item2=new PinItem();
        item2.setmCategory("Water");
        item2.setmTitle("Shower Sprinter");
        item2.setmDescription("Pin it every time you shower less than 5 minutes!");
        item2.setmValue(5);


        PinItem item6=new PinItem();
        item6.setmCategory("Energy");
        item6.setmTitle("Lighten up");
        item6.setmDescription("Pin it every time you replace your power quelching CFLs with LEDs!");
        item6.setmValue(10);


        PinItem item7=new PinItem();
        item7.setmCategory("Waste");
        item7.setmTitle("Carry the carry bag");
        item7.setmDescription("Click on me every time you visit Shoppers' Stop or the like and turn down their plastic bags!");
        item7.setmValue(10);


        PinItem item8=new PinItem();
        item8.setmCategory("Transport");
        item8.setmTitle("Public Transport");
        item8.setmDescription("Pin it every time you take the metro or public transport to run errands!");
        item8.setmValue(20);


        PinItem item9=new PinItem();
        item9.setmCategory("Water");
        item9.setmTitle("Lunar Laundry");
        item9.setmDescription("Get an Energy Star washer, it'll be 37% more money-saving than others.");
        item9.setmValue(15);

        pinitems.add(item1);
        pinitems.add(item2);
        pinitems.add(item9);
        pinitems.add(item3);
        pinitems.add(item6);
        pinitems.add(item4);
        pinitems.add(item7);
        pinitems.add(item5);
        pinitems.add(item8);
        listAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pin, menu);
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        PinItem temp = new PinItem(pinitems.get(position));
        //temp.setCategory(fee);

        Log.d(TAG,temp.getmTitle());
        Toast.makeText(getApplication(), "+"+temp.getmValue()+" points added!", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
