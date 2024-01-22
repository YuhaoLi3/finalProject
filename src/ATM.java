import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.DecimalFormat;
public class ATM {
    public String pin;
    public String name;
    private static final Scanner scan = new Scanner(System.in);
    public final DecimalFormat securityID = new DecimalFormat("0000");
    public int security = 0;
    private boolean on = true;
    public ATM() {
    }




    public void start() {
        welcome();
        Menu();
    }




    private void welcome() {
        Scanner scan = new Scanner(System.in);
        System.out.println("welcome to yuhao's ATM\uD83C\uDFE7");
        try {
            Thread.sleep(1000);  // 1000 milliseconds, or 1 seconds
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("what is your name?");
        String name = scan.nextLine();
        this.name = name;
        //clears the screen
        ConsoleUtility.clearScreen();
        try {
            Thread.sleep(1000);  // 1000 milliseconds, or 1 seconds
        } catch (Exception e) {
            System.out.println("error");
        }

        System.out.println("choose your pin!\uD83D\uDD10");
        String firstPin = scan.nextLine();
        this.pin =firstPin;
        customer.updatePin(pin);
        customer.updateName(name);
    }




    Customer customer = new Customer(name, pin);




    private void Menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your pin\uD83D\uDD10");
        String checkPin = scan.nextLine();
        try {
            Thread.sleep(1000);  // 1000 milliseconds, or 1 seconds
        } catch (Exception e) {
            System.out.println("error");
        }
        ConsoleUtility.clearScreen();
        while(true) {
            //if pin in answer correctly, prints the menu our. there is alot of emoji which is why it looks weird
            if (checkPin.equals(Customer.pin)) {
                System.out.println("\uD83C\uDF1F═════════════════════════════════\uD83C\uDF1F\n" +
                        "         \uD835\uDCDC\uD835\uDCEE\uD835\uDCF7\uD835\uDCFE \uD835\uDCDE\uD835\uDCF9\uD835\uDCFD\uD835\uDCF2\uD835\uDCF8\uD835\uDCF7\uD835\uDCFC           \n" +
                        "\uD83C\uDF1F═════════════════════════════════\uD83C\uDF1F\n" +
                        "1\uFE0F⃣  Withdraw money       \uD83D\uDCB8\n" +
                        "2\uFE0F⃣  Deposit money        \uD83D\uDCB0\n" +
                        "3\uFE0F⃣  Transfer money       \uD83D\uDD04\n" +
                        "4\uFE0F⃣  Get account balances \uD83D\uDCCA\n" +
                        "5\uFE0F⃣  Transaction history  \uD83D\uDCDC\n" +
                        "6\uFE0F⃣  Change PIN           \uD83D\uDD10\n" +
                        "7\uFE0F⃣  Exit                 \uD83D\uDEAA\n" +
                        "\uD83C\uDF1F═════════════════════════════════\uD83C\uDF1F");
                int num = scan.nextInt();
                scan.nextLine();
                choices(num);
                break;
            }else{
                System.out.println("you entered the wrong pin!!");
                System.out.println("Enter your pin\uD83D\uDD10");
                 checkPin = scan.nextLine();
            }
        }
        goon();
    }
    private void goon(){
        ConsoleUtility.clearScreen();
        while (on) {
            System.out.println("do you want to continue?(no)to exit");
            String answer  = scan.nextLine();
            if (answer.equals("no")){
                ConsoleUtility.clearScreen();
                System.out.println("thank you for being a customer! see you again soon");
                break;
            }
            System.out.println("Enter your pin\uD83D\uDD10");
            String checkPinAgain = scan.nextLine();
            if (checkPinAgain.equals(Customer.pin)) {
                try {
                    Thread.sleep(1000);  // 1000 milliseconds, or 1 seconds
                } catch (Exception e) {
                    System.out.println("error");
                }
                System.out.println("\uD83C\uDF1F═════════════════════════════════\uD83C\uDF1F\n" +
                        "         \uD835\uDCDC\uD835\uDCEE\uD835\uDCF7\uD835\uDCFE \uD835\uDCDE\uD835\uDCF9\uD835\uDCFD\uD835\uDCF2\uD835\uDCF8\uD835\uDCF7\uD835\uDCFC           \n" +
                        "\uD83C\uDF1F═════════════════════════════════\uD83C\uDF1F\n" +
                        "1\uFE0F⃣  Withdraw money       \uD83D\uDCB8\n" +
                        "2\uFE0F⃣  Deposit money        \uD83D\uDCB0\n" +
                        "3\uFE0F⃣  Transfer money       \uD83D\uDD04\n" +
                        "4\uFE0F⃣  Get account balances \uD83D\uDCCA\n" +
                        "5\uFE0F⃣  Transaction history  \uD83D\uDCDC\n" +
                        "6\uFE0F⃣  Change PIN           \uD83D\uDD10\n" +
                        "7\uFE0F⃣  Exit                 \uD83D\uDEAA\n" +
                        "\uD83C\uDF1F═════════════════════════════════\uD83C\uDF1F");
                int num = scan.nextInt();
                scan.nextLine();
                choices(num);
            }
        }
    }

    private void choices(int num){
        if ((num == 1)) {
            System.out.println("would you like to Withdraw money from checking or savings");
            String respond = scan.nextLine();
            if (respond.equals("checking") && Account.checking != 0) {
                System.out.println("how much would you like to Withdraw");
                int amount = scan.nextInt();
                scan.nextLine();
                Account.subChecking(amount);
            } else if (respond.equals("savings")&&Account.saving != 0) {
                System.out.println("how much would you like to Withdraw");
                int amount = scan.nextInt();
                scan.nextLine();
                Account.subSaving(amount);
            }else if(respond.equals("checking") && Account.checking == 0){
                System.out.println("no money in checking");
            }else if(respond.equals("savings") &&Account.saving == 0){
                System.out.println("no money in saving");
            } else{
                System.out.println("error, please try again!");
            }
        }
        if (num == 2) {
            System.out.println("would you like to deposit money into checking or savings");
            String respond = scan.nextLine();
            if (respond.equals("checking")) {
                System.out.println("how much would you like to deposit");
                int amount = scan.nextInt();
                scan.nextLine();
                Account.addChecking(amount);
            } else if (respond.equals("savings")) {
                System.out.println("how much would you like to deposit");
                int amount = scan.nextInt();
                scan.nextLine();
                Account.addSaving(amount);
            }
        }
        if (num == 3) {
            System.out.println("would you like to transfer money from checking to savings(c2s) or savings to checking(s2c)");
            String respond = scan.nextLine();
            if (respond.equals("c2s")) {
                System.out.println("how much would you like to transfer");
                int amount = scan.nextInt();
                scan.nextLine();
                Account.CheckingsToSavings(amount);
            } else if (respond.equals("s2c")) {
                System.out.println("how much would you like to transfer");
                int amount = scan.nextInt();
                scan.nextLine();
                Account.SavingsToChecking(amount);
            }
        }
        if(num == 4){
            System.out.println("checking account:"+ConsoleUtility.PURPLE+Account.checking+ConsoleUtility.RESET+"\nsaving account:"+ConsoleUtility.CYAN+Account.saving+ConsoleUtility.RESET+"\nsecurity ID: S"+ConsoleUtility.BLUE+securityID.format(security)+ConsoleUtility.RESET);
            //increase security ID by one.
            security++;

        }
        if(num == 5){
            System.out.println("security ID: S"+ConsoleUtility.BLUE+securityID.format(security)+ConsoleUtility.RESET);
            security++;
            System.out.println(TransactionHistory.history);
        }
        if(num == 6){
            System.out.println("what would you like your new pin to be?");
            String pin = scan.nextLine();
            Customer.updatePin(pin);
            System.out.println("changed PIN");
            System.out.println("security ID: S"+ConsoleUtility.BLUE+securityID.format(security)+ConsoleUtility.RESET);
            security++;
        }
        if (num == 7){
            System.out.println("thank you for being a customer " +Customer.getName()+"! see you again soon 😎😎😎");
            on =false;
        }
    }



}


