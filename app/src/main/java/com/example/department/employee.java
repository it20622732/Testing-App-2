package com.example.department;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.department.dbhandler.DB;

public class employee extends AppCompatActivity {

    Button btn_submit;
    EditText emname, emage, emphone, emaddress, emdepartment;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        btn_submit = findViewById(R.id.btn_submit);
        emname = findViewById(R.id.emname);
        emage = findViewById(R.id.emage);
        emphone = findViewById(R.id.emphone);
        emaddress = findViewById(R.id.emaddress);
        emdepartment = findViewById(R.id.emdepartment);
        db = new DB(this);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_submit.getText().toString().equals("")){
                    boolean res = db.addEmployee(btn_submit.getText().toString());


                    if (res){
                        emname.setText("");
                        Toast.makeText(context,"successfully added",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(context,"unsuccessful", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Name Required !", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}