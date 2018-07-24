package com.jasonpsanders.androidboilerplate;

import android.app.Application;
import android.content.Context;

import com.jasonpsanders.androidboilerplate.injection.component.ApplicationComponent;
import com.jasonpsanders.androidboilerplate.injection.component.DaggerApplicationComponent;
import com.jasonpsanders.androidboilerplate.injection.module.ApplicationModule;

import timber.log.Timber;

public class AndroidBoilerplateApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public static AndroidBoilerplateApplication get(Context context) {
        return (AndroidBoilerplateApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
