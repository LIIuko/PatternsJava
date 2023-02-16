package task3;

import sun.misc.Lock;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class SetLock implements Set {

    private final static Lock lock = new Lock();
    private volatile Set set = new HashSet();

    @Override
    public int size() {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int size = set.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean empty = set.isEmpty();
        lock.unlock();
        return empty;
    }

    @Override
    public boolean contains(Object o) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean contains = set.contains(o);
        lock.unlock();
        return contains;
    }

    @Override
    public Iterator iterator() {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Iterator iterator = set.iterator();
        lock.unlock();
        return iterator;
    }

    @Override
    public Object[] toArray() {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object[] array = set.toArray();
        lock.unlock();
        return array;
    }

    @Override
    public boolean add(Object o) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean temp = set.add(o);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean temp = set.remove(o);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean addAll(Collection c) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean temp = set.addAll(c);
        lock.unlock();
        return temp;
    }

    @Override
    public void clear() {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        set.clear();
        lock.unlock();
    }

    @Override
    public boolean removeAll(Collection c) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean temp = set.removeAll(c);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean retainAll(Collection c) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean temp = set.retainAll(c);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean containsAll(Collection c) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean temp = set.containsAll(c);
        lock.unlock();
        return temp;
    }

    @Override
    public Object[] toArray(Object[] a) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object[] array = set.toArray(a);
        lock.unlock();
        return array;
    }
}
