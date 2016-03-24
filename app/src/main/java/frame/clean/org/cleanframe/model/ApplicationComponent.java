package frame.clean.org.cleanframe.model;

import javax.inject.Singleton;

import dagger.Component;
import frame.clean.org.cleanframe.MVPApplication;

/**
 * Created by Administrator on 2016/3/23.
 */
@Singleton
@Component(modules = {ApplicationModule.class,ApiServiceModule.class})
public interface ApplicationComponent {

    MVPApplication getApplication();
    ApiService getApiService();
}
