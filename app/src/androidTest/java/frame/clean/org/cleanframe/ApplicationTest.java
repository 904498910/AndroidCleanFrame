package frame.clean.org.cleanframe;

import android.test.ApplicationTestCase;
import android.util.Log;

import frame.clean.org.cleanframe.model.ApiService;
import frame.clean.org.cleanframe.model.ApplicationComponent;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<MVPApplication> {

    private MVPApplication application;

    public ApplicationTest() {
        super(MVPApplication.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        application = getApplication();
    }

    public void testApplicationComponent()
    {
        ApplicationComponent component = application.getApplicationComponent();
        assertNotNull(component);
        assertNotNull(component.getApiService());
        assertNotNull(component.getApplication());
    }

    public void testGet()
    {
        ApiService apiService = application.getApplicationComponent().getApiService();
        Response<ResponseBody> response= null;
        try {
            response = apiService.getHtml().execute();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        assertNotNull(response);
        assertEquals(200,response.code());
        Log.d("test",response.body().toString()+" "+response.message());
    }
}