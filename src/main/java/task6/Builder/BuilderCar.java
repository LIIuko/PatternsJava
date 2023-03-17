package task6.Builder;

public class BuilderCar implements Builder{
    Car car = new Car();
    @Override
    public void setConvertible(boolean convertible) {
        car.setConvertible(convertible);
    }

    @Override
    public void setWheels(int wheelCount) {
        car.setWheelCount(wheelCount);
    }

    @Override
    public void setDoors(int doorCount) {
        car.setDoorCount(doorCount);
    }

    @Override
    public Car getResult() {
        return car;
    }
}
