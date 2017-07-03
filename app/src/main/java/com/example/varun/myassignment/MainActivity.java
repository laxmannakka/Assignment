package com.example.varun.myassignment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFrameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        mToolbar.setTitle("Assignment");
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        SharedPreferences sharedPreferences = this.getSharedPreferences("login", 0);
        final String userName = sharedPreferences.getString("username", null);
        final String password = sharedPreferences.getString("password", null);
        if (userName != null && password != null) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();
        }
        onShowFragment(new WelcomeFragment());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("login", 0);

                String userName = sharedPreferences.getString("username", null);
                String password = sharedPreferences.getString("password", null);
                if (userName == null && password == null) {
                    onShowFragment(new RegisterFragment());
                } else {

                }

            }
        }, 2000);


    }

    public void onShowFragment(Fragment fragment) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment, "ll");
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
