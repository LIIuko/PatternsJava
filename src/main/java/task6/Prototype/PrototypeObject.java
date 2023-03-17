package task6.Prototype;

public class PrototypeObject implements Prototype{
    private Type type;
    public enum Type {
        ONE, TWO
    }

    public Type getType() {
        return type;
    }

    @Override
    public PrototypeObject clone() {
        return new PrototypeObject();
    }
    public void setType(Type type) {
        this.type = type;
    }

}
