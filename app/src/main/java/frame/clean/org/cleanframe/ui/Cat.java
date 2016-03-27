package frame.clean.org.cleanframe.ui;

import android.util.Log;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;

/**
 * Created by Administrator on 2016/3/25.
 */
public class Cat {

    @Subscribe(
            tags = {@Tag(Constants.EventType.TAG_STORY)},
            thread = EventThread.IO
    )
    public void mouseRun(WhiteMouse mouse) {

        Log.d("Cat",mouse.toString());
    }
    @Subscribe(
            tags = {@Tag(Constants.EventType.TAG_STORY)},
            thread = EventThread.IO
    )
    public void message(String s)
    {
        Log.d("Cat",s);
    }
}
