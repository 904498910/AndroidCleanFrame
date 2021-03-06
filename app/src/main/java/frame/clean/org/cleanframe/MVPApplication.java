package frame.clean.org.cleanframe;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import frame.clean.org.cleanframe.model.ApiServiceModule;
import frame.clean.org.cleanframe.model.ApplicationComponent;
import frame.clean.org.cleanframe.model.ApplicationModule;
import frame.clean.org.cleanframe.model.DaggerApplicationComponent;

/**
 * Created by Administrator on 2016/3/23.
 */
public class MVPApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);

        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).apiServiceModule(new ApiServiceModule("http://sale.suning.com")).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
