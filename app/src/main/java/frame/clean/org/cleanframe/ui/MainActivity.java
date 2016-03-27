package frame.clean.org.cleanframe.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import frame.clean.org.cleanframe.R;
import frame.clean.org.cleanframe.model.BusProvider;

public class MainActivity extends AppCompatActivity {

    private Cat cat = new Cat();

    private WhiteMouse mouse = new WhiteMouse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BusProvider.getInstance().register(cat);
        BusProvider.getInstance().register(mouse);
        mouse.squeak();
//        mouse.speak();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(cat);
        BusProvider.getInstance().unregister(mouse);
    }
}
