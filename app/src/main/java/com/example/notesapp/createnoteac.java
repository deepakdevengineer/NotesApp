package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class createnoteac extends AppCompatActivity {


    EditText mcreatetitleofnote,mcreatecontentnodes;
    FloatingActionButton msavenote;
    FirebaseAuth firebaseAuth;

    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;
    ProgressBar mprogressbarcreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnoteac);


        mcreatecontentnodes = findViewById(R.id.createcontentnodes);
        mcreatetitleofnote = findViewById(R.id.createtitleofnote);
        msavenote = findViewById(R.id.savenote);
        mprogressbarcreate = findViewById(R.id.progressbarcreate);


        Toolbar toolbar =findViewById(R.id.toolbarofcreatenote);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseUser =FirebaseAuth.getInstance().getCurrentUser();



        msavenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title,content;
                title=mcreatetitleofnote.getText().toString();
                content=mcreatecontentnodes.getText().toString();
                if (title.isEmpty() ||content.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Both Field are Require",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    mprogressbarcreate.setVisibility(View.VISIBLE);

                    DocumentReference documentReference = firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("myNotes").document();
                    Map<String, Object> note = new HashMap<>();
                    note.put("title",title);
                    note.put("content",content);

                    documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(),"Note Created Succesfully",Toast.LENGTH_SHORT).show();

                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getApplicationContext(),"Failed to create",Toast.LENGTH_SHORT).show();

                            mprogressbarcreate.setVisibility(View.INVISIBLE);



                        }
                    });



                }
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}