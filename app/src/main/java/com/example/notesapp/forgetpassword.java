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
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {

    private TextView mgobackloginscreen;
    private EditText mforgotpasswrd;
    private Button recoverbutton;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);



        mgobackloginscreen = findViewById(R.id.gobackloginscreen);
        mforgotpasswrd = findViewById(R.id.forgotpasswrd);
        recoverbutton = findViewById(R.id.recoverbutton);

        firebaseAuth =FirebaseAuth.getInstance();

        mgobackloginscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forgetpassword.this, MainActivity.class);
                startActivity(intent);
            }
        });


        mforgotpasswrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=mforgotpasswrd.getText().toString().trim();
                if (mail.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Your Email First",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                               Toast.makeText(getApplicationContext(),"Mail Send ,You can recover your password using mail",Toast.LENGTH_SHORT).show();
                               finish();
                               startActivity(new Intent(forgetpassword.this, MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Email is Incorrect Or the Account is not Exist",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });

    }
}