package com.example.myapplication.login;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Home;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {
    private Button btnLogin,btnSignup,btnHome;
    private EditText ed1,ed2,ed3;
    UserList userList;
    TextView alreadyHaveAccount;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyHaveAccount=findViewById(R.id.alreadyHaveAccount);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnSignup=(Button)findViewById(R.id.signUp);
        ed1 = (EditText)findViewById(R.id.email);
        ed2 = (EditText)findViewById(R.id.password);
        ed3 = (EditText)findViewById(R.id.password_confirm);

        mAuth= FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog= new ProgressDialog(this);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                PerforAuth();

            }

            private void PerforAuth() {
                String email,pass,pass_cf;

                email = ed1.getText().toString();
                pass = ed2.getText().toString();
                pass_cf = ed3.getText().toString();

                if(!email.matches(emailPattern)){
                    ed1.setError("Vui long nhap email");
                } else if (pass.isEmpty() || pass.length()<6) {
                    ed2.setError("Vui long nhap mat khau");
                } else if (!pass.equals(pass_cf)) {
                    ed3.setError("Mat khau khong khop");
                }else {
                    progressDialog.setMessage("Please Wait...");
                    progressDialog.setTitle("DAng Ky");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                sendUserToNextactivity();
                                Toast.makeText(getApplicationContext(), "Dang Ky Thanh Cong", Toast.LENGTH_SHORT).show();

                            }else {
                                Toast.makeText(RegisterActivity.this,"Dang Ky That Bat",Toast.LENGTH_SHORT);
                            }
                        }


                    });
                }
            }
        });

        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        });
    }
    private void sendUserToNextactivity() {
        Intent intent= new Intent(RegisterActivity.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}