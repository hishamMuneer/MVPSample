package com.hisham.mvpsample;

import android.app.Application;

import com.hisham.mvpsample.data.component.DaggerNetComponent;
import com.hisham.mvpsample.data.component.NetComponent;
import com.hisham.mvpsample.data.module.AppModule;
import com.hisham.mvpsample.data.module.NetModule;

/**
 * Created by Hisham on 22/Nov/2017 - 14:57
 */

public class App extends Application {
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
