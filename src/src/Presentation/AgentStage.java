package Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AgentStage extends JDialog {
    private JButton SignUpReferee;
    private JButton MatchSchedule;

    private JPanel mainPanel;
    public AgentStage() {
        setContentPane(mainPanel);
        setModal(true);
        SignUpReferee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpReferee signUpReferee = new SignUpReferee();
                signUpReferee.pack();
                signUpReferee.setVisible(true);
                System.out.println("sign in clicked");
            }
        });
        MatchSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpReferee signUpReferee = new SignUpReferee();
                signUpReferee.pack();
                signUpReferee.setVisible(true);
            }
        });
//        MatchSchedule.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                MatchSchedule MatchSchedule = new MatchSchedule();
//                signUpReferee.pack();
//                signUpReferee.setVisible(true);
//                System.out.println("sign in clicked");
//            }
//        });
    }



}
