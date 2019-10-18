package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void openHomePage() {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
}

    public void OpenSignUp(){
    Intent intent = new Intent(this,Signup.class);
    startActivity(intent);
}





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button signIn = (Button) findViewById(R.id.sing_in);
        Button SignUp =(Button) findViewById(R.id.signup);




<<<<<<< HEAD


=======
>>>>>>> 8e9a98b179b076941ea43d7dc8a3ad790080f97b
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView error = (TextView) findViewById(R.id.Wrong);

                EditText Email = (EditText) findViewById(R.id.Email_SignIn) ;
                String Str_Email = Email.getText().toString();

                EditText Password= (EditText) findViewById(R.id.password_SignIn);
                String Str_Password = Password.getText().toString();


                if(Str_Email.equalsIgnoreCase("rayan")&&Str_Password.equals("123")){
                openHomePage();

                }else{
                    error.setText("Wrong Entery ..Please try Again!!");

                }
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignUp();
            }
        });



    }


}
