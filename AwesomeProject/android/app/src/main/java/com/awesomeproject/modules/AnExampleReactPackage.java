package com.awesomeproject.modules;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class allows to register the module, it is available from Javascript
 */

public class AnExampleReactPackage implements ReactPackage {

    //return the list of natives module
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        //list of modules
        List<NativeModule> modules = new ArrayList<>();

        //add a module here
        modules.add(new TestToastModule(reactContext));
        modules.add(new ActivityStarterModule(reactContext));

        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    //View managers
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.<ViewManager>singletonList(
                new ProgressBarViewManager()
        );
    }
}
