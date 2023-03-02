package task5;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

class Singleton2 {
    private static Singleton2 INSTANCE;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}


class Singleton3 {

    private Singleton3() { }

    private static class SingletonHolder {
        public static final Singleton3 HOLDER_INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}