package frame.clean.org.cleanframe.model;

import frame.clean.org.cleanframe.model.entry.Result;
import frame.clean.org.cleanframe.model.entry.User;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiService {

    @FormUrlEncoded
    @POST("/user")
    Observable<Result<User>> getUserInfo(@Field("name")String name,@Field("passwd")String pwd);
}