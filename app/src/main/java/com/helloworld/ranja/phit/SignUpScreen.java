package com.helloworld.ranja.phit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpScreen extends AppCompatActivity {
    private  static EditText Username;
    private  static EditText Password;
    private  static EditText PasswordCon;
    private  static Button Ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        OkButton();
    }
    public void OkButton(){
        Username = findViewById(R.id.etUsername1);
        Password = findViewById(R.id.etPassword1);
        PasswordCon =findViewById(R.id.etpasswordcon);
        Ok = findViewById(R.id.btnOk);
    }
        Ok.setOnClickListener(new View.OnClickListener()
    {
        @Override
                public void OnClick(View v) {
            if(!Password.getText().toString().equals(PasswordCon))

        {
            Toast pass =Toast.makeText(SignUpScreen.this,"Passwords don't match", Toast.LENGTH_SHORT);
            pass.show();
        }
        else
        {
            Contact c =new Contact();
            c.setUsername(  );
            Intent intent2 = new Intent(SignUpScreen.this,InputScreen.class);
            startActivity(intent2);
        }

    }

    }

}
