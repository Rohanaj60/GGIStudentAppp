package com.rnz.ggistudentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Regestration extends AppCompatActivity {

    EditText regEmail;
    EditText regPassword;
    TextView tvLoginHere;
    Button btnRegister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);

        regEmail=findViewById(R.id.registeremail);
        regPassword=findViewById(R.id.registerpassword);
        tvLoginHere = findViewById(R.id.tvLoginHere);
        btnRegister = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view ->{
            createUser();
        });

        tvLoginHere.setOnClickListener(view ->{
            startActivity(new Intent(Regestration.this, MainActivity.class));
        });

    }

    private void createUser(){
        String email = regEmail.getText().toString();
        String password = regPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            regEmail.setError("Email cannot be empty");
            regEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            regPassword.setError("Password cannot be empty");
            regPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Regestration.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Regestration.this, MainActivity.class));
                    }else{
                        Toast.makeText(Regestration.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}