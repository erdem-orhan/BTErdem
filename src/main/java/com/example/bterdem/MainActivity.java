package com.example.bterdem;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button button_sign;
    Button button_signup;
    ArrayList <Person> persons;
    Integer attempt;
    TextView textMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineVariables();
        defineListeners();
    }
    private void cleanTextBoxes(){
        username.setText("");
        password.setText("");
    }

    public boolean checkPerson(){
        for(Person aPerson : persons){
            if( username.getText().toString().equals(aPerson.getUserNname())
                    && password.getText().toString().equals((aPerson.getPassword()))) {
                return true;
            }
        }
        return false;
    }


    public void defineVariables(){
        persons= Person.getPersonsList();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button_sign = (Button) findViewById(R.id.button_sign);
        button_signup = (Button) findViewById(R.id.button_signup);
    }

    public void defineListeners(){
        button_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(checkPerson()){
                intent = new Intent(v.getContext(),MenuActivity.class);
                intent.putExtra("userId", username.getText().toString());
                cleanTextBoxes();
                startActivity(intent);
        }

                else {
                    cleanTextBoxes();
                    attempt = +1;
                    textMessage.setText("Kullanıcı Adı/Parola");
                    if(attempt >=3){
                        Toast.makeText(MainActivity.this, "3 defa yanlş girdin", Toast.LENGTH_SHORT).show();
                        button_sign.setEnabled(false);
                        finish();
                    }

                }
            }
        });


        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });

    }


}