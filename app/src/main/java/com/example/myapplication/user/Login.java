//    package com.example.myapplication.user;
//
//    import androidx.appcompat.app.AppCompatActivity;
//
//    import android.annotation.SuppressLint;
//    import android.content.Intent;
//    import android.os.Bundle;
//    import android.view.View;
//    import android.widget.Button;
//    import android.widget.EditText;
//    import android.widget.Toast;
//
//    import com.example.myapplication.MainActivity;
//    import com.example.myapplication.R;
//
//    public class Login extends AppCompatActivity {
//        private Button btnLogin,btnSignup,login;
//        private UserList userList;
//        @SuppressLint({"WrongViewCast", "MissingInflatedId"})
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_login);
//
//
//            EditText loginvalue;
//            EditText passw;
//            loginvalue = findViewById(R.id.loginvalu);
//            passw = findViewById(R.id.pas);
//            btnLogin=(Button)findViewById(R.id.login);
//            btnSignup=(Button)findViewById(R.id.btnSignup);
//
//            btnSignup.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(Login.this,SignUp.class);
//                    startActivity(intent);
//                }
//            });
//
//            login = findViewById(R.id.logi);
//            login.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View v) {
//                        String name = loginvalue.getText().toString();
//                        String pass = passw.getText().toString();
//
//                     Users user = new Users(name,pass);
//                     if (user.checkValidEmail()&&user.checkValidPassword()){
//                         if (user.checkValidUser()){
//                             Toast toast = Toast.makeText(getApplicationContext(),"Đăng nhập thành công !", Toast.LENGTH_SHORT);
//                             toast.show();
//                             Intent intent2 = new Intent(Login.this, MainActivity.class);
//                             startActivity(intent2);
//                         }
//                         else {
//                             Toast toast = Toast.makeText(getApplicationContext(),"User not existed", Toast.LENGTH_SHORT);
//                             toast.show();
//                         }
//                     }
//                     else {
//                         Toast toast = Toast.makeText(getApplicationContext(),"Tài khoản hoặc mật khẩu không chính xác.", Toast.LENGTH_SHORT);
//                         toast.show();
//
//                     }
//
//                 }
//             });
//    }
//    }