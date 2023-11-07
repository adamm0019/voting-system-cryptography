package votingapp;

import javax.swing.JFrame;

public class Voting extends JFrame {
    
   
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotingGUI().setVisible(true);
            }
        });
    }
}

    

