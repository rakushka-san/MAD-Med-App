package com.rakushkins.madmeditationapp;

import java.util.ArrayList;

public class Feelings {
    private boolean success;
    private FeelingsData data;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(FeelingsData data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public FeelingsData getData() {
        return data;
    }
}
