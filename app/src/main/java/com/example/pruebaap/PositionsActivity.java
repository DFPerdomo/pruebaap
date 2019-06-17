package com.example.pruebaap;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class PositionsActivity extends AppCompatActivity implements View.OnClickListener, GroupsFrag.OnFragmentInteractionListener, BracketsFrag.OnFragmentInteractionListener {
    Button groupsButton, bracketsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positions);

        GroupsFrag groups = new GroupsFrag();
        getSupportFragmentManager().beginTransaction().add(R.id.container, groups).commit();

        groupsButton= (Button)findViewById(R.id.groupsButton);
        bracketsButton= (Button)findViewById(R.id.bracketsButton);

        groupsButton.setOnClickListener(this);
        bracketsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.groupsButton:

                GroupsFrag groups = new GroupsFrag();
                FragmentTransaction transition1 = getSupportFragmentManager().beginTransaction();
                transition1.replace(R.id.container, groups);
                transition1.commit();
                break;

            case R.id.bracketsButton:

                BracketsFrag brackets = new BracketsFrag();
                FragmentTransaction transition2 = getSupportFragmentManager().beginTransaction();
                transition2.replace(R.id.container, brackets);
                transition2.commit();
                break;
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logomenu, menu);
        return true;
    }
}