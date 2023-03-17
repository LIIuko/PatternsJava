package task6.Builder;

public class Salon {

    public void createNormalCar(Builder builder){
        builder.setConvertible(false);
        builder.setDoors(4);
        builder.setWheels(4);
    }

    public void createBestCar(Builder builder){
        builder.setConvertible(true);
        builder.setDoors(2);
        builder.setWheels(4);
    }

    public void createBadCar(Builder builder){
        builder.setConvertible(true);
        builder.setDoors(8);
        builder.setWheels(1);
    }
}
