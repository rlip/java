package pl.clockworkjava.hr;

import java.util.logging.Logger;

public class Init {
    public static final Logger LOG = Logger.getLogger(Init.class.getName());

    public static void init() {
        LOG.info("Moduł Hr został zainicjalizowany");
    }
}
