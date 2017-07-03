package com.example.varun.myassignment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by lakshman on 3/7/17.
 */

public class ItemOneFragment extends Fragment {
    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }

    View mView;
    ListView mListview;
    ArrayList<MedicineModel> arrayList = new ArrayList<>();
    Toolbar mtoolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragmentone, container, false);
        mListview = mView.findViewById(R.id.listview);
        mtoolbar = mView.findViewById(R.id.toolbar_fraagment1);
        setHasOptionsMenu(true);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createMedicine();
        setListViewAdapter();
    }

    private void createMedicine() {
        arrayList.add(new MedicineModel("paracitamol", "150mg", 2));
        arrayList.add(new MedicineModel("Cold & Cough", "150mg", 2));
        arrayList.add(new MedicineModel("zerodal", "50mg", 2));
        arrayList.add(new MedicineModel("zinkwit", "200mg", 2));
        Constants.medicineModels = arrayList;
    }

    private void setListViewAdapter() {
        ListView_fragment_one_Adapter adpter = new ListView_fragment_one_Adapter(getActivity());
        mListview.setAdapter(adpter);

    }



}
