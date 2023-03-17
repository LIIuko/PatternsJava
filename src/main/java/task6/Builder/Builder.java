package task6.Builder;

public interface Builder {
    void setConvertible(boolean convertible);
    void setWheels(int wheelCount);
    void setDoors(int doorCount);
    Car getResult();
}
