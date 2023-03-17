package task6.FactoryMethod;

public abstract class Factory {
    public Tank driveTAnk(){
        Tank tank = createTank();
        tank.drive();
        return tank;
    }

    abstract Tank createTank();
}
