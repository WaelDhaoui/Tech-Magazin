package com.example.miniprojet.view;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;
import com.example.miniprojet.model.User;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SignIn extends AppCompatActivity {

    EditText email,pass;
    Button btnlogin,btncreateacc;
    public int resTest = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        init();
        ecoutBtn();
    }

    public void init() {
        email = (EditText) findViewById(R.id.txtusername);
        pass = (EditText) findViewById(R.id.txtpass);
        btnlogin= (Button) findViewById(R.id.btnLogIn);
        btncreateacc = (Button)findViewById(R.id.btnCreateAcc);
    }

    public void ecoutBtn() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("") || pass.getText().toString().equals("")){
                    Toast.makeText(SignIn.this,"Both Username and Password are mandatory.",Toast.LENGTH_SHORT).show();
                }else {
                    Client_Test test = new Client_Test(SignIn.this);
                    test.execute(email.getText().toString(),pass.getText().toString());
                    if(resTest == 1)
                        openHome();
                    else
                        Toast.makeText(SignIn.this,"Username or Password incorrect.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btncreateacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_account();
            }
        });
    }

    public void openHome(){
        Intent intent= new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void create_account(){
        Intent intent= new Intent(this, Create_Account.class);
        startActivity(intent);
    }


    public class Client_Test extends AsyncTask<String, Void, Integer> {

        private SignIn sign = null;

        public Client_Test (Context context) {
            sign = (SignIn) context;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            sign.resTest = integer;
        }

        @Override
        protected Integer doInBackground(String... strings) {

            try{
                //the IP and port should be correct to have a connection established
                // Creates a stream socket and connects it to the specified port number on the named host.
                Socket socket = new Socket("192.168.56.1", 111);

                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osr = new OutputStreamWriter(os);
                PrintWriter pw =new PrintWriter(osr,true);

                pw.println(strings[0] + "," + strings[1]);

                InputStream is = socket.getInputStream();
                int nb = is.read();

                socket.close();
                return nb;

            }catch(Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
