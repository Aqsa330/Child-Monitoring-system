package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText Rjuname, Rjemail, Rjpassword;
    Button Rjbtn;
    TextView RJlogin;
    FirebaseAuth fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIviews();
        fb= FirebaseAuth.getInstance();
        Rjbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    //upload to db
String Email= Rjemail.getText().toString().trim();
String Password=Rjpassword.getText().toString().trim();
fb.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        if(task.isSuccessful())
        {
            Toast.makeText(Register.this, "successfull", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Register.this,MainActivity2login.class));
        }
    else
        {
            Toast.makeText(Register.this, "failed", Toast.LENGTH_SHORT).show();
        }
    }


})   ;            }
            }
        });
        RJlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,MainActivity2login.class));
            }
        });
    }


    private void setupUIviews() {
        Rjuname = (EditText) findViewById(R.id.Rusername);
        Rjemail = (EditText) findViewById(R.id.Remail);
        Rjpassword = (EditText) findViewById(R.id.Rpassword);
        Rjbtn = (Button) findViewById(R.id.Rbtn);
        RJlogin=(TextView) findViewById(R.id.login);

    }

    private Boolean validate() {
        Boolean result = false;


        String Email = Rjemail.getText().toString().trim();
        String Passwrd = Rjpassword.getText().toString().trim();
        String Name = Rjuname.getText().toString().trim();
        if (Email.isEmpty() && Passwrd.isEmpty() && Name.isEmpty()) {
            Toast.makeText(this, "Please enter", Toast.LENGTH_SHORT).show();
        } else {
            return
                    result = true;

        }
        return result;
    }

}