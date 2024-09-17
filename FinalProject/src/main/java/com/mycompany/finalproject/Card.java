
package com.mycompany.finalproject;

import java.io.BufferedReader;  //Needed for the BufferedReader class
import java.io.FileReader;  //Needed for the FileReader class to read the lines from the file
import java.io.IOException;  //Needed for exception handling when reading the file
import javax.swing.JOptionPane; //needed for display the dialogue boxes
import java.nio.file.Files;  //used to import the Files class from the java.nio.file
import java.nio.file.Path;  //Used for the path object
import java.nio.file.Paths;  //Used for the path object
import java.util.List;  //Needed to create a list
import java.util.stream.Collectors;  //used to import the Collectors class
import java.util.stream.Stream;   //used to import the Stream

public class Card {
  int PIN;
  final String PathFile = "C:\\TMP\\CardPIN.txt";
  
public Card() {
   
   try (BufferedReader reader = new BufferedReader(new FileReader(PathFile))) {  //Opens the file for read
            //BufferedReader decreases the amount of I/O process, thus speeding up the program
       String NextLine;  //Reads a line from the file

       NextLine= reader.readLine();
       PIN = Integer.parseInt(NextLine);
     }   catch (IOException e) {  //Catches the exception
      e.printStackTrace();  // used to throw an exception in case the file is not found
    }
}

public boolean CheckPIN(int NewPIN) {  //Function used to check if the PIN enetered by user matched the PIN already stored
    if (NewPIN==PIN) {
        return true;
    } else {
        return false;
    }
}

public void UpdatePIN(int NewPIN) {  //Procedure used to update the PIN    
     try {
         PIN=NewPIN;
         UpdateLine(PathFile, 0, Integer.toString(NewPIN));
      //Displays a message in case the PIN was updated with success
     } catch (IOException e) {
        e.printStackTrace();
     }    
     
      JOptionPane.showMessageDialog(null, ("<html><font color='green'>PIN Updated!</font></html>"));
 }

private static void UpdateLine(String filePath, int lineNumber, String NewLine) throws IOException {
        Path Newpath = Paths.get(filePath);   //Creates a path object

        List<String> AllLiines;   // Reading the lines from the file and storing them in a list
        try (Stream<String> stream = Files.lines(Newpath)) {  // create a stream of lines from a file
            AllLiines = stream.collect(Collectors.toList());   // used to collect elements from a stream into a List
        }

        AllLiines.set(lineNumber, NewLine);   // Update the required line
        Files.write(Newpath, AllLiines);     // Write the modified content back to the file
    }
}
