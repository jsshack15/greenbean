package com.example.swati.greenbean;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class LeaderActivity extends AppCompatActivity {
    ArrayList<LeaderItem> leaditems;
    ListView listView;
    LeaderAdapter listAdapter;
    final String TAG="PIN_ACTIVITY";
    private SQLiteHandler db;
    private SessionManager session;
    private LeaderItem temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());
        Log.d("LEAD ACTIVITY", session.getKeyEmail());


        listView = (ListView) findViewById(R.id.list);
        leaditems = new ArrayList<LeaderItem>();
        listAdapter = new LeaderAdapter(getApplicationContext(),this, leaditems);
        listView.setAdapter(listAdapter);
        LeaderItem item = new LeaderItem();
        item.setmName("Swati");
        item.setmPoints(100);
        item.setmRank(1);
        leaditems.add(item);
        listAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leader, menu);
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
