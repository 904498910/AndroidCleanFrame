package frame.clean.org.cleanframe.ui;

import com.hwangjr.rxbus.annotation.Produce;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;

import frame.clean.org.cleanframe.model.BusProvider;

/**
 * Created by Administrator on 2016/3/25.
 */
public class WhiteMouse implements Mouse{

    @Override
    public void squeak() {

        BusProvider.getInstance().post(Constants.EventType.TAG_STORY,this);
    }
    @Produce(
            tags = {@Tag(Constants.EventType.TAG_STORY)},
            thread = EventThread.IO
    )
    public String speak()
    {
        return "Come on Baby!";
    }

    @Override
    public String toString() {
        return "I am a white mouse";
    }
}
