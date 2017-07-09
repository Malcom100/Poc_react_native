package com.awesomeproject.modules;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by gtshilombowanticale on 09-07-17.
 */

public class ActivityStarterModule extends ReactContextBaseJavaModule {

    public final String REACT_MODULE = "ActivityStarter";

    public ActivityStarterModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //exposed module name
    @Override
    public String getName() {
        return REACT_MODULE;
    }

    //launch another Activity
    @ReactMethod
    void navigateToExample() {
        Log.i("Test","test launch another activity ");
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, SimpleViewActivity.class);
        context.startActivity(intent);
    }
}
