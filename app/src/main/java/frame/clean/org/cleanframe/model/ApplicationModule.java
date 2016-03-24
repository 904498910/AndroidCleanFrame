package frame.clean.org.cleanframe.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frame.clean.org.cleanframe.MVPApplication;

/**
 * Created by Administrator on 2016/3/23.
 */
@Module
public class ApplicationModule {

    private final MVPApplication application;

    public ApplicationModule(MVPApplication application)
    {
        this.application = application;
    }

    @Provides
    @Singleton
    MVPApplication providesContext()
    {
        return this.application;
    }
}
