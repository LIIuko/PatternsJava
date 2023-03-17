package task6.FactoryMethod;

public class FactoryLight extends Factory{
    @Override
    Tank createTank() {
        return new LightTank();
    }
}
