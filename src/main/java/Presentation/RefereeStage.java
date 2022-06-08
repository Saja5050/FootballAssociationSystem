package Presentation;

import Domain.Referee;
import Service.UserApplication;

import javax.swing.*;
import java.util.ArrayList;

public class RefereeStage extends JDialog {
    private JLabel ref;
    private JPanel mainPanel;
    private JTextArea textArea1;

    public RefereeStage(Referee referee){
        setContentPane(mainPanel);
        setModal(true);
        UserApplication userApplication = new UserApplication();
        ArrayList<String> matches = userApplication.getMatches(referee);
        for (String match:matches) {
            System.out.println(match);
            textArea1.append(match+"\n");
        }
    }
}
