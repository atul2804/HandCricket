package com.example.atul.handcricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import static com.example.atul.handcricket.R.id.spinner;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerop;
    TextView optext,inputtext;
    public static String opteam = "";
    EditText num;
    public int k =0;
    public static String num_over = "";

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        optext = (TextView) findViewById(R.id.oppotext);
        inputtext = (TextView) findViewById(R.id.inputtexto);
        num = (EditText) findViewById(R.id.numo);

      //  num_over = num.getText().toString();

        spinnerop = (Spinner) findViewById(R.id.spinner_op);
        spinnerop.setOnItemSelectedListener(Activity3.this);

        initialize();
        btn = (Button) findViewById(R.id.toss);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_over = num.getText().toString();
                if (num_over.length() == 0) {
                    Toast.makeText(Activity3.this,"Overs Required!",Toast.LENGTH_SHORT).show();
                } else {
                    Prefmanager prefs = new Prefmanager(Activity3.this);
                 //   num_over = num.getText().toString();
                    prefs.setOpTeam(opteam);
                    prefs.setOvers(num_over);
                    Intent i = new Intent(Activity3.this, TossActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Activity3.this, num_over, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initialize(){
        List<String> team;
        String teams = "India,Pakistan,Australia,New Zealand,South Africa,England,West Indies,Sri Lanka";
        team = Arrays.asList(teams.split(","));

        ArrayAdapter<String> data = new ArrayAdapter<String>(this,R.layout.custom_spinner,team);

        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerop.setAdapter(data);
        spinnerop.setSelection(0);

        opteam = data.getItem(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        opteam = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
