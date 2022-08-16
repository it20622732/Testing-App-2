package com.example.department;

public class EDetails {
    private int ID;
    private String emname,emaddress,emdepartment;
    private int emage,emphone;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEname() {
        return emname;
    }

    public void setEmname(String emname) {
        this.emname = emname;
    }

    public String getEmaddress() {
        return emaddress;
    }

    public void setEmaddress(String emaddress) {
        this.emaddress = emaddress;
    }

    public String getEmdepartment() {
        return emdepartment;
    }

    public void setEmdepartment(String emdepartment) {
        this.emdepartment = emdepartment;
    }

    public int getEmage() {
        return emage;
    }

    public void setEmage(int emage) {
        this.emage = emage;
    }

    public int getEmphone() {
        return emphone;
    }

    public void setEmphone(int emphone) {
        this.emphone = emphone;
    }
}
