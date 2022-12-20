package com.example.miniprojet.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;

public class SeePc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seepc);

        Button buy =(Button) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SeePc.this,"Buy Successful",Toast.LENGTH_SHORT).show();
            }
        });
        Button goback = (Button) findViewById(R.id.btngoback);
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