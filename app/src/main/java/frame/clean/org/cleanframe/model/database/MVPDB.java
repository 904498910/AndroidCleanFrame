package frame.clean.org.cleanframe.model.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Administrator on 2016/3/27.
 */
@Database(version = MVPDB.VERSION,name = MVPDB.NAME,sqlHelperClass = DBChiperHelper.class)
public class MVPDB {

    public static final int VERSION = 1;

    public static final String  NAME = "mvp.db";
}
