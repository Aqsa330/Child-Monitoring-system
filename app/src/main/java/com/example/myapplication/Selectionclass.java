package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selectionclass extends AppCompatActivity {
          private Button b4;
    private Button b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectionclass);
        b5=(Button)findViewById(R.id.child);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              openForchild();
            }
        });
        b4=(Button)findViewById(R.id.parent);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRrgister();
            }
        });

    }
    public Void openRrgister()
    {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
        return null;

}
    public Void openForchild()
    {
        Intent intent=new Intent(this,Forchild.class);
        startActivity(intent);
        return null;

    }}