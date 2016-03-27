package frame.clean.org.cleanframe.model;

import frame.clean.org.cleanframe.model.entry.User;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

public interface ApiService {

    @FormUrlEncoded
    @POST("/user")
    Observable<User> getUserInfo(@Field("name")String name,@Field("passwd")String pwd);
}