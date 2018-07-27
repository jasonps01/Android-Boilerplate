package com.jasonpsanders.androidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import com.jasonpsanders.androidboilerplate.AndroidBoilerplateApplication;
import com.jasonpsanders.androidboilerplate.data.DataManager;
import com.jasonpsanders.androidboilerplate.data.local.PreferencesHelper;
import com.jasonpsanders.androidboilerplate.data.remote.AndroidBoilerplateService;
import com.jasonpsanders.androidboilerplate.injection.ApplicationContext;
import com.jasonpsanders.androidboilerplate.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AndroidBoilerplateApplication androidBoilerplateApplication);

    @ApplicationContext
    Context context();

    Application application();

    AndroidBoilerplateService androidBoilerplateService();

    PreferencesHelper preferencesHelper();

    DataManager dataManager();
}
