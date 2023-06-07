package com.example.myapplication;

import android.service.autofill.UserData;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserList {
    private static ArrayList<Users> userData = new ArrayList<>();

//    private static ArrayList<Users>  admindata() {
//        return userData;
//    }

    public static void adminUser(){userData.add(new Users("xuanthanhvdk@gmail.com", "123456"));}

    public static void setUserData(ArrayList<Users> userData) {
        UserList.userData=userData;
    }
    public static void addUser(Users u){
        userData.add(u);
    }
    public void removeUser(Users u){
        userData.remove(u);
    }
    public boolean checkExistedUser(Users user){
        int t = 0;
        adminUser();
        for (Users u: userData){
            if (user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())){
                t++;
            }
        }
        if (t>1) return true;
        else return false;
    }

}
