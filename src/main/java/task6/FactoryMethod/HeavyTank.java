package task6.FactoryMethod;

public class HeavyTank implements Tank {
    @Override
    public void drive() {
        System.out.println("Медленно...");
    }
}
