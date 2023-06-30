//package com.example.myapplication.user;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.myapplication.MainActivity;
//import com.example.myapplication.R;
//
//public class SignUp extends AppCompatActivity {
//    private Button btnLogin,btnSignup,btnHome;
//    private EditText ed1,ed2,ed3;
//    UserList userList;
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        btnLogin=(Button)findViewById(R.id.login);
//        btnSignup=(Button)findViewById(R.id.signUp);
//        btnHome=(Button)findViewById(R.id.btnHome);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SignUp.this,Login.class);
//                startActivity(intent);
//
//
//            }
//        });
//        btnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SignUp.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        btnSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ed1 = (EditText)findViewById(R.id.email);
//                ed2 = (EditText)findViewById(R.id.password);
//                ed3 = (EditText)findViewById(R.id.password_confirm);
//
//                String email,pass,pass_cf;
//
//                email = ed1.getText().toString();
//                pass = ed2.getText().toString();
//                pass_cf = ed3.getText().toString();
//                if (pass.equals(pass_cf)) {
//                    Users user = new Users(email, pass);
//                    if (user.checkValidPassword()&&user.checkValidEmail()){
//                        userList.addUser(user);
//                        System.out.println(userList);
//                        Toast toast = Toast.makeText(SignUp.this, "Tạo Tài Khoản Thành Công", Toast.LENGTH_SHORT);
//                        toast.show();
//                    }
//                    else {
//                        Toast toast = Toast.makeText(SignUp.this, "Invalid information", Toast.LENGTH_SHORT);
//                        toast.show();
//                    }
//                }
//                else {
//                    Toast toast = Toast.makeText(SignUp.this, "Password does not match", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//            }
//        });
//
//    }
//
//    private void closeKeyBoard(){
//        View view = this.getCurrentFocus();
//        if (view != null){
//            InputMethodManager imm = (InputMethodManager)
//                    getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }
//    }
//}