package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000,
        // throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000) throw new RuntimeException("Insufficient Balance");


    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean isValid=true;
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                isValid=false;
                break;
            }
        }
        if(!isValid){
            char[]chars=tradeLicenseId.toCharArray();
            for(int i=0;i< chars.length-1;i++){
                if(chars[i]==chars[i+1]){
                    for(int j=0;j<chars.length;j++){
                        if(chars[j]!=chars[i] && (i==0 || chars[j]!=chars[i-1] )){
                            char temp=chars[i];
                            chars[i]=chars[j];
                            chars[j]=temp;

                            isValid=true;
                            for(int k=0;k<chars.length-1;k++){
                                if(chars[k]==chars[k+1]){
                                    isValid=false;
                                    break;
                                }
                            }
                            if(isValid){
                                tradeLicenseId=new String(chars);
                                return;
                            }
                        }
                    }
                    throw new RuntimeException("Valid License can not be generated");
                }
            }
        }
    }

}
