package task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MapSemaphore<E, K> implements Map<E, K> {

    private Semaphore semaphore = new Semaphore(1, true);
    /**
     * int permits — начальное и максимальное значение счетчика.
     * То есть то, сколько потоков одновременно могут иметь доступ к общему ресурсу;

     * boolean fair — для установления порядка, в котором потоки будут получать доступ.
     * Если fair = true, доступ предоставляется ожидающим потокам в том порядке, в котором они его запрашивали.
     * Если же он равен false, порядок будет определять планировщик потоков.*/

    private volatile Map<E, K> map = new HashMap<>();

    //для методов - Для получения разрешения у семафора надо вызвать метод acquire()
    //После окончания работы с ресурсом полученное ранее разрешение надо освободить с помощью метода release():

    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = map.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean emptiness = true;

        try {
            semaphore.acquire();
            emptiness = map.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return emptiness;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean temp = false;
        try {
            semaphore.acquire();
            temp = map.containsKey(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  temp;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean temp = false;
        try {
            semaphore.acquire();
            temp = map.containsValue(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  temp;
    }

    @Override
    public K get(Object key) {
        Object temp = null;
        try {
            semaphore.acquire();
            temp = map.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return (K) temp;
    }

    @Override
    public Object put(Object key, Object value) {
        Object previous = null;
        try {
            semaphore.acquire();
            previous = map.put((E) key, (K) value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return previous;
    }

    @Override
    public K remove(Object key) {
        Object previous = null;
        try {
            semaphore.acquire();
            previous = map.remove((E) key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return (K) previous;
    }

    @Override
    public void putAll(Map m) {
        try {
            semaphore.acquire();
            map.putAll(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            map.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    @Override
    public Set keySet() {
        Set set = null;
        try {
            semaphore.acquire();
            set = map.keySet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection collection = null;
        try {
            semaphore.acquire();
            collection = map.values();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return collection;
    }

    @Override
    public Set<Entry<E, K>> entrySet() {
        Set<Entry<E, K>> set = null;
        try {
            semaphore.acquire();
            set = map.entrySet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return set;
    }
}
