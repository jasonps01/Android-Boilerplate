package com.jasonpsanders.androidboilerplate.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import com.jasonpsanders.androidboilerplate.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
