package com.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class ModuleJavaOnly extends Activity {

    public String getMyText() {
        return myText;
    }

    public void setMyText(String myText) {
        this.myText = myText;
    }

    String myText = "Initial Value";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setMyText("Hello World!");

    }

    public String showText() {
        Log.d("Text: ", getMyText());
        return getMyText();
    }

}
