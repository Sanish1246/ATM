
package com.mycompany.finalproject;


import javax.swing.JOptionPane; //needed for display the dialogue boxes


public class Account {
int Balance;
String AccountNo;


  public Account() {   //Constructor used to initialize AccountNo and Balance
    AccountNo = "123456789"; 
    Balance = 50000;
  }
  
  public Account(String NewAccountNo,int NewBalance) {    //Second Consdtructor to assign AccountNo and Balance values input by user
     AccountNo = NewAccountNo;
    Balance = NewBalance;
  }
  
  public int getBalance() { //Getter method
      return Balance;
  }
  
  public String getAccountNo() {
      return AccountNo;
  }
  
  public void setBalance(int NewBalance) {  //Setter method
      Balance=NewBalance;
  }
  
  public void setAccountNo(String NewAccountNo) {
      AccountNo=NewAccountNo;
  }
  
  public void DisplayDetails() {
      JOptionPane.showMessageDialog(null, "Account Number: " + AccountNo
       + "\n" + "Balance: RS " + Balance);  
      
  }
  
  public void Withdrawal(int CashChoice){  //Procedure used to perform withdrawal operation
      Balance = Balance-CashChoice;
  }
  
  public void Deposit(int CashDeposit) {  ///Procedure used to perform deposit operation
      Balance = Balance+CashDeposit;
  }
  
 
 
}
