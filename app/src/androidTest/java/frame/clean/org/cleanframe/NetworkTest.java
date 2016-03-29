package frame.clean.org.cleanframe;

import android.test.InstrumentationTestCase;
import android.util.Log;

import frame.clean.org.cleanframe.model.network.OkHttpUtil;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/3/29.
 */
public class NetworkTest extends InstrumentationTestCase {

    public void testOkHttpClient()
    {
        Request request = new Request.Builder().get().url("https://raw.githubusercontent.com/square/okhttp/master/README.md").build();
        Response response = null;
        try {
            response = OkHttpUtil.execute(request);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        assertNotNull(response);
        assertEquals(200, response.code());
        Log.d("Test",response.body().toString());
    }
}
