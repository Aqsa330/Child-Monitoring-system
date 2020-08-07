package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView t1;
    private Button b2;
private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelectionclass();
            }
        });
        b2 = (Button) findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity2login();

            }
        });
    }

    public Void openSelectionclass()
    {
        Intent intent = new Intent(this, Selectionclass.class);
        startActivity(intent);


        return null;
    }

    public Void openActivity2login()
    {
        Intent intent = new Intent(this, MainActivity2login.class);
        startActivity(intent);


        return null;
    }
}