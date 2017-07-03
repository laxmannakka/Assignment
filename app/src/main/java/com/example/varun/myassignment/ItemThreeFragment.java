package com.example.varun.myassignment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lakshmanon 3/7/17.
 */

public class ItemThreeFragment extends Fragment {

    public static ItemThreeFragment newInstance()
    {
        ItemThreeFragment fragment = new ItemThreeFragment();
        return fragment;
    }

    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragmentthreelayout,container,false);

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login",0);
        String userName = sharedPreferences.getString("username",null);
        String age1= sharedPreferences.getString("age",null);
        TextView userName_text = mView.findViewById(R.id.username);
        TextView age = mView.findViewById(R.id.age_text);
        userName_text.setText(userName);
        age.setText(age1);

    }
}
