package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class notedetails extends AppCompatActivity {

    private TextView mtitleofnotedetails, mcreatecontentnodes;
    FloatingActionButton fgotoeditnote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notedetails);

        mtitleofnotedetails = findViewById(R.id.titleofnotedetails);
        mcreatecontentnodes = findViewById(R.id.createcontentnodes);
        Toolbar toolbar = findViewById(R.id.toolbarofnotedetails);
        setSupportActionBar(toolbar);
        fgotoeditnote = findViewById(R.id.gotoeditnote);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent data = getIntent();
        String title = data.getStringExtra("title");
        String content = data.getStringExtra("content");

        mtitleofnotedetails.setText(title);
        mcreatecontentnodes.setText(content);

        fgotoeditnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notedetails.this, editnote.class);
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                intent.putExtra("noteID", data.getStringExtra("noteID"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
