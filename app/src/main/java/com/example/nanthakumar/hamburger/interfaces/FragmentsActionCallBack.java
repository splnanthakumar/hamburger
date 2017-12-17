package com.example.nanthakumar.hamburger.interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by nanthakumar on 17/12/17.
 */

public interface FragmentsActionCallBack {

    void addFragment(Fragment fragment,boolean add);
    void removeFragment(Fragment fragment);
}
