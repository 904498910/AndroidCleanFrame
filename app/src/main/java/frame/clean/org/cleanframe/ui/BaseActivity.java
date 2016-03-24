package frame.clean.org.cleanframe.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import frame.clean.org.cleanframe.MVPApplication;
import frame.clean.org.cleanframe.model.ApplicationComponent;

/**
 * Created by Administrator on 2016/3/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(((MVPApplication) getApplication()).getApplicationComponent());
    }

    protected abstract  void setupActivityComponent(ApplicationComponent appComponent);
}
