
import java.util.Scanner;

public class ATM {
   
    private int accountno;
    private  int pin ;
    private double balance ;
    public static int account_cnt=10000;
    
    
    ATM(int pin,double balance){
         
        account_cnt ++;
        accountno=account_cnt;
        this.pin=pin;
        this.balance=balance;

    } 
    public int get_accountno(){
        return account_cnt;

    }
    public void  showbalance(){
       
        System.out.println("Balance : "+balance);

    }
    public void deposit(double ammount ){

        balance = ammount+balance;
        System.out.println("Deposited Ammount is : "+ammount );

   }
   public void withdraw(double ammount,int pin ) { 
        if(this.pin==pin){
            
            if (balance>ammount && ammount>0) {
            balance =balance - ammount;
              System.out.println( " Ammount Withdrawn : "+ammount);
            }
            else{
               throw new IllegalArgumentException("Insufficient balance or ammount is less then 1");
            }
        }
        
        
        else {
            throw new  SecurityException("Incorrect PIN");
        }
 

}


public static void main(String[] args) {

    Scanner sc= new Scanner(System.in);
    System.out.print("Set pin number  : ");
    int pin=sc.nextInt();
    System.out.print("Set initial Balance: ");
    int balance=sc.nextInt();
    ATM at1=new ATM(pin,balance);


    while (true){

        System.out.println("ATM simulator");
        System.out.println("1. check balance ");
        System.out.println("2. Get Account number");
        System.out.println("3. Withdraw");
        System.out.println("4. Deposit");
        System.out.println("5. EXIT");
        System.out.println("Choose your choice (1,2,3,4,5)");
        int choice = sc.nextInt();


        switch(choice){


            case 1: 
            at1.showbalance();
            break;

            case 2:
            System.out.println(at1.get_accountno());
            break;

            case 3:
            System.out.println("Enter ammout to withdraw :");
            int ammount=sc.nextInt();
            System.out.println("Enter the PIN ");
            int PIN= sc.nextInt();
            try{
            at1.withdraw(ammount, PIN);
            }
            catch(SecurityException se ){
                System.out.println(se.getMessage());


            }  
            break;

            case 4:
            System.out.println("Enter ammount to deposit ");
            ammount= sc.nextInt();
            at1.deposit(ammount);
            break;

            case 5:
            return;

            default:
            System.out.println("Invalid Input ");
            break;


        }

    }
}
}
