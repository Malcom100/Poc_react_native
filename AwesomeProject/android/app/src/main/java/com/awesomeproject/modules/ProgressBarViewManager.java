package com.awesomeproject.modules;

import android.util.Log;
import android.widget.ProgressBar;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by gtshilombowanticale on 09-07-17.
 */

public class ProgressBarViewManager extends SimpleViewManager<ProgressBar> {

    public static final String REACT_CLASS = "ProgressBar";

    //give the name
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    //instantiate the view
    @Override
    protected ProgressBar createViewInstance(
            ThemedReactContext reactContext) {
        Log.i("Test","create the progress bar here !!! ");
        return new ProgressBar(reactContext);
    }

}
