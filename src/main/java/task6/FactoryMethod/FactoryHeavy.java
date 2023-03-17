package task6.FactoryMethod;

public class FactoryHeavy extends Factory{
    @Override
    Tank createTank() {
        return new HeavyTank();
    }
}

