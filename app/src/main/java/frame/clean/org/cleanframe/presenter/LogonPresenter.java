package frame.clean.org.cleanframe.presenter;

import android.util.Log;

import frame.clean.org.cleanframe.MVPApplication;
import frame.clean.org.cleanframe.model.ApiService;
import frame.clean.org.cleanframe.model.entry.User;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/3/23.
 */
public class LogonPresenter {

    private LogonView logonView;
    private ApiService apiService;

    public LogonPresenter() {

        apiService = MVPApplication.getApplicationComponent().getApiService();
    }

    public void attach(LogonView view) {
        this.logonView = view;
    }

    public void talk()
    {
        Log.d("tag","I am Coming!");
    }

    public User logon(String useName,String pwd)
    {
        if(logonView != null)
        {
            logonView.showProgress();
        }
        apiService.getUserInfo(useName,pwd).observeOn(Schedulers.io()).doOnNext(new Action1<User>() {
            @Override
            public void call(User user) {
                user.insert();
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if(logonView != null)
                {
                    logonView.logonFailure(e);
                    logonView.hideProgress();
                }
            }

            @Override
            public void onNext(User user) {
                if(logonView != null)
                {
                    logonView.logonSuccess(user);
                    logonView.hideProgress();
                }
            }
        });
        return null;
    }

    public interface LogonView {
        void showProgress();

        void hideProgress();

        void logonSuccess(User user);

        void logonFailure(Throwable e);
    }
}
