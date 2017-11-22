package com.hisham.mvpsample.data.module;

import com.hisham.mvpsample.mainscreen.MainScreenContract;
import com.hisham.mvpsample.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hisham on 22/Nov/2017 - 15:17
 */
@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }

}
