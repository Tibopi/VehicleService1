package pl.kurs.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountService {
    private List<BankAccount> accounts;                 //pole
    private Scanner scanner;


    public BankAccountService(Scanner scanner) {
        this.scanner = scanner;
        initializeBankAccounts();

    }                       //klasy


    //metody
    public BankAccount getUserBankAccount(int nrkonta) {                //metoda ktora zwroci BankAccount o nazwie getUserBankAccount (ktora dostanie int nrkonta z metody wyzej)
        for (BankAccount account : accounts) {
            if (nrkonta == account.getAccountnumbe()) {
                System.out.println("Podaj pin");
                int pin = scanner.nextInt();
                if (pin == account.getPin()) {
                    return account;
                }
            }
        }
        return null;
    }

    private void initializeBankAccounts() {
        accounts = new ArrayList<>();
        accounts.add(new BankAccount(111, "Klaudisz", 1234, 150000000));
        accounts.add(new BankAccount(222, "Rafał", 2345, 45000));
        accounts.add(new BankAccount(333, "Kuba", 3456, 650000));
    }
}











