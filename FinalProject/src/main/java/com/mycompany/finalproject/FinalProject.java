//Please read the README.txt before running the program

package com.mycompany.finalproject;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane; //needed for display the dialogue boxes
import javax.swing.JFrame; //Needed to create and display the frames
import javax.swing.JLabel; //Needed to create and attach labels
import java.io.BufferedReader; //Needed for the BufferedReader class
import java.io.FileReader; //Needed for the FileReader class to read the lines from the file
import java.io.IOException; //Needed for exception handling when reading the file
import java.nio.file.Files; //used to import the Files class from the java.nio.file
import java.nio.file.Path; //Used for the path object
import java.nio.file.Paths; //Used for the path object
import java.util.List; //Needed to create a list
import java.util.stream.Collectors; //used to import the Collectors class
import java.util.stream.Stream; //used to import the Stream
import javax.swing.JButton;
import java.util.*;
import javax.swing.*;

public class FinalProject extends JFrame implements ActionListener {

  JButton Button1, Button2, Button3, Button4, Button5, Button6, Button7;
  JButton ButtonOK, ButtonSubmit, ButtonWithdraw, ButtonDeposit, ButtonChange;
  JButton Button500, Button1000, Button1500, Button2000;
  JFrame frame, frame2, frame3;
  JFrame FastCash, Withdraw, Deposit, ChangePIN;
  JTextField textField, WithdrawField, DepositField, ChangeField;

  public static void main(String[] args) {
    int InputPIN;
    int Attempts;
    boolean Correct;

    ATM myATM = new ATM(); //Instantiating an object of type ATM
    Card myCard = new Card(); //Instantiating an object of type Card
    FinalProject MainMenu = new FinalProject();

  }

  public FinalProject() {
    JLabel Label, Label1;
    frame2 = new JFrame(); //Creating an object of type JFrame
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default closing operation
    ATM myATM = new ATM(); //Instantiating an object of type ATM

    frame2.setTitle("Main menu");
    Label = new JLabel("<html><font color='green'>Welcome to MDX banking!<br>" +
      "Please insert your card!</font></html>");

    frame2.getContentPane().add(Label); //Adds the Label to the frame
    frame2.getContentPane().setBackground(Color.CYAN); // Sets the background color to cyan
    frame2.pack();

    frame2.setBounds(0, 0, 300, 300); //The size of the frame
    frame2.setLocationRelativeTo(null); //Centers the frame relative to the screen
    Container container = frame2.getContentPane(); //Creates a container to contain the JButtons
    container.setLayout(null);
    Label.setLocation(70, 20);  // Location of the label
    Label.setSize(200, 100);  //Size of the label

    ButtonOK = new JButton("OK");
    ButtonOK.setBounds(90, 100, 100, 50);
    ButtonOK.setBackground(new Color(255, 230, 230)); //sets the background color of the button to metal
    container.add(ButtonOK); // Adds the button to the container
    ButtonOK.addActionListener(this);  // Links the button to the ActionListener

    frame3 = new JFrame();
    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default closing operation
    frame3.getContentPane().setBackground(Color.CYAN);
    frame3.setLayout(new FlowLayout());

    frame3.setTitle("Main menu");
    Label1 = new JLabel("Insert PIN");
    textField = new JTextField("");
    textField.setPreferredSize(new Dimension(200, 30));

    frame3.add(textField);
    frame3.getContentPane().add(Label1);
    frame3.pack();

    frame3.setBounds(0, 0, 300, 300); //The size of the frame
    frame3.setLocationRelativeTo(null); //Centers the frame relative to the screen
    container = frame3.getContentPane(); //Creates a container to contain the JButtons
    container.setLayout(null);
    Label1.setLocation(110, 10);
    Label1.setSize(200, 100);
    textField.setLocation(40, 80);

    ButtonSubmit = new JButton("Submit");
    ButtonSubmit.setBounds(90, 120, 100, 50);
    container.add(ButtonSubmit);
    ButtonSubmit.addActionListener(this);

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default closing operation
    frame.setBounds(0, 0, 500, 500); //The size of the frame
    frame.setLocationRelativeTo(null); //Centers the frame relative to the screen
    frame.setTitle("Main menu");
    frame.getContentPane().setBackground(Color.CYAN);
    container = frame.getContentPane(); //Creates a container to contain the JButtons
    container.setLayout(null);

    Button1 = new JButton("Fast Cash"); //Text Displayed on the first button
    Button1.setBounds(150, 10, 200, 50);
    Button1.setBackground(new Color(255, 230, 230));
    container.add(Button1); //Adds it to the container
    Button1.addActionListener(this); //Links it to ActionListener

    Button2 = new JButton("Cash Withdrawal");
    Button2.setBounds(150, 70, 200, 50);
    Button2.setBackground(new Color(255, 230, 230));
    container.add(Button2);
    Button2.addActionListener(this);

    Button3 = new JButton("Cash Deposit");
    Button3.setBounds(150, 130, 200, 50);
    Button3.setBackground(new Color(255, 230, 230));
    container.add(Button3);
    Button3.addActionListener(this);

    Button4 = new JButton("Transfer Funds");
    Button4.setBounds(150, 190, 200, 50);
    Button4.setBackground(new Color(255, 230, 230));
    container.add(Button4);
    Button4.addActionListener(this);

    Button5 = new JButton("Display Balance");
    Button5.setBounds(150, 250, 200, 50);
    Button5.setBackground(new Color(255, 230, 230));
    container.add(Button5);
    Button5.addActionListener(this);

    Button6 = new JButton("Change PIN");
    Button6.setBounds(150, 310, 200, 50);
    Button6.setBackground(new Color(255, 230, 230));
    container.add(Button6);
    Button6.addActionListener(this);

    Button7 = new JButton("See our other branches");
    Button7.setBounds(150, 370, 200, 50);
    Button7.setBackground(new Color(255, 230, 230));
    container.add(Button7);
    Button7.addActionListener(this);

    FastCash = new JFrame();
    FastCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default closing operation
    FastCash.setBounds(0, 0, 400, 400); //The size of the frame
    FastCash.getContentPane().setBackground(Color.CYAN); // Sets the background color to cyan
    FastCash.setLocationRelativeTo(null); //Centers the frame relative to the screen
    FastCash.setTitle("Main menu");
    container = FastCash.getContentPane(); //Creates a container to contain the JButtons
    container.setLayout(null);

    Button500 = new JButton("RS 500"); //Text Displayed on the first button
    Button500.setBounds(90, 10, 200, 50);
    Button500.setBackground(new Color(255, 230, 230)); //sets the background color of the button to metal
    container.add(Button500); //Adds it to the container
    Button500.addActionListener(this); //Links it to ActionListener

    Button1000 = new JButton("RS 1000");
    Button1000.setBounds(90, 80, 200, 50);
    Button1000.setBackground(new Color(255, 230, 230)); //sets the background color of the button to metal
    container.add(Button1000);
    Button1000.addActionListener(this);

    Button1500 = new JButton("RS 1500");
    Button1500.setBounds(90, 150, 200, 50);
    Button1500.setBackground(new Color(255, 230, 230)); //sets the background color of the button to metal
    container.add(Button1500);
    Button1500.addActionListener(this);

    Button2000 = new JButton("RS 2000");
    Button2000.setBounds(90, 220, 200, 50);
    Button2000.setBackground(new Color(255, 230, 230)); //sets the background color of the button to metal
    container.add(Button2000);
    Button2000.addActionListener(this);

    Withdraw = new JFrame();
    Withdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default closing operation
    Withdraw.getContentPane().setBackground(Color.CYAN);
    Withdraw.setLayout(new FlowLayout());

    Withdraw.setTitle("Withdrawal menu");
    Label1 = new JLabel("<html>Insert the amount to withdraw: <br>" +
      "Daily Credit left: RS " + myATM.CreditLimit + "</html>");

    WithdrawField = new JTextField("");
    WithdrawField.setPreferredSize(new Dimension(200, 30));

    Withdraw.add(WithdrawField);
    Withdraw.getContentPane().add(Label1);
    Withdraw.pack();

    Withdraw.setBounds(0, 0, 300, 300); //The size of the frame
    Withdraw.setLocationRelativeTo(null); //Centers the frame relative to the screen
    container = Withdraw.getContentPane(); //Creates a container to contain the JButtons
    container.setLayout(null);
    Label1.setLocation(50, 10);
    Label1.setSize(200, 100);
    WithdrawField.setLocation(40, 80);

    ButtonWithdraw = new JButton("Submit");
    ButtonWithdraw.setBounds(90, 120, 100, 50);
    ButtonWithdraw.setBackground(new Color(255, 230, 230)); //sets the background color of the button to metal
    container.add(ButtonWithdraw);
    ButtonWithdraw.addActionListener(this);

    Deposit = new JFrame();
    Deposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default closing operation
    Deposit.getContentPane().setBackground(Color.CYAN);
    Deposit.setLayout(new FlowLayout());

    Deposit.setTitle("Deposit menu");
    Label1 = new JLabel("Insert the amount to deposit:");

    DepositField = new JTextField("");
    DepositField.setPreferredSize(new Dimension(200, 30));

    Deposit.add(DepositField);
    Deposit.getContentPane().add(Label1);
    Deposit.pack();

    Deposit.setBounds(0, 0, 300, 300); //The size of the frame
    Deposit.setLocationRelativeTo(null); //Centers the frame relative to the screen
    container = Deposit.getContentPane(); //Creates a container to contain the JButtons
    container.setLayout(null);
    Label1.setLocation(50, 10);
    Label1.setSize(200, 100);
    DepositField.setLocation(40, 80);

    ButtonDeposit = new JButton("Submit");
    ButtonDeposit.setBounds(90, 120, 100, 50);
    ButtonDeposit.setBackground(new Color(255, 230, 230)); //sets the background color of the button to metal
    container.add(ButtonDeposit);
    ButtonDeposit.addActionListener(this);

    ChangePIN = new JFrame();
    ChangePIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default closing operation
    ChangePIN.getContentPane().setBackground(Color.CYAN);
    ChangePIN.setLayout(new FlowLayout());

    ChangePIN.setTitle("Change PIN");
    Label1 = new JLabel("Insert new PIN");
    ChangeField = new JTextField("");
    ChangeField.setPreferredSize(new Dimension(200, 30));

    ChangePIN.add(ChangeField);
    ChangePIN.getContentPane().add(Label1);
    ChangePIN.pack();

    ChangePIN.setBounds(0, 0, 300, 300); //The size of the frame
    ChangePIN.setLocationRelativeTo(null); //Centers the frame relative to the screen
    container = ChangePIN.getContentPane(); //Creates a container to contain the JButtons
    container.setLayout(null);
    Label1.setLocation(90, 10);
    Label1.setSize(200, 100);
    ChangeField.setLocation(40, 80);

    ButtonChange = new JButton("Submit");
    ButtonChange.setBounds(90, 120, 100, 50);
    container.add(ButtonChange);
    ButtonChange.addActionListener(this);
    

    frame2.setVisible(true); //Sets the frame as visible
    frame3.setVisible(false); //Sets the frame as invisible
    frame.setVisible(false); //Sets the frame as invisible
    FastCash.setVisible(false); //Sets the frame as invisible
    Withdraw.setVisible(false);  //Sets the frame as invisible
    Deposit.setVisible(false);  //Sets the frame as invisible
    ChangePIN.setVisible(false);  //Sets the frame as invisible

  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    int Choice = 0;
    int FastCashChoice, Attempts, index, FastCashAmount, InputPIN = 0;
    int WithdrawalAmount, DepositAmount;
    int NewBalance, TransferAmount;
    String NewAccountNo;
    boolean Correct;
    String EndChoice;
    char EndChar;
    boolean Found = false;
    int NewPIN = 0, PINLength = 0;
    Account[] myAccount = new Account[5];
    final String filePath = "C:\\TMP\\ATMDetails.txt";
    ATM myATM = new ATM(); //Instantiating an object of type ATM
    Card myCard = new Card();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { //Opens the file for read
      //BufferedReader decreases the amount of I/O process, thus speeding up the program
      String NewLine1; //Reads a line from the file
      String NewLine2; //Reads the line after from the file 
      index = 0;

      do {
        NewLine1 = reader.readLine();
        NewLine2 = reader.readLine(); // Read the next line from the file
        if (NewLine1 != null && NewLine2 != null) { //if none of the lines are blank
          NewBalance = Integer.parseInt(NewLine1);
          myAccount[index] = new Account(NewLine2, NewBalance); //instantiate an object in array myAccount
          index++; //Increment index
        }

      } while (NewLine1 != null && NewLine2 != null); //While EOF has not been reached

    } catch (IOException e) { //Catches the exception
      e.printStackTrace(); // used to throw an exception in case the file is not found
    }

    if (arg0.getSource() == Button1) { //If button 1 is clicked
      frame.dispose(); //Closes the Jframe once an option is selected
      FastCash.setVisible(true);

    } else if (arg0.getSource() == Button2) {
      frame.dispose(); //Closes the Jframe once an option is selected
      Withdraw.setVisible(true);

    } else if (arg0.getSource() == Button3) {
      frame.dispose(); //Closes the Jframe once an option is selected
      Deposit.setVisible(true);

    } else if (arg0.getSource() == Button4) {
      frame.dispose(); //Closes the Jframe once an option is selected
      
      do {
        NewAccountNo = JOptionPane.showInputDialog("Enter the account number:");
        index = 0;
        do { //Performing a linear search in the array myAccount
          if (NewAccountNo.equals(myAccount[index].AccountNo)) {  // Compares the array element to the account number input
            Found = true;
            break; //exits the do while loop
          } else {
            index++;
          }
        } while (index < 5);//Until there are elements in the array

        if (Found == false || NewAccountNo == null || index == 0) { //In case the account has not been found or the AccountNo is the same as th user's
          JOptionPane.showMessageDialog(null, "Invalid account number! Please retry");
        }
      } while (Found == false || NewAccountNo == null || index == 0); //In case the account has not been found or the AccountNo is the same as th user's

      do {
        TransferAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount to transfer \n" +
          "Daily Credit Limit: " + myATM.CreditLimit));
        if (TransferAmount > myAccount[0].Balance) {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Amount input exceeds the balance available! \n" +
            "Please retry!</font></html>"));
        } else if (myATM.CheckCreditLimit(TransferAmount) == false) {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Amount input exceeds credit limit!\n" +
            "Please retry!</font></html>"));
        }

      } while (myATM.CheckCreditLimit(TransferAmount) == false || TransferAmount > myAccount[0].Balance);
      myAccount[0].Withdrawal(TransferAmount);
      myATM.CreditWithdraw(TransferAmount);
      myAccount[index].Deposit(TransferAmount);

      int NewInd = 2 * index; //Index is multipilied by 2 as we are skipping 1 row each time in the file
      try {
        UpdateLine(filePath, 0, Integer.toString(myAccount[0].Balance));
        UpdateLine(filePath, NewInd, Integer.toString(myAccount[index].Balance));

      } catch (IOException e) {
        e.printStackTrace();
      }

      do {
        EndChoice = JOptionPane.showInputDialog("Do you want a receipt? <Y/N>");
        EndChoice = EndChoice.toUpperCase(); //Converts the choice input by user to upper case
        EndChar = EndChoice.charAt(0); //Converts the choice input to Char

        if (EndChar != 'Y' && EndChar != 'N') {
          JOptionPane.showMessageDialog(null, "<html><font color='red'>Invalid input! Please retry!</font></html>");
        }
      } while (EndChar != 'Y' && EndChar != 'N');

      if (EndChar == 'Y') {
        myATM.printReceipt(4, TransferAmount, NewAccountNo, "Transfer");
      }
      Choice = 4;
    } else if (arg0.getSource() == Button5) {
      frame.dispose(); //Closes the Jframe once an option is selected
      myAccount[0].DisplayDetails();
      EndDisplay(0);
    } else if (arg0.getSource() == Button6) {
      frame.dispose(); //Closes the Jframe once an option is selected
      ChangePIN.setVisible(true);
    } else if (arg0.getSource() == Button7) {
      frame.dispose(); //Closes the Jframe once an option is selected
      DisplayLocations();
      EndDisplay(0);
    }

    if (arg0.getSource() == ButtonOK) {
      frame2.dispose(); //Closes the Jframe once an option is selected
      frame3.setVisible(true);
    } else if (arg0.getSource() == ButtonSubmit) {

      Correct = true;
      do {
        String TextInput = textField.getText();
        try {
          Integer.parseInt(TextInput);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Invalid PIN format! \n" +
            "Please retry!</font></html>"));
          textField.setText("");
        }

        InputPIN = Integer.parseInt(textField.getText()); //Prompts user to enter the Debit/Credt card PIN

        Correct = myCard.CheckPIN(InputPIN);

        if (Correct == true) {
          frame3.dispose(); //Closes the Jframe once an option is selected
          frame.setVisible(true);
          break; //The program will exit the For loop if the PIN is correct
        } else { //If the PIN is incorrect
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Incorrect PIN! \n" +
            "Please retry!</font></html>")); //Will display the number of attempts left
          textField.setText("");
        }

      } while (Correct == false);

      //EndDisplay(Choice);  //Calls the procedure to display the final message
    }
    if (arg0.getSource() == Button500) {  //If user selects RS500
      FastCashChoice = 1;
      FastCashAmount = DisplayFastCashChoice(myAccount[0], myATM, FastCashChoice);

      if (FastCashAmount != 0) {
        myAccount[0].Withdrawal(FastCashAmount);
      }

      try {
        UpdateLine(filePath, 0, Integer.toString(myAccount[0].Balance)); //Updates the file

      } catch (IOException e) {
        e.printStackTrace();
      }

      FastCash.dispose();
      EndDisplay(1);

    } else if (arg0.getSource() == Button1000) {
      FastCashChoice = 2;
      FastCashAmount = DisplayFastCashChoice(myAccount[0], myATM, FastCashChoice);

      if (FastCashAmount != 0) {
        myAccount[0].Withdrawal(FastCashAmount);
      }

      try {
        UpdateLine(filePath, 0, Integer.toString(myAccount[0].Balance)); //Updates the file

      } catch (IOException e) {
        e.printStackTrace();
      }

      FastCash.dispose();
      EndDisplay(1);

    } else if (arg0.getSource() == Button1500) {
      FastCashChoice = 3;
      FastCashAmount = DisplayFastCashChoice(myAccount[0], myATM, FastCashChoice);

      if (FastCashAmount != 0) {
        myAccount[0].Withdrawal(FastCashAmount);
      }

      try {
        UpdateLine(filePath, 0, Integer.toString(myAccount[0].Balance)); //Updates the file

      } catch (IOException e) {
        e.printStackTrace();
      }

      FastCash.dispose();
      EndDisplay(1);

    } else if (arg0.getSource() == Button2000) {
      FastCashChoice = 4;
      FastCashAmount = DisplayFastCashChoice(myAccount[0], myATM, FastCashChoice);

      if (FastCashAmount != 0) {
        myAccount[0].Withdrawal(FastCashAmount);
      }

      try {
        UpdateLine(filePath, 0, Integer.toString(myAccount[0].Balance)); //Updates the file

      } catch (IOException e) {
        e.printStackTrace();
      }
      FastCash.dispose();

      EndDisplay(1);

    } else if (arg0.getSource() == ButtonWithdraw) {
      WithdrawalAmount=0;
      do {
        if (WithdrawField.getText()!="") {
        String TextInput = WithdrawField.getText();
        try {
          Integer.parseInt(TextInput);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Invalid amount!</font></html>"));
          WithdrawField.setText("");
        }
        
        WithdrawalAmount = Integer.parseInt(WithdrawField.getText());

        if (!(myATM.CheckCreditLimit(WithdrawalAmount))) {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Amount input exceeds credit limit! \n" +
            "Please retry!</font></html>"));
          WithdrawField.setText("");
        } else if (WithdrawalAmount > myAccount[0].Balance) {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Amount input exceeds the balance available! \n" +
            "Please retry!</font></html>"));
        } WithdrawField.setText("");
        }
      } while ((myATM.CheckCreditLimit(WithdrawalAmount) == false || WithdrawalAmount > myAccount[0].Balance));
      myAccount[0].Withdrawal(WithdrawalAmount);
      myATM.CreditWithdraw(WithdrawalAmount);

      try {
        UpdateLine(filePath, 0, Integer.toString(myAccount[0].Balance));

      } catch (IOException e) {
        e.printStackTrace();
      }
      Withdraw.dispose();

      do {
        EndChoice = JOptionPane.showInputDialog("Do you want a receipt? <Y/N>");
        EndChoice = EndChoice.toUpperCase();  // Converts user choice to Upper Case
        EndChar = EndChoice.charAt(0);

        if (EndChar != 'Y' && EndChar != 'N') {
          JOptionPane.showMessageDialog(null, "<html><font color='red'>Invalid input! Please retry!</font></html>");
        }
      } while (EndChar != 'Y' && EndChar != 'N');

      if (EndChar == 'Y') {
        myATM.printReceipt(2, WithdrawalAmount, "", "Withdrawal");
      }
      EndDisplay(2);

    } else if (arg0.getSource() == ButtonDeposit) {
        
      DepositAmount=0;
      do {
        
        if (DepositField.getText()!="") {
        String TextInput = DepositField.getText();
        try {
          Integer.parseInt(TextInput);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Invalid amount format!</font></html>"));
          DepositField.setText("");
        }

        DepositAmount = Integer.parseInt(DepositField.getText());

        if (DepositAmount % 100 != 0) {
          JOptionPane.showMessageDialog(null, "<html><font color='red'>Invalid amount! Please retry</font></html>");
          DepositField.setText("");
        }
       }
      } while (DepositAmount % 100 != 0);
      JOptionPane.showMessageDialog(null, "Insert your banknotes");
      myAccount[0].Deposit(DepositAmount);

      try {
        UpdateLine(filePath, 0, Integer.toString(myAccount[0].Balance));

      } catch (IOException e) {
        e.printStackTrace();
      }

      Deposit.dispose();

      do {
        EndChoice = JOptionPane.showInputDialog("Do you want a receipt? <Y/N>");
        EndChoice = EndChoice.toUpperCase();
        EndChar = EndChoice.charAt(0);

        if (EndChar != 'Y' && EndChar != 'N') {
          JOptionPane.showMessageDialog(null, "<html><font color='red'>Invalid input! Please retry!</font></html>");
        }
      } while (EndChar != 'Y' && EndChar != 'N');

      if (EndChar == 'Y') {
        myATM.printReceipt(3, DepositAmount, "", "Deposit");
      }
      EndDisplay(0);

    } else if (arg0.getSource() == ButtonChange) {
      do {
        try {
          Integer.parseInt(ChangeField.getText());
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "<html><font color='red'>Invalid PIN format!</html>"); //In case the user inputs a string instead of integer
          ChangeField.setText("");
          e.printStackTrace();
        }

        NewPIN = Integer.parseInt(ChangeField.getText());
        PINLength = String.valueOf(NewPIN).length(); //Calculates the length of the PIN input by user

        if (PINLength != 4 && ChangeField.getText() != "") {
          JOptionPane.showMessageDialog(null, ("<html><font color='red'>Invalid PIN \n" +
            "It must be 4 digits long!</font></html>"));
          ChangeField.setText("");
        }

      } while (PINLength != 4);
      myCard.UpdatePIN(NewPIN);
      ChangePIN.dispose();
      EndDisplay(0);
    }
  }

  public static int DisplayFastCashChoice(Account myAccount, ATM myATM, int CashChoice) {
    int ReturnAmount = 0;
    if (myATM.CreditLimit < 500) {
      JOptionPane.showMessageDialog(null, "<html><font color='red'>Insufficient daily Credit left!</font></html>");
      System.exit(0); //Halts execution in case the user does not have at least RS 500 of credit limit
    }

    if (myATM.CheckCreditLimit(CashChoice) == false) {
      JOptionPane.showMessageDialog(null, ("<html><font color='red'>Amount input exceeds credit limit!!</font></html>"));
      return 0;
    } else if (CashChoice > myAccount.Balance) {
      JOptionPane.showMessageDialog(null, ("<html><font color='red'>Amount input exceeds the balance available!</font></html>"));
      return 0;
    }

    switch (CashChoice) { //Returns the amount to withdraw based on user'choice
    case 1:
      ReturnAmount = 500;
      break;
    case 2:
      ReturnAmount = 1000;
      break;
    case 3:
      ReturnAmount = 1500;
      break;
    case 4:
      ReturnAmount = 2000;
      break;
    }
    return ReturnAmount;
  }

  public static void EndDisplay(int Choice) {
    if (Choice == 2 || Choice == 1) {
      JOptionPane.showMessageDialog(null,"<html>Please wait for your card " + "<br>" +
        "followed by money</html>");
    } else {
      JOptionPane.showMessageDialog(null,"Please wait for your card");
    }
  }

  private static void UpdateLine(String filePath, int lineNumber, String NewLine) throws IOException {
    Path Newpath = Paths.get(filePath); //Creates a path object

    List < String > AllLiines; // Reading the lines from the file and storing them in a list
    try (Stream < String > stream = Files.lines(Newpath)) { // create a stream of lines from a file
      AllLiines = stream.collect(Collectors.toList()); // used to collect elements from a stream into a List
    }

    AllLiines.set(lineNumber, NewLine); // Update the required line
    Files.write(Newpath, AllLiines); // Write the modified content back to the file
  }

  public static void DisplayLocations() {
    String WillSort, FinalString;
    char EndChar;

    Vector < String > Locations = new Vector < String > (); //Create an empty vector
    //Populating the vector  
    Locations.add("Filc en Flac");
    Locations.add("Curepipe");
    Locations.add("Port Louis");
    Locations.add("Triolet");
    Locations.add("Flacq");

    do {
      WillSort = JOptionPane.showInputDialog("Do you to see the locations in alphabetical order? <Y/N>");
      WillSort = WillSort.toUpperCase();
      EndChar = WillSort.charAt(0);

      if (EndChar != 'Y' && EndChar != 'N') {
        JOptionPane.showMessageDialog(null, "<html><font color='red'>Invalid input! Please retry!</font></html>");
      }
    } while (EndChar != 'Y' && EndChar != 'N');

    if (EndChar == 'Y') {
      bubbleSort(Locations); //Sort the vector array elements in alphabetical order
    }

    // Creating an empty enumeration to store
    Enumeration enu = Locations.elements();

    FinalString = "";
    while (enu.hasMoreElements()) { //While there are elements in the vector array
      FinalString = FinalString + enu.nextElement() + "\n"; //Concatenates each element to a string
    }

    JOptionPane.showMessageDialog(null, "Here is a list of our branches \n" + FinalString);
  }
  
  public static void bubbleSort(Vector<String> arr) {
    int n = arr.size();
    boolean swapped=false;
    for (int i = 0; i < n-1; i++) {  //Outer loop
        swapped = false;
        for (int j = 0; j < n-i-1; j++) {  // Inner loop for comparisons
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) {  //Comparing 2 adjacent array elements
                    // Swap arr[j] and arr[j+1]
                    String temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped=true;
        }
       }
      if (!swapped) {  // If no swap has been done during the inner loop, the array is already sorted
            break;
      }
    }
   }
  }