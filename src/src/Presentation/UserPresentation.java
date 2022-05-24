package Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Domain.Referee;
import Domain.User;
import Service.*;

public class UserPresentation extends JDialog{
    private JButton SigninButton;
    private JTextField textfield1;

    private JPanel mainPanel;
    private JPasswordField passwordField1;

    public UserPresentation() {
        setContentPane(mainPanel);
        setModal(true);
         SigninButton.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                UserApplication ua = new UserApplication();
                 User user = ua.sign_in(textfield1.getText(),String.valueOf(passwordField1.getPassword()));
                if ( user != null){
                    if( user.is_referee() ){
                        //Referee
                        System.out.println("Referee");
                        RefereeStage refereeStage = new RefereeStage((Referee) user);
                        refereeStage.pack();
                        refereeStage.setVisible(true);
                    }
                    else {
                        //Agent
                        System.out.println("Agent");
                        AgentStage secondStage = new AgentStage();
                        secondStage.pack();
                        secondStage.setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "The username or password is incorrect !");
                };



            }
        });
    }
//    public static void main (String args[]){
//        JFrame frame = new JFrame("Example");
//        frame.setContentPane(new UserPresentation().mainPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//        League Champ=new League();
//
//
//
//    }

}
