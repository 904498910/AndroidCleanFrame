package frame.clean.org.cleanframe.presenter;

import android.util.Log;

/**
 * Created by Administrator on 2016/3/23.
 */
public class LogonPresenter {

    private LogonView logonView;

    public LogonPresenter() {

    }

    public void attach(LogonView view) {
        this.logonView = view;
    }

    public void talk()
    {
        Log.d("tag","I am Coming!");
    }

    public interface LogonView {
        void showProgress();

        void hideProgress();
    }
}
