package com.example.nanthakumar.hamburger.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;

import com.example.nanthakumar.hamburger.R;
import com.example.nanthakumar.hamburger.fragments.LoginFragment;
import com.example.nanthakumar.hamburger.fragments.ProfileFragment;
import com.example.nanthakumar.hamburger.fragments.RegisterFragment;
import com.example.nanthakumar.hamburger.interfaces.FragmentsActionCallBack;

public class MainActivity extends AppCompatActivity implements FragmentsActionCallBack, ValueCallback<Boolean> {
    private final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(LoginFragment.newInstance(), true);
    }


    @Override
    public void addFragment(@NonNull Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String name = fragment.getClass().getName();
        Log.v(TAG, "Fragment name:" + name);
        if (addToBackStack) {
            fragmentTransaction.add(R.id.container, fragment, name).addToBackStack(name);
        } else {
            fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }

    @Override
    public void removeFragment(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onReceiveValue(Boolean value) {
        if (value) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
            finish();
        } else {
            addFragment(RegisterFragment.newInstance(), true);
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }

    }
}
