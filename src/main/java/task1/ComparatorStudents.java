package task1;

@FunctionalInterface
public interface ComparatorStudents<T> {
    String compare(T s1, T s2);
}
