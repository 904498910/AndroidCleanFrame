package frame.clean.org.cleanframe;

import frame.clean.org.cleanframe.config.Constants;
import frame.clean.org.cleanframe.model.entry.Result;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/3/28.
 */
public class RetroUtil {

    public static <T> Observable<T> flatResult(final Result<T> result) {
        return Observable.create(new Observable.OnSubscribe<T>() {
                                     @Override
                                     public void call(Subscriber<? super T> subscriber) {

                                         switch (result.ResultCode) {
                                             case Constants.SUCCESS_CODE:
                                                 subscriber.onNext(result.Data);
                                                 break;
                                             case Constants.ERROR_CODE:
                                                 subscriber.onError(new Throwable(result.ResultMessage));
                                                 break;
                                             default:
                                                 // ...
                                         }
                                         subscriber.onCompleted();
                                     }
                                 }
        );
    }
}

