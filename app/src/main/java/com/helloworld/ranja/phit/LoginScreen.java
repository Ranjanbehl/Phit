package com.helloworld.ranja.phit;
import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {

    private  static EditText Username;
    private  static EditText Password;
    private  static Button Login;
    private  static TextView Info;
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        LoginButton();
    }

        public void LoginButton(){
        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        Info = findViewById(R.id.tvInfo);

        Info.setText(Integer.toString(counter));

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(Username.getText().toString().equals("Admin")  && Password.getText().toString().equals("1234")) {
                        //System.out.println("HELLO");
                        Intent intent = new Intent(LoginScreen.this,InputScreen.class);
                        startActivity(intent);
                    }else{
                        //System.out.println("NOPE" + Username.getText() + Password.getText());
                        //System.out.println(Username.getText().equals("Admin"));
                        //System.out.println(Password.getText().equals("1234"));
                        counter--;

                        Info.setText(Integer.toString(counter));

                        if(counter==0){
                            Login.setEnabled(false);
                        }
                    }

            }
        });
    }



}
