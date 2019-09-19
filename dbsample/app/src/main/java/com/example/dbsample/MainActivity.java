package com.example.dbsample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView t1,t2,t3;
    private final String TAG = "MyDB";
    EmployeeAdapter adapter;
    Employee customer;
    ArrayList<Employee> arrayOfEmp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source

// Create the adapter to convert the array to views
// Attach the adapter to a ListView
         listView = (ListView) findViewById(R.id.listViewEmployees);
         t1=(TextView) findViewById(R.id.textViewName);
        t2=(TextView)findViewById(R.id.textViewDepartment);
        t3=(TextView)findViewById(R.id.textViewSalary);
//        EmployeeAdapter adapter = new EmployeeAdapter(this, arrayOfEmp);
//        listView.setAdapter(adapter);
        new task().execute();
        adapter = new EmployeeAdapter(this, R.layout.list_layout_employee, arrayOfEmp);
        listView.setAdapter(adapter);


    }

    class task extends AsyncTask<Void, Void, Void> {

        private String text1 = "", text2 = "", text3 = "", text4 = "";


        @Override
        protected Void doInBackground(Void... voids) {

            Log.d(TAG, "inside doInBackground");

            try {
                MySQLConnector connection = new MySQLConnector();

                Connection conn = connection.getMySqlConnection();

                Log.d(TAG, "Connection established");

                Statement statement = conn.createStatement();

                Log.d(TAG, "Statement created");

                ResultSet results = statement.executeQuery("SELECT * FROM employees");

                Log.d(TAG, "query executed");

                listView = findViewById(R.id.listViewEmployees);

                while (results.next()) {
                     customer = new Employee( results.getString("name"), results.getString("dept"), results.getDouble("salary"));
                    arrayOfEmp.add(customer);
                }


                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {


            Log.d(TAG, "onPostExecute");

//        EmployeeAdapter adapter = new EmployeeAdapter(MainActivity., R.layout.list_layout_employee, arrayOfEmp);
//        listView.setAdapter(adapter);
//            t1.setText(customer.name);
//            t2.setText(customer.dept);
//            t3.setText((int) customer.salary);

            super.onPostExecute(aVoid);
        }
    }


}


