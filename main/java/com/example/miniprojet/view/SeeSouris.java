package com.example.miniprojet.view;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miniprojet.R;

public class SeeSouris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seesouris);

        Button buy =(Button) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SeeSouris.this,"Buy Successful",Toast.LENGTH_SHORT).show();
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