package com.example.swati.greenbean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Greenometer extends AppCompatActivity {
    private SQLiteHandler db;
    private SessionManager session;
    private final String TAG="GEENOMETER";
    TextView mwater,mwaste,menergy,mtransport,mtotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greenometer);
        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());
        mwater=(TextView)findViewById(R.id.switcher_water);
        mwaste=(TextView)findViewById(R.id.switcher_waste);
        menergy=(TextView)findViewById(R.id.switcher_energy);
        mtransport=(TextView)findViewById(R.id.switcher_transport);
        mtotal=(TextView)findViewById(R.id.total);
        // session manager
        session = new SessionManager(getApplicationContext());

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_GETPOINT, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "getpoint Response: " + response.toString());
                //hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    Log.d(TAG,"SUCCESSFUL response");
                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session
                        // Now store the user in SQLite
                        String water = jObj.getString("water");
                        String waste= jObj.getString("waste");
                        String energy= jObj.getString("energy");
                        String transport= jObj.getString("transport");
                        int sum=Integer.parseInt(water)+Integer.parseInt(waste)+Integer.parseInt(energy)+Integer.parseInt(transport);
                        mwater.setText(water);
                        mwaste.setText(waste);
                        menergy.setText(energy);
                        mtransport.setText(transport);
                        mtotal.setText(String.valueOf(sum));


                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                //hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", session.getKeyEmail());
                //params.put("password", password);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, "getpoint req");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_greenometer, menu);
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
