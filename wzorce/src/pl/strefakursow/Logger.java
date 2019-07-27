package pl.strefakursow;

//SingletonHolder

public class Logger {
    private static Logger instace;

    private Logger() {
    }

    public static Logger getInstace() {
        return SingletonHolder.INSTANCE;
    }

    public void logToConsole(){

    }

    private static class SingletonHolder {
        private static final Logger INSTANCE = new Logger();
    }
}
