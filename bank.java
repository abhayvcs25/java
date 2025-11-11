abstract class bank{
    String customername;
    int accountnumber;
    float balanceamount;
    abstract void deposit(float amount);
    abstract void withdraw(float amount);
    abstract void displaybalance();
}

class savingacc extends bank{
    savingacc(String c_name, int accnum, float bal){
        customername = c_name;
        accountnumber = accnum;
        balanceamount = bal;
    }
    void deposit(float amt){
        balanceamount += amt;
    }
    void withdraw(float amt){
        if(amt<=balanceamount){
            balanceamount -= amt;
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    void displaybalance(){
        System.out.println("Customer Name: " + customername);
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Balance Amount: " + balanceamount);
    }
     void interest(){
        balanceamount += balanceamount * 0.07;
    }
}

class currentacc extends bank{
    currentacc(String c_name, int accnum, float bal){
        customername = c_name;
        accountnumber = accnum;
        balanceamount = bal;
    }
    void deposit(float amt){
        balanceamount += amt;
    }
    void withdraw(float amt){
        if(amt<=balanceamount && (balanceamount - amt) >= 500){
            balanceamount -= amt;
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    void displaybalance(){
        System.out.println("---------------------");
        System.out.println("Customer Name: " + customername);
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Balance Amount: " + balanceamount);
        System.out.println("---------------------");
    }
}
   

class bankapp{
    public static void main(String args[]){
        int s=0,c=0,action,flag = 0;

        savingacc[] savacc = new savingacc[10];
        currentacc[] curacc = new currentacc[10];

        while (true){
            System.out.println("1. Create Saving Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice:");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1){
                System.out.print("Enter Customer Name:");
                String name = sc.next();
                System.out.print("Enter Account Number:");
                int accnum = sc.nextInt();
                System.out.print("Enter Initial Balance:");
                float bal = sc.nextFloat();
                savacc[s++] = new savingacc(name, accnum, bal);
            }
            else if (choice == 2){
                System.out.print("Enter Customer Name:");
                String name = sc.next();
                System.out.print("Enter Account Number:");
                int accnum = sc.nextInt();
                System.out.print("Enter Initial Balance:");
                float bal = sc.nextFloat();
                curacc[c++] = new currentacc(name, accnum, bal);
            }
            else if (choice == 3){
                break;
            }
            else{
                System.out.println("Invalid choice");
            }   
            action = 0;
            while(action != 4){
                System.out.println("----Menu----");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your action:");
                action = sc.nextInt();
            
                switch(action){
                    case 1 : System.out.print("Enter account number:");
                            int accnum = sc.nextInt();
                            System.out.print("Enter amount to deposit:");
                            float amt = sc.nextFloat();
                             for(int i=0; i<s; i++){
                                if(savacc[i].accountnumber == accnum){
                                    savacc[i].deposit(amt);
                                    flag = 1;
                                    break;
                                }
                            }
                            for(int i=0; i<c; i++){
                                if(curacc[i].accountnumber == accnum){
                                    curacc[i].deposit(amt);
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0){
                                    System.out.println("Account not found in current accounts");
                                }
                            break;
                    case 2 : System.out.print("Enter account number:");
                            accnum = sc.nextInt();
                            System.out.print("Enter amount to withdraw:");
                                amt = sc.nextFloat();
                                for(int i=0; i<s; i++){
                                    if(savacc[i].accountnumber == accnum){
                                        savacc[i].withdraw(amt);
                                        flag=1;
                                        break;
                                    }
                                }
                                for(int i=0; i<c; i++){
                                    if(curacc[i].accountnumber == accnum){
                                        curacc[i].withdraw(amt);
                                        flag=1;
                                        break;
                                    }
                                }
                                if(flag==0){
                                    System.out.println("Account not found in current accounts");
                                }
                                break;
                    case 3 : System.out.print("Enter account number to display:");
                                accnum = sc.nextInt();
                                for(int i=0; i<s; i++){
                                    if(savacc[i].accountnumber == accnum){
                                        savacc[i].displaybalance();
                                        flag=1; 
                                        break;
                                    }
                                   
                                }
                                for(int i=0; i<c; i++){
                                    if(curacc[i].accountnumber == accnum){
                                        curacc[i].displaybalance();
                                        flag=1;
                                        break;
                                    }
                                }
                                if(flag==0){
                                    System.out.println("Account not found in current accounts");
                                }
                                break;
                    case 4 :break;    
                    default:System.out.print("Invalid choice");
                            break;
                }
            }
        }
    }
}