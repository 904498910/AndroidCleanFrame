package frame.clean.org.cleanframe.model;

import com.hwangjr.rxbus.Bus;

public class BusProvider {
    /**
     * Check out the bus, like identifier or thread enforcer etc.
     */
    private static final Bus BUS = new Bus();

    private BusProvider() {
    }

    public static Bus getInstance() {
        return BUS;
    }
}