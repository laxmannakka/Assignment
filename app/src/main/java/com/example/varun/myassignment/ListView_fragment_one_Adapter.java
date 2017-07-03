package com.example.varun.myassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by lakshman on 3/7/17.
 */

public class ListView_fragment_one_Adapter extends BaseAdapter {

    Context context;

    ArrayList<MedicineModel> model = Constants.medicineModels;
    LayoutInflater layoutInflater;
    public ListView_fragment_one_Adapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return model.size();
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
        TextView medicinename,dose,no_oftimes;
        view = layoutInflater.inflate(R.layout.fragment_one_listview_item,viewGroup,false);
        medicinename = view.findViewById(R.id.medicinename);
        dose = view.findViewById(R.id.dose_amout);
        no_oftimes = view.findViewById(R.id.number_of_times);
        medicinename.setText(model.get(i).getMedicineName());
        dose.setText(model.get(i).getDose());
        no_oftimes.setText(String.valueOf(model.get(i).getNumber_of_times()));
        return view;
    }
}
