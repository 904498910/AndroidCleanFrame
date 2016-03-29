package frame.clean.org.cleanframe.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frame.clean.org.cleanframe.model.network.OkHttpUtil;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/3/2.
 */
@Module
public class ApiServiceModule {

    private final String END_POINT;

    public ApiServiceModule(String domain) {
        this.END_POINT = domain;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
//        builder.readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
//        return builder.build();
        return OkHttpUtil.getOkHttpClient();
    }

    @Provides
    @Singleton
    Retrofit provideRestAdapter(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(END_POINT);
        builder.client(new okhttp3.OkHttpClient());
//        builder.addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
