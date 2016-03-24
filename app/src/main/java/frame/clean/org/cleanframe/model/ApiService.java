package frame.clean.org.cleanframe.model;

import frame.clean.org.cleanframe.model.entry.User;
import retrofit.http.GET;
import rx.Observable;

public interface ApiService {

    @GET("/user")
    Observable<User> getUserInfo();
}