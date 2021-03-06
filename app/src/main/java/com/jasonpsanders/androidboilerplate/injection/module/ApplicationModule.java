package com.jasonpsanders.androidboilerplate.injection.module;

import android.app.Application;
import android.content.Context;
import com.jasonpsanders.androidboilerplate.data.remote.AndroidBoilerplateService;
import com.jasonpsanders.androidboilerplate.injection.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {

  protected final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

  @Provides
  @Singleton
  AndroidBoilerplateService provideAndroidBoilerplateService() {
    return AndroidBoilerplateService.Factory.makeAndroidBoilerplateService(mApplication);
  }
}