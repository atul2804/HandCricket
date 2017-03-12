package com.example.atul.handcricket;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    Spinner spinner;
    public String myteam = "",op_team = "";
    Button toss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(TeamActivity.this);

        init();

        toss = (Button) findViewById(R.id.start_button);
        toss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Prefmanager prefs = new Prefmanager(TeamActivity.this);
                prefs.setMyTeam(myteam);
                Intent intent = new Intent(TeamActivity.this,Activity3.class);
                startActivity(intent);
                finish();
                Toast.makeText(TeamActivity.this,myteam,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init() {
        List<String> team;
        String teams = "India,Pakistan,Australia,New Zealand,South Africa,West Indies,Sri Lanka";
        team = Arrays.asList(teams.split(","));

        ArrayAdapter<String> data = new ArrayAdapter<String>(this,R.layout.custom_spinner,team);

        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(data);
        spinner.setSelection(0);

        myteam = data.getItem(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        myteam = parent.getItemAtPosition(position).toString();
    }

    public void showdrop(View v) {
        spinner.performClick();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
