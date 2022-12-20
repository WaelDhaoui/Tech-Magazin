package com.example.miniprojet.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;

public class HomeActivity extends AppCompatActivity {

    Button btnsouris,btnpc,btncasque,btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        ecoutBtn();
    }

    public void init() {
        btnsouris= (Button) findViewById(R.id.btnsouris);
        btnpc = (Button) findViewById(R.id.btnpc);
        btncasque = (Button) findViewById(R.id.btncasque);
        btnRetour = (Button) findViewById(R.id.txtRetour);
    }

    public void ecoutBtn() {
        btnsouris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seeProducts();
            }
        });
        btnpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeePc();
            }
        });
        btncasque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seeCasq();
            }
        });
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, SignIn.class);
                startActivity(intent);
            }
        });
    }

    private void seeCasq() {
        Intent intent= new Intent(this, SeeCasque.class);
        startActivity(intent);
    }

    private void SeePc() {
        Intent intent= new Intent(this, SeePc.class);
        startActivity(intent);
    }

    private void seeProducts() {
        Intent intent= new Intent(this, SeeSouris.class);
        startActivity(intent);
    }
}
