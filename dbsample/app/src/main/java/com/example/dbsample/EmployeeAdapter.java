package com.example.dbsample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dbsample.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    ArrayList<Employee> emplist;
    Context context;
    int textViewResourceId;
    @NonNull
    @Override
    public int getCount() {return super.getCount();}
    public EmployeeAdapter(Context context, int textViewResourceId,ArrayList<Employee> emplist) {
        super(context, 0, emplist);
        this.emplist =emplist;
        this.context=context;
        this.textViewResourceId=textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        // Check if an existing view is being reused, otherwise inflate the view
        View v;

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_layout_employee, null);

        Employee employee=getItem(position);
        TextView textViewName = v.findViewById(R.id.textViewName);
        TextView textViewDept = v.findViewById(R.id.textViewDepartment);
        TextView textViewSalary = v.findViewById(R.id.textViewSalary);
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getDept());
        textViewSalary.setText(String.valueOf(employee.getSalary()));
        return v;
    }

}