package com.awesomeproject.modules;

import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;

import java.nio.ByteBuffer;

/**
 * Created by gtshilombowanticale on 08-07-17.
 */

public class TestToastModule extends ReactContextBaseJavaModule {

    private static final String E_LAYOUT_ERROR = "E_LAYOUT_ERROR";

    public TestToastModule(ReactApplicationContext reactConytext){
        super(reactConytext);
    }

    //give the name of module
    @Override
    public String getName() {
        return "TestToastAndroid";
    }

    //expose the method to javscript, the type of bridge is void
    @ReactMethod
    public void show(String message){
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @ReactMethod
    public void showTwo(){
        Toast.makeText(getReactApplicationContext(), "hahaha !!! ", Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void measureLayout(int tag, int ancestorTag, Promise promise) {
        Log.i("Test","call measure Layout here ");
        try {
            WritableMap map = Arguments.createMap();

            map.putDouble("relativeX", 22f);
            map.putDouble("relativeY", 1f);
            map.putDouble("width", 10f);
            map.putDouble("height", 258f);

            promise.resolve(map);
            Log.i("Test","size map is "+(map == null));
        } catch (IllegalViewOperationException e) {
            promise.reject(E_LAYOUT_ERROR, e);
            Log.i("Test","rejected "+e.getMessage());
        }
    }

}
