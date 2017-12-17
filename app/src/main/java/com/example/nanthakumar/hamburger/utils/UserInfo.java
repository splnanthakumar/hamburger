package com.example.nanthakumar.hamburger.utils;

/**
 * Created by nanthakumar on 17/12/17.
 */

public class UserInfo {
    private String mUserName, mPassword;

    public UserInfo(String userName, String password) {
        this.mUserName = userName;
        this.mPassword = password;
    }

    public String getmUserName() {
        return mUserName;
    }

    public String getmPassword() {
        return mPassword;
    }
}
