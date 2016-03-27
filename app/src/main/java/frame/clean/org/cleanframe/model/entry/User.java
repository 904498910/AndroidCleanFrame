package frame.clean.org.cleanframe.model.entry;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import frame.clean.org.cleanframe.model.database.MVPDB;

/**
 * Created by Administrator on 2016/3/23.
 */
@Table(database = MVPDB.class)
public class User extends BaseModel{

    @PrimaryKey(autoincrement = true)
    private int id;
    @Column
    private String name;
    @Column
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
