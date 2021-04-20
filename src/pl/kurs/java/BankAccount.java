package pl.kurs.java;


public class BankAccount {
    //konstuktor bankaccount TAK
    //getery setery TAK
    private int accountnumber;
    private String owner;
    private int pin;
    private int balance;


    public BankAccount(int accountnumber, String owner, int pin, int balance) {
        this.accountnumber = accountnumber;
        this.owner = owner;
        this.pin = pin;
        this.balance = balance;

    }

    public int getAccountnumbe() {
        return accountnumber;
    }

    public int getPin() {
        return pin;
    }
    public String getOwner(){ return owner;}

    public int getBalance() {
        return balance;
    }

    public void removeBalance(int amount) {
        balance -= amount; // balance = balance - amount;
    }

    public void addBalance(int amount) {
        balance += amount;}
}
