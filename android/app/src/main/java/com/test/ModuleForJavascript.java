package com.test;

import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ModuleForJavascript extends ReactContextBaseJavaModule {

    ModuleJavaOnly javaOnly;
    ReactContext context;

    public ModuleForJavascript (ReactApplicationContext reactContext) {
        super(reactContext);

        context = reactContext;
    }

    @Override
    public String getName() {
        return "ModuleForJavascript";
    }

    @ReactMethod
    public void showMyText(Promise promise) {
        javaOnly = new ModuleJavaOnly();

        Log.d("Text:: ", String.format("Context is null: %b", context == null));
        Log.d("Text:: ", String.format("getApplicationContext is null: %b", context.getApplicationContext() == null));

        if (javaOnly.showText() == null) {
            promise.reject("Nenhum texto encontrado");
        } else {
            promise.resolve("Text: " + javaOnly.showText());
        }

    }
}
