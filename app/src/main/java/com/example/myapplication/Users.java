package com.example.myapplication;

public class Users {
    private String email;
    private String password;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean checkValidUser(){
        Users user = new Users(email,password);
        UserList userList = new UserList();

        userList.addUser(user);

        if(userList.checkExistedUser(user))
        {
            userList.removeUser(user);
            return true;
        }
        else {
            userList.removeUser(user);
            return false;
        }
    }
    public boolean checkValidEmail(){
        if(this.getEmail().length()>=6 && this.getEmail().contains("@")){
            return true;
        }
        else return false;
    }
    public boolean checkValidPassword(){
        if(this.getPassword().length()>=6){
            return true;
        }
        else return false;
    }
}
