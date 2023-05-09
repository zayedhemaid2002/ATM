package javaapplication67;
import java.util.ArrayList;
import java.util.Scanner;

class BankAccount{
    
    private double balance;
    
    public BankAccount(){
        
        this.balance = 0.0;
    }
    
    public void deposite(double amount){
        
        this.balance += amount;
    }
    public void withdrow(double amount){
        
        this.balance -= amount;
    }
       
    public double getBalance(){
        
        return this.balance;
    }
}

class Customer{
    
    private int number;
    private int pin;
    private BankAccount checking;
    private BankAccount saving;
    
    public Customer(){
        
        this.number = 1;
        this.pin = 1234;
        this.checking = new BankAccount();
        this.saving = new BankAccount();
    }
    public Customer(int number, int pin){
        
        this.number = number;
        this.pin = pin;
        this.checking = new BankAccount();
        this.saving = new BankAccount();
    }
    
    public void setNumber(int number){
        
        this.number = number;
    }
    public void setPIN(int pin){
        
        this.pin = pin;
    }
    public void setChecking(BankAccount checking){
        
        this.checking = checking;
    }
    public void setSaving(BankAccount saving){
        
        this.saving = saving;
    }
    
    public int getNumber(){
        
        return this.number;
    }
    public int getPIN(){
        
        return this.pin;
    }
    
    public BankAccount checking(){
             
        return this.checking;
    }
    public BankAccount saving(){
        
        return this.saving;
    }
}

class Bank{
    
    private ArrayList<Customer> customers;
    
    public Bank(){
        
        this.customers = new ArrayList<>();
    }
    
    public void setCustomers(ArrayList<Customer> customers){
        
        this.customers = customers;
    }
    public ArrayList<Customer> getCustomers(){
        
        return this.customers;
    }
}

class ATM{
    
    private Scanner in = new Scanner(System.in); 
    private int num;
    private Bank bank;
    private int number;
    private int pin;
    
    public ATM(){
        
        this.num = 1;
        this.bank = new Bank();
        setCustomersInBank();
    }
    
    private void setCustomersInBank(){
        
        ArrayList<Customer> customers = new ArrayList<>();
          customers.add(new Customer(1, 1234));
          customers.add(new Customer(2, 2345));
          customers.add(new Customer(3, 4567));
          customers.add(new Customer(4, 3210));
          
        this.bank.setCustomers(customers);
    }
    
    public Bank getBank(){
        
        return this.bank;
    }
    
    public void machine(){
        
        while(this.num != 0){
            System.out.print("Enter acustomer number: ");
            this.number = in.nextInt();
            System.out.print("Enter PIN : ");
            this.pin = in.nextInt();
            
            boolean flag = false;
            int i=0;
            for(; i<this.bank.getCustomers().size(); i++)
                if(this.bank.getCustomers().get(i).getNumber() == this.number &&
                    this.bank.getCustomers().get(i).getPIN() == this.pin){
                    
                    flag = true;
                    break;
                }
            
            if(flag){
                char c = ' ';
                while(c != 'c' && c != 'C'){
                    System.out.print("A: Checking, B: Saving, C: Quit :: ");
                    c = in.next().charAt(0);
                    
                    if(c != 'c' && c != 'C'){
                        if(c == 'a' || c == 'A')
                            System.out.println("Balance: "+this.bank.getCustomers().get(i).checking().getBalance());
                        else
                            System.out.println("Balance: "+this.bank.getCustomers().get(i).saving().getBalance());                   
                        
                        System.out.print("A: Deposite, B: Withdrow, C: Cancel :: ");
                        char cc = in.next().charAt(0);
                        double am = 0;
                        switch(cc){                                  
                            case 'a'|'A':
                                System.out.print("Amount: ");
                                am = in.nextDouble();
                                if(c == 'a' || c == 'A')
                                    this.bank.getCustomers().get(i).checking().deposite(am);
                                else
                                    this.bank.getCustomers().get(i).saving().deposite(am);
                                break;
                            case 'b'|'B':
                                System.out.print("Amount: ");
                                am = in.nextDouble();
                                if(c == 'a' || c == 'A')
                                    this.bank.getCustomers().get(i).checking().withdrow(am);
                                else
                                    this.bank.getCustomers().get(i).saving().withdrow(am);
                                break; 
                        }                       
                    }
                }
            }
            else
                System.out.println("  This customer is not found");
        }
    }
}

public class ATMSimulation
{
    
    public static void main(String[] args) {
        
        ATM atm = new ATM();
          atm.machine();       
    }  
}