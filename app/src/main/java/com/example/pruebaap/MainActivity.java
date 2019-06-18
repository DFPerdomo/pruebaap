package com.example.pruebaap;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button positionsButton, matchesButton, searchPlayerButton, newsButton, inbButton;
    ListView nmListView;

    String nmItemsd[] = {"","","","","",""};
    String nmItemsh[] = {"","","","","",""};
    String nmItemsc[] = {"","","","","",""};
   int nmItemsf1 [];
   int nmItemsf2 [];
    String [] sizenmlist = {"1", "2", "3", "4", "5", "6"};
    //int[] nmItemsf1 = {R.drawable.japan, R.drawable.bolivia, R.drawable.brazil, R.drawable.colombia, R.drawable.argentina, R.drawable.uruguay};
    //int[] nmItemsf2 = {R.drawable.chile, R.drawable.peru, R.drawable.venezuela, R.drawable.qatar, R.drawable.paraguay, R.drawable.japan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        positionsButton = (Button) findViewById(R.id.posicionesButton);
        matchesButton = (Button) findViewById(R.id.matchButton);
        searchPlayerButton = (Button) findViewById(R.id.searchPlayerButton);
        newsButton = (Button) findViewById(R.id.newsButton);
        inbButton = (Button) findViewById(R.id.inbuton);
        nmListView = (ListView) findViewById(R.id.nmListView);
        nmListView.setAdapter(new AdapterListView(this, nmItemsd, nmItemsh, nmItemsc, nmItemsf1, nmItemsf2, sizenmlist));

        positionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent positions = new Intent(MainActivity.this, PositionsActivity.class);
                startActivity(positions);
            }
        });

        matchesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent matches = new Intent(MainActivity.this, MatchesActivity.class);
                startActivity(matches);
            }
        });

        searchPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(search);
            }
        });


        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(news);
            }
        });

        HttpClient client = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if (status.isSuccess()){
                    Gson gson = new GsonBuilder().create();
                    try {
                        JSONObject jsono = new JSONObject(status.getResult());
                        JSONArray jsonarray = jsono.getJSONArray("matches");
                        ArrayList<NmItem> matches = new ArrayList<NmItem>();
                        for(int i=0; i<jsonarray.length(); i++){
                            String match = jsonarray.getString(i);
                            //System.out.println(match);
                            NmItem nmItem = gson.fromJson(match,NmItem.class);
                            matches.add(nmItem);
                            System.out.println(nmItem.getDate());
                            System.out.println(nmItem.getHour());
                            System.out.println(nmItem.getCity());
                            System.out.println(nmItem.getFlag1());
                            System.out.println(nmItem.getFlag2());
                            nmItemsd [i] = nmItem.getDate();
                            nmItemsh [i] = nmItem.getHour();
                            nmItemsc [i] = nmItem.getCity();

                            switch (nmItem.getFlag1()){

                                case "col":
                                    nmItemsf1 [i] = R.drawable.colombia;
                                    break;
                                case "arg":
                                    nmItemsf1 [i] = R.drawable.argentina;
                                    break;
                                case "per":
                                    nmItemsf1 [i] = R.drawable.peru;
                                    break;
                                case "bol":
                                    nmItemsf1 [i] = R.drawable.bolivia;
                                    break;
                                case "par":
                                    nmItemsf1 [i] = R.drawable.paraguay;
                                    break;
                                case "bra":
                                    nmItemsf1 [i] = R.drawable.brazil;
                                    break;
                                case "ven":
                                    nmItemsf1 [i] = R.drawable.venezuela;
                                    break;
                                case "uru":
                                    nmItemsf1 [i] = R.drawable.uruguay;
                                    break;
                                case "chi":
                                    nmItemsf1 [i] = R.drawable.chile;
                                    break;
                                case "ecu":
                                    nmItemsf1 [i] = R.drawable.ecuador;
                                    break;
                                case "qat":
                                    nmItemsf1 [i] = R.drawable.qatar;
                                    break;
                                case "jap":
                                    nmItemsf1 [i] = R.drawable.japan;
                                    break;
                                default:
                                    break;
                            }

                            switch (nmItem.getFlag2()){

                                case "col":
                                    nmItemsf2 [i] = R.drawable.colombia;
                                    break;
                                case "arg":
                                    nmItemsf2 [i] = R.drawable.argentina;
                                    break;
                                case "per":
                                    nmItemsf2 [i] = R.drawable.peru;
                                    break;
                                case "bol":
                                    nmItemsf2 [i] = R.drawable.bolivia;
                                    break;
                                case "par":
                                    nmItemsf2 [i] = R.drawable.paraguay;
                                    break;
                                case "bra":
                                    nmItemsf2 [i] = R.drawable.brazil;
                                    break;
                                case "ven":
                                    nmItemsf2 [i] = R.drawable.venezuela;
                                    break;
                                case "uru":
                                    nmItemsf2 [i] = R.drawable.uruguay;
                                    break;
                                case "chi":
                                    nmItemsf2 [i] = R.drawable.chile;
                                    break;
                                case "ecu":
                                    nmItemsf2 [i] = R.drawable.ecuador;
                                    break;
                                case "qat":
                                    nmItemsf2 [i] = R.drawable.qatar;
                                    break;
                                case "jap":
                                    nmItemsf2 [i] = R.drawable.japan;
                                    break;
                                default:
                                    break;
                            }

                        }
                    } catch (JSONException e) {
                        System.out.println("FALLO!");
                        e.printStackTrace();
                    }
                }
            }
        });

        String myFeed = getApplication().getString(R.string.nmurl);
        client.excecute(myFeed);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    //Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logomenu, menu);
        return true;
    }

    //Use this method to save EditText/Button status when phone goes to landscape/portrait mode
    protected void onSaveInstanceState(Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
    }

    //Use this method to recover EditText/Button status when phone goes to landscape/portrait mode
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getInt("visualState") == View.VISIBLE) {

        }
    }
}
