package task6.Factory;

public class DNS implements Factory{
    @Override
    public Keybord createK() {
        return new MechanicalK();
    }

    @Override
    public Mouse createM() {
        return new WirelessM();
    }
}
