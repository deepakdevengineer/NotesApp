package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText mloginemail,mloginpassword;
   Button mloginbutton,msignupbutton;
  TextView mforgetmain;


    FirebaseAuth firebaseAuth;
    ProgressBar mprogressbarmain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




         mloginbutton =findViewById(R.id.loginbutton);
         msignupbutton =findViewById(R.id.signupbutton);
         mforgetmain =findViewById(R.id.forgetmain);
         mloginpassword = findViewById(R.id.loginpassword);
         mloginemail = findViewById(R.id.loginemail);
         mprogressbarmain=findViewById(R.id.progressbarmain);

         firebaseAuth =FirebaseAuth.getInstance();
         FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

         if (firebaseUser!=null)
         {
             finish();
             startActivity(new Intent(MainActivity.this, notesActivity.class));
         }

         msignupbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,signup.class);
                 startActivity(intent);
             }
         });

         mforgetmain.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent =new Intent(MainActivity.this, forgetpassword.class);
                 startActivity(intent);
             }
         });

         mloginbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String email=mloginemail.getText().toString().trim();
                 String password=mloginpassword.getText().toString().trim();

                 if (email.isEmpty() || password.isEmpty())
                 {
                     Toast.makeText(MainActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {

                     mprogressbarmain.setVisibility(View.VISIBLE);
                   firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful())
                           {
                               checkmailVerification();
                           }
                           else
                           {
                               Toast.makeText(MainActivity.this, "Account Doesn't Exist", Toast.LENGTH_SHORT).show();
                               mprogressbarmain.setVisibility(View.INVISIBLE);

                           }
                       }
                   });

                 }
             }
         });


    }

    private void checkmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser.isEmailVerified()) {
            Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(MainActivity.this, notesActivity.class));
        } else {
            mprogressbarmain.setVisibility(View.INVISIBLE);

            Toast.makeText(MainActivity.this, "Verify Your email First", Toast.LENGTH_SHORT).show();
        }
    }







}