public class Customer {
    private String name;
    private String pin;
    public Customer(String name, String pin){
        this.name = name;
        this.pin = pin;
    }
    public void updatePin(String num){
        pin = num;
    }
    public void updateName(String name){
        this.name  = name;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }
}
