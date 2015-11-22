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
        item.setmPoints(853);
        item.setmRank(1);
        leaditems.add(item);

        LeaderItem item1 = new LeaderItem();
        item1.setmName("Himanshu");
        item1.setmPoints(40);
        item1.setmRank(2);
        leaditems.add(item1);

        LeaderItem item2 = new LeaderItem();
        item2.setmName("Arjun");
        item2.setmPoints(0);
        item2.setmRank(3);
        leaditems.add(item2);

        LeaderItem item3 = new LeaderItem();
        item3.setmName("Ramesh");
        item3.setmPoints(0);
        item3.setmRank(4);
        leaditems.add(item3);



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
