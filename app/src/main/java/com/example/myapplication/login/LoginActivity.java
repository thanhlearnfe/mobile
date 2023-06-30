package com.example.myapplication.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.filmlist.Film;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    ImageView btnGoogle;
    TextView createnewAccount;
    private Button btnLogin,btnSignup,login;
    private UserList userList;
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_1);
        createnewAccount=findViewById(R.id.createNewAccount);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        createnewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
        btnGoogle = (ImageView) findViewById(R.id.btnGoogle);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, GoogleSiginActivity.class);
                startActivity(intent);
            }
        });
        EditText loginvalue;
        EditText passw;
        loginvalue = findViewById(R.id.email);
        passw = findViewById(R.id.password);
        btnLogin=(Button)findViewById(R.id.login);


        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = loginvalue.getText().toString();
                String pass = passw.getText().toString();

                Users user = new Users(name,pass);

                if (user.checkValidEmail()&&user.checkValidPassword()){
                    if (user.checkValidUser()){
                        Toast toast = Toast.makeText(getApplicationContext(),"Đăng nhập thành công !", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent2);
                    }
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(),"User not existed", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Tài khoản hoặc mật khẩu không chính xác.", Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });
    }
    }

