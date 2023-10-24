import Config.Peripheral;

public class App {
    public static void main(String[] args) {
        Peripheral peripheral = new Peripheral();
        peripheral.banner();
        while (peripheral.loop) {
            peripheral.daftarMenu();
            peripheral.runMenu();
        }
    }
}
