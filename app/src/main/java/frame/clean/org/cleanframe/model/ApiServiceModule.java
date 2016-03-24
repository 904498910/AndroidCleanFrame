package frame.clean.org.cleanframe.model;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Administrator on 2016/3/2.
 */
@Module
public class ApiServiceModule {

    private final String END_POINT;

    public ApiServiceModule(String domain)
    {
        this.END_POINT = domain;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(OkHttpClient okHttpClient) {
        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setClient(new OkClient(okHttpClient))
                .setEndpoint(END_POINT);
        return builder.build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(RestAdapter restAdapter) {
        return restAdapter.create(ApiService.class);
    }
}
