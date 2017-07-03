package com.example.varun.myassignment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class RegisterFragment extends Fragment {

    EditText mEmail, mPassword, mUserName,mAge;
    Button mRegister;
    String username,password,email,age;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_login, container, false);
        mRegister = view.findViewById(R.id.registerAccount);
        mUserName =view.findViewById(R.id.UserName);
        mPassword = view.findViewById(R.id.password);
        mEmail = view.findViewById(R.id.email);
        mAge = view.findViewById(R.id.age);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getValuesAndStoreinPreferance();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getValuesAndStoreinPreferance();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void getValuesAndStoreinPreferance() {



        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = mUserName.getText().toString();
                password = mPassword.getText().toString();
                email = mEmail.getText().toString();
                age = mAge.getText().toString();
                if (username != null && password != null && email != null && age != null) {

                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login",0);
                    SharedPreferences.Editor Ed=sharedPreferences.edit();
                    Ed.putString("username",username);
                    Ed.putString("password",password);
                    Ed.putString("email",email);
                    Ed.putString("age",age);
                    Ed.commit();
                    Toast.makeText(getActivity(),"Succsfully Registerd",Toast.LENGTH_SHORT).show();
                    onShowFragment(new LoginFragment());
                }

                else
                    Toast.makeText(getActivity(),"Please Enter Fields",Toast.LENGTH_SHORT).show();
            }

        });

    }
    public void onShowFragment(Fragment fragment)
    {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment, "ll");
        fragmentTransaction.commit();
    }
}
