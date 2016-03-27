package frame.clean.org.cleanframe.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frame.clean.org.cleanframe.presenter.LogonPresenter;

/**
 * Created by Administrator on 2016/3/23.
 */
@Module
public class PresenterModule {

    @PerActivity
    @Provides
    LogonPresenter logonPresenter(){
        return new LogonPresenter();
    }
}
