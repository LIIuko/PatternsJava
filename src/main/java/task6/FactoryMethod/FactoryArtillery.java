package task6.FactoryMethod;

public class FactoryArtillery extends Factory{
    @Override
    Tank createTank() {
        return new Artillery();
    }
}
