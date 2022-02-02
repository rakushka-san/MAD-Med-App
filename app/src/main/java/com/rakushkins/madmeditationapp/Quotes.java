package com.rakushkins.madmeditationapp;

import java.util.ArrayList;

public class Quotes{
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public ArrayList<QuotesData> getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(ArrayList<QuotesData> data) {
        this.data = data;
    }

    private ArrayList<QuotesData> data;
}

