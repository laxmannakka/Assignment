package com.example.varun.myassignment;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lakshman on 30/6/17.
 */

public class LoginFragment extends Fragment {
    View mView;
    EditText username_ed;
    EditText password_ed;
    Button login;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater  inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       mView =  inflater.inflate(R.layout.login,container,false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login",0);
        final String userName = sharedPreferences.getString("username",null);
        final String password = sharedPreferences.getString("password",null);
        username_ed = (EditText)mView.findViewById(R.id.username);
        password_ed = mView.findViewById(R.id.password);
        login = mView.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (username_ed.getText().toString().equals(userName) && password_ed.getText().toString().equals(password))
               {
                   Intent intent = new Intent(getActivity(),Main2Activity.class);
                   startActivity(intent);
                   getActivity().finish();
               }
               else
               {
                   Toast.makeText(getActivity(),"please Enter Mandatory fields",Toast.LENGTH_SHORT).show();
               }
            }
        });
        return mView;
    }
}
