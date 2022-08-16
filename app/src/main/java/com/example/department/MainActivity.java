package com.example.department;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.department.dbhandler.DB;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText edname, edbuilding;
    DB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        edname = findViewById(R.id.edname);
        edbuilding = findViewById(R.id.edbuilding);
        db = new DB(this);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(btn1.getText().toString().equals("")){
                    boolean res = db.addDepartment(btn1.getText().toString());


                    if (res){
                        edname.setText("");
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