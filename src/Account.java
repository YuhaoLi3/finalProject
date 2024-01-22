import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Account {
    public static double checking;
    public static double saving;
//    transactionID will be tracked in Account class instead of TransactionHistory.
    public static final DecimalFormat transactionID = new DecimalFormat("0000");
    public static int transaction = 0;

    private static final Scanner scan = new Scanner(System.in);


    public Account(double checking, double saving) {
        this.checking = checking;
        this.saving = saving;
    }


    public static void addChecking(double amount) {
        checking += amount;
        System.out.println("Deposited $" + ConsoleUtility.GREEN+amount + ConsoleUtility.RESET +  " into checking | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
        TransactionHistory.addHistory("Deposited $" + ConsoleUtility.GREEN+amount + ConsoleUtility.RESET + " into checking | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+"\n");
        transaction++;
    }


    public static void addSaving(double amount) {
        saving += amount;
        System.out.println("Deposited $" + ConsoleUtility.GREEN+amount + ConsoleUtility.RESET+" into savings | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
        TransactionHistory.addHistory("Deposited $" + ConsoleUtility.GREEN+amount + ConsoleUtility.RESET+" into savings Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+"\n");
        transaction++;
    }


    public static void subChecking(double amount) {
        if (checking - amount >= 0) {
            if (amount % 5 == 0) {
                checking -= amount;
                while (true) {
                    System.out.println("how many 20 dollar bills would you like?");
                    int twenty = scan.nextInt();
                    System.out.println("how many 5 dollar bills would you like?");
                    int five = scan.nextInt();
                    if(amount - (20 * twenty) - (5 * five) == 0){
                        System.out.println("Withdrawn $" + ConsoleUtility.RED+amount + ConsoleUtility.RESET + " from checking--20 dollar bills:" + twenty + " | 5 dollar bills:" + five+" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
                        TransactionHistory.addHistory("Withdrawn $" + ConsoleUtility.RED+amount + ConsoleUtility.RESET + " from checking--20 dollar bills:" + twenty + "| 5 dollar bills: " + five + " | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+"\n");
                        //increase the transaction ID by one
                        transaction++;
                        break;
                    }else if(amount - (20 * twenty) - (5 * five) <= 0){
                        System.out.println("not possible!");
                    }else if (amount - (20 * twenty) - (5 * five) >= 0){
                        double x = (amount - (20 * twenty) - (5 * five)) /5;
                        System.out.println("your remanding $"+ ConsoleUtility.GREEN+(int)((amount - (20 * twenty) - (5 * five)))+ConsoleUtility.RESET+" has been been into "+(int)x +" 5 dollar bills");
                        System.out.println("Withdrawn $" + ConsoleUtility.RED+amount + ConsoleUtility.RESET + " from checking--20 dollar bills:" + twenty + " | 5 dollar bills: " + (int)(five + x)+" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
                        TransactionHistory.addHistory("Withdrawn $" + ConsoleUtility.RED+amount + ConsoleUtility.RESET + " from checking--20 dollar bills:" + twenty + " | 5 dollar bills: " + (int)(five + x) + " Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+"\n");
                        transaction++;
                        break;
                    }
                }
            } else {
                System.out.println("the bank can only withdraw amount in 5 or 25 dollar bills");
            }
        }else {
            System.out.println("insufficient funds!");
        }
    }


    public static void subSaving(double amount) {
        if (saving - amount >= 0) {
            if (amount % 5 == 0) {
                saving -= amount;
                while(true) {
                    System.out.println("how many 20 dollar bills would you like?");
                    int twenty = scan.nextInt();
                    System.out.println("how many 5 dollar bills would you like?");
                    int five = scan.nextInt();
                    if(amount - (20 * twenty) - (5 * five) == 0){
                        System.out.println("Withdrawn $" + ConsoleUtility.RED+amount + ConsoleUtility.RESET + " from saving--20 dollar bills: " + twenty + " | 5 dollar bills: " + five+" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
                        TransactionHistory.addHistory("Withdrawn $" + ConsoleUtility.RED+amount + ConsoleUtility.RESET + " from saving- 20 dollar bills: " + twenty + "| 5 dollar bills:" + five + " | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+" \n");
                        transaction++;
                        break;
                    }else if(amount-(20 * twenty)-(5 * five) <= 0){
                        System.out.println("insufficient funds!");
                    }else if (amount-(20 * twenty) - (5 * five) >= 0){
                        double x = (amount - (20 * twenty) - (5 * five)) / 5;
                        System.out.println("your remanding $"+ ConsoleUtility.GREEN+(int)((amount - (20 * twenty) - (5 * five)))+ConsoleUtility.RESET+" has been been into "+(int)x +" 5 dollar bills");
                        System.out.println("Withdrawn $" + ConsoleUtility.RED+amount + ConsoleUtility.RESET+" from saving--20 dollar bills: " + twenty + " | 5 dollar bills: " + (int)(five + x)+" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
                        TransactionHistory.addHistory("Withdrawn $" + amount + " from saving--20 dollar bills:" + twenty + " | 5 dollar bills " + (int)(five + x)+ " | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+" \n");
                        transaction++;
                        break;
                    }
                }
            } else {
                System.out.println("the bank can only withdraw amount in 5 or 25 dollar bills");
            }
        } else {
            System.out.println("insufficient funds!");
        }
    }


    public static void CheckingsToSavings(double amount) {
        if (checking - amount >= 0) {
            checking -= amount;
            saving += amount;
            System.out.println("transferred$ " +ConsoleUtility.PURPLE+ amount + ConsoleUtility.RESET+  " from checking to savings"+" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
            TransactionHistory.addHistory("transferred$" + ConsoleUtility.PURPLE+ amount + ConsoleUtility.RESET+ " from checking to savings"+" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+" \n");
            transaction++;
        } else {
            System.out.println("insufficient funds!");
        }
    }


    public static void SavingsToChecking(double amount) {
        if (saving - amount >= 0) {
            checking += amount;
            saving -= amount;
            System.out.println("transferred$" +ConsoleUtility.PURPLE+ amount + ConsoleUtility.RESET+" from savings to checking"+" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET);
            TransactionHistory.addHistory("transferred$" + ConsoleUtility.PURPLE+ amount + ConsoleUtility.RESET+ " from savings to checking" +" | Transaction ID:A"+ConsoleUtility.YELLOW+transactionID.format(transaction)+ConsoleUtility.RESET+" \n");
        } else {
            System.out.println("insufficient funds!");
        }
    }
}




