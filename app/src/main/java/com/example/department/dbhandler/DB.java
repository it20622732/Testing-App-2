package com.example.department.dbhandler;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.department.Department;
import com.example.department.EDetails;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class DB extends SQLiteOpenHelper{

    public DB (Context context){
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //create tables in the database

        sqLiteDatabase.execSQL("Create table Department(ID INTEGER PRIMARY KEY AUTOINCREMENT, name text, buildingno int)");
        sqLiteDatabase.execSQL("Create table EDetails(name text, age int, phone int, address txt, department int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //create department
    public boolean addDepartment (Department department){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",department.getName());
        contentValues.put("buildingno",department.getBuildingno());

        long res = sqLiteDatabase.insert("Department",null,contentValues);

        if(res == -1){
            return false;
        }else{
            return true;
        }

    }
    //update
    public boolean editDepartment(Department department) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", department.getName());
        contentValues.put("buildingno", department.getBuildingno());

        long res = sqLiteDatabase.update("Department", contentValues, "ID" + department.getID(), null);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    //delete employee details table
    public boolean deleteDepartment(Department department){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", department.getName());
        contentValues.put("buildingno", department.getBuildingno());

        long res = sqLiteDatabase.update("Department", contentValues, "ID" + department.getID(), null);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    //view department details
    public ArrayList<Department>reallAllDepartment(){
        ArrayList<Department> department = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor results = sqLiteDatabase.rawQuery("select * from department", null);
        results.moveToFirst();

        while(results.isAfterLast()==false){
            Department model = new Department();

            model.setID(results.getInt(0));
            model.setName(results.getString(1));
            model.setBuildingno(results.getInt(2));

            department.add(model);
            results.moveToNext();

        }
        return department;
        }

    //create employee table details
    public boolean addEmployee(EDetails edetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emane",edetails.getEname());
        contentValues.put("emage",edetails.getEmage());
        contentValues.put("emaddress",edetails.getEmaddress());
        contentValues.put("emphone",edetails.getEmphone());
        contentValues.put("emdepartment",edetails.getEmdepartment());

        long res = sqLiteDatabase.insert("EDetails",null,contentValues);

        if(res == -1){
            return false;
        }else{
            return true;
        }

    }

    // update employee table details
    public boolean editEmployee(EDetails edetails) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emane",edetails.getEname());
        contentValues.put("emage",edetails.getEmage());
        contentValues.put("emaddress",edetails.getEmaddress());
        contentValues.put("emphone",edetails.getEmphone());
        contentValues.put("emdepartment",edetails.getEmdepartment());

        long res = sqLiteDatabase.update("EDetails", contentValues, "ID" + edetails.getID(), null);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    //delete employee details table
    public boolean deleteEmployee(EDetails edetails){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emane",edetails.getEname());
        contentValues.put("emage",edetails.getEmage());
        contentValues.put("emaddress",edetails.getEmaddress());
        contentValues.put("emphone",edetails.getEmphone());
        contentValues.put("emdepartment",edetails.getEmdepartment());

        long res = sqLiteDatabase.update("EDetails", contentValues, "ID" + edetails.getID(), null);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    //view employee table details
    public ArrayList<EDetails>readAllEDetails(){
        ArrayList<EDetails> edetails = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor results = sqLiteDatabase.rawQuery("select * from edetails", null);
        results.moveToFirst();

        while(results.isAfterLast()==false){
            EDetails model = new EDetails();

            model.setID(results.getInt(0));
            model.setEmname(results.getString(1));
            model.setEmaddress(results.getString(2));
            model.setEmdepartment(results.getString(3));
            model.setEmage(results.getInt(4));
            model.setEmphone(results.getInt(5));


            edetails.add(model);
            results.moveToNext();

        }
        return edetails;
    }



}

