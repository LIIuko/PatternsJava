package task6.Factory;

public class Citilink implements Factory{
    @Override
    public Keybord createK() {
        return new MembraneK();
    }

    @Override
    public Mouse createM() {
        return new WiredM();
    }
}
