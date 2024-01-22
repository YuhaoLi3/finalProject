public class Customer {
    private static String name;
    public static String pin;
    public Customer(String name, String pin){
        this.name = name;
        this.pin = pin;
    }
    public static void updatePin(String num){
        pin = num;
    }

    public static String getName() {
        return name;
    }
    public String getPin() {
        return pin;
    }
    public void updateName(String name){
        this.name  = name;
    }
}
