package frame.clean.org.cleanframe.model.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by 12072616 on 2015/10/19.
 */
public class OkHttpUtil {

    private static final OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        mOkHttpClient = builder.build();
    }

    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

}
