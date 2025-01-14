package com.example.ejemplologin.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ejemplologin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* seccion e atributos */
    FloatingActionButton fab;
    EditText etNames;
    EditText etSurnames;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lounchWidgets();
        lounchEvents();

    }

    //conecta interfaz con logica
    private void lounchWidgets() {

        context = this;

        fab = findViewById(R.id.fab);
        etNames = findViewById(R.id.et_names);
        etSurnames= findViewById(R.id.et_surnames);

    }

    //agrega eventos a objetos de interfaz
    private void lounchEvents() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = etNames.getText().toString();
                String p = etSurnames.getText().toString();

                Intent i = new Intent(context, MainMenu.class);

                if (u.compareTo("David Alberto") == 0 && p.compareTo("Muñoz Bravo") == 0) {
                    i.putExtra("UserName", "David Alberto Muñoz Bravo");
                    i.putExtra("UserPic", R.drawable.ic_android);
                    startActivity(i);
                    finish();
                }
                else{
                    etNames.setText("");
                    etSurnames.setText("");
                    Toast.makeText(view.getContext(), "Datos no válidos Envío\nUsr: " + u + " Pass: " + p, Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}