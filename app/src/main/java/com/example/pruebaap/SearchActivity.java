package com.example.pruebaap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    Button addQR;
    TextView warning;
    TextView infoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        addQR = (Button) findViewById(R.id.addQR);
        warning = (TextView) findViewById(R.id.warning);
        infoplayer = (TextView) findViewById((R.id.infoplayer));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logomenu, menu);

        addQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQR();
            }
        });

        return true;
    }

    private void addQR() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(
                    requestCode, resultCode, intent);
            if (scanResult != null) {
                // Handle successful scan
                String contents = scanResult.getContents();
                TextView infoplayer =(TextView) findViewById(R.id.infoplayer);
                infoplayer.setText(contents);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, R.string.scan_canceled, Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
