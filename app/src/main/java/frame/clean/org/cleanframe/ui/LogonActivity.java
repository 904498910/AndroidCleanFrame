package frame.clean.org.cleanframe.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import frame.clean.org.cleanframe.R;
import frame.clean.org.cleanframe.model.ApplicationComponent;
import frame.clean.org.cleanframe.model.DaggerPresenterComponent;
import frame.clean.org.cleanframe.model.entry.User;
import frame.clean.org.cleanframe.presenter.LogonPresenter;

public class LogonActivity extends BaseActivity implements LogonPresenter.LogonView{

    @Inject
    LogonPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        presenter.attach(this);
        presenter.talk();

    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {

        DaggerPresenterComponent.builder().applicationComponent(appComponent).build().inject(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void logonSuccess(User user) {

    }

    @Override
    public void logonFailure(Throwable e) {

    }
}
