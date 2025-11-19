import java.util.Scanner;

abstract class bank {
    String customername;
    int accountnumber;
    float balanceamount;

    abstract void deposit(float amount);
    abstract void withdraw(float amount);
    abstract void displaybalance();
}

class savingacc extends bank {
    savingacc(String c_name, int accnum, float bal) {
        customername = c_name;
        accountnumber = accnum;
        balanceamount = bal;
    }             

    void deposit(float amt) {
        balanceamount += amt;
    }

    void withdraw(float amt) {
        if (amt <= balanceamount) {
            balanceamount -= amt;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displaybalance() {
        System.out.println("---------------------");
        System.out.println("Customer Name: " + customername);
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Balance Amount: " + balanceamount);
        System.out.println("---------------------");
    }

    void computeInterest() {
        float interest = balanceamount * 0.07f;
        balanceamount += interest;
        System.out.println("Interest added: " + interest);
    }
}

class currentacc extends bank {
    final float MIN_BAL = 500;
    final float SERVICE_CHARGE = 50;

    currentacc(String c_name, int accnum, float bal) {
        customername = c_name;
        accountnumber = accnum;
        balanceamount = bal;
    }

    void deposit(float amt) {
        balanceamount += amt;
    }

    void withdraw(float amt) {
        if (amt <= balanceamount) {
            balanceamount -= amt;
            if (balanceamount < MIN_BAL) {
                System.out.println("Balance below minimum! Imposing service charge...");
                balanceamount -= SERVICE_CHARGE;
            }
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displaybalance() {
        System.out.println("---------------------");
        System.out.println("Customer Name: " + customername);
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Balance Amount: " + balanceamount);
        System.out.println("---------------------");
    }
}

public class bankapp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        savingacc savacc = null;
        currentacc curacc = null;

        System.out.println("1. Create Saving Account");
        System.out.println("2. Create Current Account");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter Customer Name: ");
        String name = sc.next();
        System.out.print("Enter Account Number: ");
        int accnum = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        float bal = sc.nextFloat();

        switch (choice) {
            case 1 -> savacc = new savingacc(name, accnum, bal);
            case 2 -> curacc = new currentacc(name, accnum, bal);
            default -> {
                System.out.println("Invalid choice!");
                return;
            }
        }

        int action;
        do {
            System.out.println("---- Menu ----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (choice == 1) 
                {System.out.println("4. Compute Interest");}
            System.out.println("0. Exit");
            System.out.print("Enter your action: ");
            action = sc.nextInt();

            switch (action) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    float amt = sc.nextFloat();
                    if (choice == 1) savacc.deposit(amt);
                    else curacc.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    float amt = sc.nextFloat();
                    if (choice == 1){
                        System.out.println("Enter the cheque num = ");
                        int cheque = sc.nextInt();
                        savacc.withdraw(amt);
                    } 
                    else curacc.withdraw(amt);
                }
                case 3 -> {
                    if (choice == 1) savacc.displaybalance();
                    else curacc.displaybalance();
                }
                case 4 -> {
                    if (choice == 1) savacc.computeInterest();
                    else System.out.println("No interest for current account.");
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid action.");
            }
        } while (action != 0);

        sc.close();
    }
}
