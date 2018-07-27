package com.jasonpsanders.androidboilerplate.injection.component;

import com.jasonpsanders.androidboilerplate.injection.module.ApplicationTestModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
