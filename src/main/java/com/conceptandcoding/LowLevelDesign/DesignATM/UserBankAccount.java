package com.conceptandcoding.LowLevelDesign.DesignATM;

public class UserBankAccount {

    int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }
}
