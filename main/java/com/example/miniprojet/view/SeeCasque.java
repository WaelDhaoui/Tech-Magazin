package com.example.miniprojet.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;

public class SeeCasque extends AppCompatActivity {
    Button buy,goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seecasque);
        init();
        ecoutBtn();
    }

    public void init() {
        buy =(Button) findViewById(R.id.buy);
        goback = (Button) findViewById(R.id.btngoback);
    }

    public void ecoutBtn() {
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SeeCasque.this,"Buy Successful",Toast.LENGTH_SHORT).show();
            }
        });


        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHome();
            }
        });
    }

    private void goHome() {
        Intent intent= new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}