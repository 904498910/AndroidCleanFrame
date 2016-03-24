package frame.clean.org.cleanframe.model;

import javax.inject.Singleton;

import dagger.Component;
import frame.clean.org.cleanframe.ui.LogonActivity;

/**
 * Created by Administrator on 2016/3/23.
 */
@PerActivity
@Component(modules = PresenterModule.class,dependencies = ApplicationComponent.class)
public interface PresenterComponent {

    void inject(LogonActivity activity);

}
