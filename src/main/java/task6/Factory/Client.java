package task6.Factory;

public class Client {
    public static void main(String[] args) {
        DNS dns = new DNS();
        Keybord keybord = dns.createK();
        keybord.sound();
        Mouse mouse = dns.createM();
        mouse.sound();

        Citilink citilink = new Citilink();
        Keybord keybordC = citilink.createK();
        keybordC.sound();
        Mouse mouseC = citilink.createM();
        mouseC.sound();
    }
}
