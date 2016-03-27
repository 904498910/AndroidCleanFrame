package frame.clean.org.cleanframe.model.database;

import com.raizlabs.android.dbflow.DatabaseHelperListener;
import com.raizlabs.android.dbflow.config.BaseDatabaseDefinition;
import com.raizlabs.dbflow.android.sqlcipher.SQLCipherOpenHelper;

/**
 * Created by Administrator on 2016/3/27.
 */
public class DBChiperHelper extends SQLCipherOpenHelper{

    public DBChiperHelper(BaseDatabaseDefinition databaseDefinition, DatabaseHelperListener listener) {
        super(databaseDefinition, listener);
    }

    @Override
    protected String getCipherSecret() {
        return "mvp";
    }
}
