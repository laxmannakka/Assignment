package com.example.varun.myassignment;

/**
 * Created by lakshman on 3/7/17.
 */

public class MedicineModel {
    public String medicineName;
    public String dose;
    public int number_of_times;

    public MedicineModel(String medicineName, String dose, int number_of_times) {
        this.medicineName = medicineName;
        this.dose = dose;
        this.number_of_times = number_of_times;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getNumber_of_times() {
        return number_of_times;
    }

    public void setNumber_of_times(int number_of_times) {
        this.number_of_times = number_of_times;
    }
}
