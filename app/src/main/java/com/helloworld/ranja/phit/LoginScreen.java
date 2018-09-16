package com.helloworld.ranja.phit;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    private  static EditText Username;
    private  static EditText Password;
    private  static Button Login;
    private  static TextView Info;
    private  static Button SignUp;
    private static EditText name;
    private static EditText pass;
    int counter = 5;

    UserDatabase database = new UserDatabase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        LoginButton();
        SignUpButton();
    }

        public void LoginButton(){
        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        Info = findViewById(R.id.tvInfo);


        Info.setText(Integer.toString(counter));

        Login.setOnClickListener(new View.OnClickListener()
                                 {
            @Override
            public void onClick(View view) {

                String Username1 =Username.getText().toString().trim();
                Intent intent = new Intent(LoginScreen.this,InputScreen.class);
                startActivity(intent);
                try {
                    Cursor c = database.db.rawQuery( "SELECT* FROM users where namestr= '" + Username1 +"'", null );
                    if (c.getCount() > 0) {
                        Toast.makeText( getApplicationContext(), "USER ALREADY EXITS", Toast.LENGTH_LONG ).show();
                    }

                    else{
                            //System.out.println("NOPE" + Username.getText() + Password.getText());
                            //System.out.println(Username.getText().equals("Admin"));
                            //System.out.println(Password.getText().equals("1234"));
                            Toast pass = Toast.makeText( LoginScreen.this, "Passwords don't match", Toast.LENGTH_SHORT );
                            pass.show();

                            counter--;

                            Info.setText( Integer.toString( counter ) );

                            if (counter == 0) {
                                Login.setEnabled( false );
                            }
                        }
                    }  catch(Exception e)
                {
                    e.printStackTrace();
                }
                    //if(Username.getText().toString().equals(name)  && Password.getText().toString().equals(pass)) {
                    //System.out.println("HELLO");
                    //System.out.println(Username);
                    //System.out.println(Password);
                    //}else{
                    //System.out.println("NOPE" + Username.getText() + Password.getText());
                    //System.out.println(Username.getText().equals("Admin"));
                    //System.out.println(Password.getText().equals("1234"));
                    //Toast pass = Toast.makeText( LoginScreen.this, "Passwords don't match", Toast.LENGTH_SHORT );
                    //pass.show();

                    //counter--;

                    //Info.setText( Integer.toString( counter ) );

                    //if (counter == 0) {
                      //Login.setEnabled( false );
                    }



        }

        );
        }

    public void SignUpButton() {
        SignUp = findViewById(R.id.btnsignup);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginScreen.this,SignUpScreen.class);
                startActivity(intent1);
            }
        });
    }

}
