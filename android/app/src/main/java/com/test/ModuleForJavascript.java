package com.test;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ModuleForJavascript extends ReactContextBaseJavaModule {

    ModuleJavaOnly javaOnly;

    public ModuleForJavascript (ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ModuleForJavascript";
    }

    @ReactMethod
    public void showMyText(Promise promise) {
        javaOnly = new ModuleJavaOnly();

        if (javaOnly.showText() == null) {
            promise.reject("Nenhum texto encontrado");
        } else {
            promise.resolve("Text: " + javaOnly.showText());
        }

    }
}
