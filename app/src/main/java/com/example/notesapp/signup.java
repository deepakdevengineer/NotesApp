package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    EditText msignupepassword,msignupemail;
    TextView mforgetpswd;
     Button msignupbutton;

    FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        msignupbutton = findViewById(R.id.signupbutton);
        mforgetpswd =findViewById(R.id.forgetpswd);
        msignupepassword = findViewById(R.id.signupepassword);
        msignupemail = findViewById(R.id.signupemail);

        firebaseAuth = FirebaseAuth.getInstance();




        mforgetpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, forgetpassword.class);
                startActivity(intent);
            }
        });

        msignupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = msignupemail.getText().toString().trim();
                String password = msignupepassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All fields are required to fill", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 7) {
                    Toast.makeText(getApplicationContext(), "Password should be greater than 7 characters", Toast.LENGTH_SHORT).show();
                } else {
                    // Register the user
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), " Register! Successfully", Toast.LENGTH_SHORT).show();
                                sendEmailVerification();
                            } else {
                                // Registration failed
                                Toast.makeText(getApplicationContext(), "Failed to Register!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    // ... (existing code)

    private void sendEmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Verification Email is sent, Verify and Log In Again!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(signup.this, MainActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Failed to Send Verification Email!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Failed to Send Verification Email!", Toast.LENGTH_SHORT).show();
        }
    }
}

