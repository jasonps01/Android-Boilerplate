package com.jasonpsanders.androidboilerplate.injection.component;

import android.app.LauncherActivity;

import com.jasonpsanders.androidboilerplate.injection.PerActivity;
import com.jasonpsanders.androidboilerplate.injection.module.ActivityModule;
import com.jasonpsanders.androidboilerplate.ui.activity.CharacterActivity;
import com.jasonpsanders.androidboilerplate.ui.activity.DetailActivity;
import com.jasonpsanders.androidboilerplate.ui.activity.MainActivity;
import com.jasonpsanders.androidboilerplate.ui.fragment.DetailFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LauncherActivity launcherActivity);
    void inject(MainActivity mainActivity);
    void inject(CharacterActivity characterActivity);
    void inject(DetailActivity detailActivity);

    void inject(DetailFragment detailFragment);
}

