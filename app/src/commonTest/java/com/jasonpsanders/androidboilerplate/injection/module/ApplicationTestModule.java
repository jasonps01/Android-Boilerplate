package com.jasonpsanders.androidboilerplate.injection.module;

import static org.mockito.Mockito.mock;

import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;
import com.jasonpsanders.androidboilerplate.data.DataManager;
import com.jasonpsanders.androidboilerplate.data.remote.AndroidBoilerplateService;
import com.jasonpsanders.androidboilerplate.injection.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Provides application-level dependencies for an app running on a testing environment This allows
 * injecting mocks if necessary.
 */
@Module
public class ApplicationTestModule {

  protected final Application mApplication;

  public ApplicationTestModule(Application application) {
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

  /************* MOCKS *************/

  @Provides
  @Singleton
  DataManager providesDataManager() {
    return mock(DataManager.class);
  }

  @Provides
  @Singleton
  AndroidBoilerplateService provideRibotService() {
    return mock(AndroidBoilerplateService.class);
  }

  @Provides
  @Singleton
  AccountManager provideAccountManager() {
    return mock(AccountManager.class);
  }
}
