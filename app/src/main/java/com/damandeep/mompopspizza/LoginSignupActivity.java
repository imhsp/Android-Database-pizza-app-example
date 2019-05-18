package com.damandeep.mompopspizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginSignupActivity extends AppCompatActivity {

    UserDatabaseHelper userDBHelper;

    TextView text;
    TextView signuptext;
    EditText email;
    EditText password;
    EditText signupEmail;
    EditText signupName;
    EditText signupPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup_layout);

        userDBHelper = new UserDatabaseHelper(this);

        text = findViewById(R.id.text_login);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);

        Button login = findViewById(R.id.login_button);

        //userDBHelper.addData("Damandeep Gill", "daman@aman.com", "1234");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailText = String.valueOf(email.getText());
                String passwordText = String.valueOf(password.getText());

                int userID = userDBHelper.getUser(emailText, passwordText);

                if (!emailText.equals("") && !passwordText.equals("") && userID != -1) {
                    text.setText("Login Successful");
                    launchMainActivity(userID);
                } else {
                    text.setText("Invalide Login, Try sign up");
                }

            }
        });

        signuptext = findViewById(R.id.text_signup);
        signupEmail = findViewById(R.id.signup_email);
        signupName = findViewById(R.id.signup_name);
        signupPassword = findViewById(R.id.signup_password);

        Button signup = findViewById(R.id.signup_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailText = String.valueOf(signupEmail.getText());
                String nameText = String.valueOf(signupName.getText());
                String passwordText = String.valueOf(signupPassword.getText());

                if (!emailText.equals("") && !passwordText.equals("") && !nameText.equals("")
                        && userDBHelper.addData(nameText, emailText, passwordText)) {
                    signuptext.setText("User Created");

                    launchMainActivity(userDBHelper.getUser(emailText, passwordText));
                } else {
                    signuptext.setText("Email alreay exits, Try logging in");
                }

            }
        });
    }

    private void launchMainActivity(int userID) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
        finish();
    }
}
