package com.rnz.ggistudentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    EditText LoginEmail;
    EditText LoginPassword;
    TextView tvRegisterHere;
    Button btnLogin1;

    FirebaseAuth mAuth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView forget_password;
        forget_password = findViewById(R.id.button5);
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "ForgetPassword Clicked", Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(MainActivity.this, forget_pass.class);
                  startActivity(intent);
            }
        });
       /* TextView loginemail;
        loginemail= findViewById(R.id.registeremail);

        TextView signup;
        signup = findViewById(R.id.signup);*/

        LoginEmail = findViewById(R.id.registeremail);
        LoginPassword = findViewById(R.id.registerpassword);
        tvRegisterHere = findViewById(R.id.tvRegisterHere);
        btnLogin1 = findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        btnLogin1.setOnClickListener(view -> {
            loginUser();
        });
        tvRegisterHere.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, Regestration.class));
        });
/*        signup.setOnClickListener(new View.OnClickListener() {
            loginUser();
            @Override
            public void onClick(View v) {
                Intent signuppage = new Intent(MainActivity.this,Home.class);
                startActivity(signuppage);
            }
        });*/
        //getSupportActionBar().hide();





    }

    private void loginUser(){
        String email = LoginEmail.getText().toString();
        String password = LoginPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            LoginEmail.setError("Email cannot be empty");
            LoginEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            LoginPassword.setError("Password cannot be empty");
            LoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                       /* Toast.makeText(MainActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();*/
                       checkAdmin(task.getResult().getUser().getUid());
//                        Intent signuppage = new Intent(MainActivity.this,Home.class);
//                        startActivity(signuppage);
                    }else{
                        Toast.makeText(MainActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void checkAdmin(String uid) {

        DocumentReference df = fstore.collection("Users").document(uid);
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Log.d("TAG", "onSuccess: "+documentSnapshot.getData());

                if(documentSnapshot.getString("isAdmin").equals("true")){
                    startActivity(new Intent(MainActivity.this,AdminPanelTest.class));
                    finish();
                }
                if(documentSnapshot.getString("isAdmin").equals("false")){
                    startActivity(new Intent(MainActivity.this,Home.class));
                    finish();
                }
            }
        });
    }
}