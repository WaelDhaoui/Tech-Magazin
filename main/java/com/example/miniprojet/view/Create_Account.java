package com.example.miniprojet.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;
import com.example.miniprojet.model.User;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Create_Account extends AppCompatActivity {

    TextView name,lastname,email,pass;
    Button btncreateacc,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        init();
        ecoutBtn();
    }

    public void init() {
        name = (TextView) findViewById(R.id.name);
        lastname = (TextView) findViewById(R.id.lastname);
        email = (TextView) findViewById(R.id.email);
        pass = (TextView) findViewById(R.id.pass);

        signin = (Button) findViewById(R.id.txtsignin);
        btncreateacc = (Button) findViewById(R.id.btncreateacc);
    }

    public void ecoutBtn() {
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singin();
            }
        });

        btncreateacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("") || lastname.getText().toString().equals("") || email.getText().toString().equals("") || pass.getText().toString().equals("") ){
                    Toast.makeText(Create_Account.this,"You have to fill all fields",Toast.LENGTH_SHORT).show();
                }else {
                    Client_Post post = new Client_Post(new User(name.getText().toString(),lastname.getText().toString(),email.getText().toString(),pass.getText().toString()));
                    post.execute();
                    openHome();
                }
            }
        });
    }

    private void openHome() {
        Intent intent= new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    private void singin(){
        Intent intent= new Intent(this, SignIn.class);
        startActivity(intent);
    }


    public class Client_Post extends AsyncTask<Void, Void, Void> {

        public User user;

        public Client_Post(User user) {
            this.user = user;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                // the IP and port should be correct to have a connection established
                // Creates a stream socket and connects it to the specified port number on the named host.
                Socket socket = new Socket("192.168.56.1", 405);

                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osr = new OutputStreamWriter(os);
                PrintWriter pw =new PrintWriter(osr,true);

                pw.println(user.name+","+user.lastname+","+user.email+","+user.password);

                socket.close();

            }catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
