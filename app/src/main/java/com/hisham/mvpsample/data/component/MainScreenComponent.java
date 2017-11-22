package com.hisham.mvpsample.data.component;

import com.hisham.mvpsample.mainscreen.MainActivity;
import com.hisham.mvpsample.data.module.MainScreenModule;
import com.hisham.mvpsample.util.CustomScope;

import dagger.Component;

/**
 * Created by Hisham on 22/Nov/2017 - 15:18
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
