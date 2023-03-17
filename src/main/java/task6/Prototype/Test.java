package task6.Prototype;

public class Test {
    public static void main(String[] args) {
        PrototypeObject prototype = new PrototypeObject();
        System.out.println(prototype.getType());
        PrototypeObject clone = prototype.clone();
        System.out.println(clone.getType());
        clone.setType(PrototypeObject.Type.TWO);
        System.out.println(clone.getType());
    }
}
