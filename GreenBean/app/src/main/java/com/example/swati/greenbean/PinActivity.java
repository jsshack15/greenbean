package com.example.swati.greenbean;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class PinActivity extends AppCompatActivity {
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
        pinitems.add(item1);
        PinItem item2=new PinItem();
        item2.setmCategory("Water");
        item2.setmTitle("Shower Sprinter");
        item2.setmDescription("Pin it every time you shower less than 5 minutes!");
        item2.setmValue(5);
        pinitems.add(item2);
        PinItem item3=new PinItem();
        item3.setmCategory("Energy");
        item3.setmTitle("Laptop Battery Saver");
        item3.setmDescription("Shut down your laptop when not in use!");
        item3.setmValue(5);
        pinitems.add(item3);
        listAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pin, menu);
        return true;
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
