package Presentation;

import Domain.Game.Match;
import Service.UserApplication;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;


public class MatchSchedule  extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;



    public MatchSchedule() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        UserApplication ua = new UserApplication();
        if(textField1.getText().equalsIgnoreCase("spain") || textField1.getText().equalsIgnoreCase("israel")){
            List<Match> m=ua.scudualeMaches(textField1.getText(),textField2.getText() ,Integer.parseInt(textField3.getText()));
            if(m==null)
            {
                JOptionPane.showMessageDialog(null, "Season Already Busy");
            }
            System.out.println(textField1.getText()+", "+textField2.getText() +", "+textField3.getText());
            dispose();

        }
        else
        {
            JOptionPane.showMessageDialog(null, "League Does Not Exists!");
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }




}
