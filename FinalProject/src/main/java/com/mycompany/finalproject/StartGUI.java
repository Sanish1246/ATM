
package com.mycompany.finalproject;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartGUI implements ActionListener {
    
    JFrame InitialFrame;
    JButton ButtonOK;
    
    public StartGUI() {
    InitialFrame = new JFrame();
   
        InitialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Sets the default closing operation
        InitialFrame.setBounds(0,0,500,500);
        InitialFrame.setTitle("Start Screen");
        Container Startcontainer = InitialFrame.getContentPane();
        Startcontainer.setLayout(null);
        
        JLabel StartLabel = new JLabel("Welcome to MDX Banking! Please insert your card"); 
        
        InitialFrame.getContentPane().add(StartLabel);  //Attaches the label to the frame
        
       InitialFrame.setSize(500, 500);   // Used to set the size of the window
        
       StartLabel.setHorizontalAlignment(JLabel.CENTER); ///Aligns the label to appear in the center of the frame
       StartLabel.setVerticalAlignment(JLabel.NORTH);
       InitialFrame.setLocationRelativeTo(null);    //Aligns the window to appear in the center of the screen
        
       InitialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Sets the default closing operation

       InitialFrame.setVisible(true); //Makes the window visible
       
       ButtonOK=new JButton("Cash Withdrawal");
        ButtonOK.setBounds(150,70,50,50);
        Startcontainer.add(ButtonOK);
        ButtonOK.addActionListener(this);
        
        InitialFrame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == ButtonOK) {
            InitialFrame.dispose();
        }
    }
}


