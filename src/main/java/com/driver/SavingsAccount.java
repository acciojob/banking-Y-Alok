package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;


    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        if(amount>maxWithdrawalLimit){
            throw new RuntimeException("Maximum Withdraw Limit Exceed");
        }else if(amount>super.getBalance()){
            throw new RuntimeException("Maximum Withdraw Limit Exceed");
        }else{
            super.setBalance(super.getBalance()-amount);
        }
        // 2. "Insufficient Balance" : If the amount exceeds balance


    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double si=(super.getBalance()*rate*years)/100;
        return super.getBalance()+si;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double amt=Math.pow(1+(this.rate/100),years);
        double fAmt=this.getBalance()*amt;
        return this.getBalance()+fAmt;
    }

}
