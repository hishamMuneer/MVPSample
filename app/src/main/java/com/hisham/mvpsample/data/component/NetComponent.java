package com.hisham.mvpsample.data.component;

import com.hisham.mvpsample.data.module.AppModule;
import com.hisham.mvpsample.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Hisham on 22/Nov/2017 - 14:54
 */
@Singleton
@Component (modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();
}