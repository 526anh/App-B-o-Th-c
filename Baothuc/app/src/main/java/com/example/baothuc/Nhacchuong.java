package com.example.baothuc;

import androidx.appcompat.app.AppCompatActivity;

public class Nhacchuong {
    private String Ten;
    private int File;

    public Nhacchuong(String ten, int file) {
        Ten = ten;
        File = file;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
}
