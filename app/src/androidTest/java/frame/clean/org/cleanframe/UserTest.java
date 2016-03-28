package frame.clean.org.cleanframe;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import frame.clean.org.cleanframe.model.entry.User;
import frame.clean.org.cleanframe.model.entry.User_Table;

/**
 * Created by Administrator on 2016/3/28.
 */
public class UserTest extends InstrumentationTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        SQLite.delete(User.class);
        Log.d("test", "setUp");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        SQLite.delete(User.class);
        Log.d("test", "tearDown");
    }

    public void testInsert() {
        User user = new User();
        user.setName("bao");
        user.setAge(33);
        user.insert();
        assert (user.getId() > 0);
    }

    public void testUpdate() {
        User user = new User();
        user.setName("bao");
        user.setAge(33);
        user.insert();

        user.setAge(50);
        user.update();
        User temp = SQLite.select().from(User.class).where(User_Table.id.eq(user.getId())).querySingle();
        assertEquals(50, temp.getAge());
    }

    public void testDelete() {
        User user = new User();
        user.setName("bao");
        user.setAge(33);
        user.insert();

        user.delete();
        assertEquals(0, SQLite.selectCountOf().from(User.class).where(User_Table.id.eq(user.getId())).count());
    }

    public void testQuery()
    {
        User user = new User();
        user.setName("bao");
        user.setAge(33);
        user.insert();

        User temp = SQLite.select().from(User.class).where(User_Table.id.eq(user.getId())).querySingle();
        assertEquals(user.getId(), temp.getId());
    }

}
