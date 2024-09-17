
package com.mycompany.finalproject;
import java.time.LocalDate;   //Used to get the local Date
import java.time.LocalDateTime;  //Used to get the local Date and time
import javax.swing.JOptionPane; //needed for display the dialogue boxes
import java.io.BufferedReader;  //Needed for the BufferedReader class
import java.io.FileReader;    //Needed for the FileReader class to read the lines from the file
import java.io.IOException;   //Needed for exception handling when reading the file
import java.nio.file.Files;  //used to import the Files class from the java.nio.file
import java.nio.file.Path;  //Used for the path object
import java.nio.file.Paths;  //Used for the path object
import java.time.format.DateTimeFormatter;  //Used to format the Date and time 
import java.util.List;  //Needed to create a list
import java.util.stream.Collectors;  //used to import the Collectors class
import java.util.stream.Stream;   //used to import the Stream

public class ATM {
  int CreditLimit;
  String PathFile = "C:\\TMP\\ATMDate.txt";
  
  public  ATM() {
      LocalDate currentDate = LocalDate.now();  //Gets the curret Date
      LocalDate StoredDate;
      DateTimeFormatter formatter;  //Creates a formatter for date and time
      String NextLine,NextLimit;
   
   try (BufferedReader reader = new BufferedReader(new FileReader(PathFile))) {  //Opens the file for read
            //BufferedReader decreases the amount of I/O process, thus speeding up the program
     
     NextLine= reader.readLine(); //Reads a line from the file
     NextLimit=reader.readLine();
     StoredDate = LocalDate.parse(NextLine);  //Coverts the line of text to LocalDate type
     
     if (currentDate.compareTo(StoredDate)!=0) {   //If the date has changed since the last operation
         CreditLimit=10000;     //Resets Credit Limit
         StoredDate=currentDate;  //Sets the stored date to Today's date
         formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");   //Formats the date in the format "yyyy-MM-dd" for comapsions
         NextLine=StoredDate.format(formatter);   //Stores the date in the format "yyyy-MM-dd" in a string
         UpdateLine(PathFile, 0, NextLine);  
         UpdateLine(PathFile, 1, Integer.toString(CreditLimit));
     } else {
       CreditLimit=Integer.parseInt(NextLimit);  //Else, if the date is still the same, it just takes the Credit limit already stored
     }
    } catch (IOException e) {  //Catches the exception
      e.printStackTrace();  // used to throw an exception in case the file is not found
    } 
      
  }
  
  public boolean CheckCreditLimit(double AmountToTake) {  //Used to check if the amount selceted by user for withdrawal exceeds the Credit Limit
      if (AmountToTake>CreditLimit) {
          return false;
      } else {
          
          return true;
      }
  }
  
  public void CreditWithdraw(int AmountToTake) {
      CreditLimit=CreditLimit-AmountToTake;
      
       try {
      UpdateLine(PathFile, 1, Integer.toString(CreditLimit));  //Updates the credit limit in the file
            
     } catch (IOException e) {
      e.printStackTrace();
     }    
          if (CreditLimit==0) {
             JOptionPane.showMessageDialog(null, "<html><font color='yellow'>Maximum amount of daily credit reached!</font></html>");
          }
  }
  
  public void printReceipt(int Choice,int Amount, String AccountNo,String Operation) {
      LocalDateTime currentDateTime = LocalDateTime.now();
      
      // Define a formatter to format the date and time to be displayed
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Format the current date time using the formatter
        String NewDateTime = currentDateTime.format(formatter);

      
      if (Choice==4) {  //Displays a different receipt based onn the operation done
         JOptionPane.showMessageDialog(null,"Date:" + NewDateTime  + "\n" 
              + "------------------------------" + "\n" 
              + "Operation done: " + Operation + "\n"
              + "------------------------------" + "\n" 
              + "Amount Transferred: RS " + Amount + "\n"
              + "To Account Number: " + AccountNo ); 
      } else {
       JOptionPane.showMessageDialog(null,"Date:" + NewDateTime + "\n" 
              + "------------------------------" + "\n" 
              + "Operation done: " + Operation + "\n"
              + "------------------------------" + "\n" 
              + "Amount: RS " + Amount);   
      }
  }
  
  private static void UpdateLine(String filePath, int lineNumber, String NewLine) throws IOException {
        Path Newpath = Paths.get(filePath);   //Creates a path object

        List<String> AllLiines;   // Reading the lines from the file and storing them in a list
        try (Stream<String> stream = Files.lines(Newpath)) {  // create a stream of lines from a file
            AllLiines = stream.collect(Collectors.toList());   // used to collect elements from a stream into a List
        }

        AllLiines.set(lineNumber, NewLine);   // Update the required line
        Files.write(Newpath, AllLiines);     // Write the modified content of the list back to the file
    }
}
