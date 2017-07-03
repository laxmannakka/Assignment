package com.example.varun.myassignment;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by lakshman on 3/7/17.
 */

public class ListViewAdapter_Two extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<MedicineModel> arrayList = new ArrayList<>();
    ArrayList<MedicineModel> medicineModel = new ArrayList<>();


    public ListViewAdapter_Two(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        arrayList = Constants.medicineModels;

    }

    @Override
    public int getCount() {
        return medicineModel.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.fragment2_listview_item,viewGroup,false);
        TextView textView = view.findViewById(R.id.medicineName);
        textView.setText(medicineModel.get(i).getMedicineName());

        return view;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        medicineModel.clear();
        if (charText.length() == 0) {
            medicineModel.addAll(arrayList);
        }
        else
        {
            for (MedicineModel wp : arrayList)
            {
                if (wp.getMedicineName().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    medicineModel.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
