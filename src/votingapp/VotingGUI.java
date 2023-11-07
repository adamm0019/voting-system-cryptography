package votingapp;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jake, adam, daniel
 */
public class VotingGUI extends javax.swing.JFrame {

    // creating a new HashMap to store the candidate String and hash byte array
    private final HashMap<String, byte[]> candidateVotes = new HashMap<>();
    // creating an encryption key using the crypto.SecretKey java package
    private final SecretKey encryptionKey;

    /**
     * Creates new form VotingGUI
     */
    public VotingGUI() {
        initComponents();
        
        // using the generateEncryptionKey method from the crypto.SecretKey package to generate a passphrase
        encryptionKey = generateEncryptionKey("xIc3ovkl0293HlVYp");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        candidateSelectionComboBox = new javax.swing.JComboBox<>();
        tableScrollPane = new javax.swing.JScrollPane();
        candidateVoteTable = new javax.swing.JTable();
        helpLabel = new javax.swing.JLabel();
        voteButton = new javax.swing.JButton();
        totalVotes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voting System");
        setResizable(false);

        candidateSelectionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Candidate 1", "Candidate 2", "Candidate 3", "Candidate 4" }));

        candidateVoteTable.setAutoCreateRowSorter(true);
        candidateVoteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Candidate", "Hash"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        candidateVoteTable.setToolTipText("Double Click the value in the \"Hash\" column to copy it to clipboard");
        candidateVoteTable.setCellSelectionEnabled(true);
        candidateVoteTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        candidateVoteTable.setFocusable(false);
        candidateVoteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                candidateVoteTableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(candidateVoteTable);

        helpLabel.setText("Select a candidate:");

        voteButton.setText("Vote for Candidate");
        voteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteButtonActionPerformed(evt);
            }
        });

        totalVotes.setBackground(new java.awt.Color(0, 0, 204));
        totalVotes.setForeground(new java.awt.Color(0, 0, 204));
        totalVotes.setText("<html> <u>Verify integrity of your vote</u> ");
        totalVotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        totalVotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalVotesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(candidateSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(helpLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalVotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(voteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalVotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(candidateSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(voteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteButtonActionPerformed
        // method to cast vote for candidate
        
        // casting the combobox item to a String in order to display it in the table
        String selectedCandidate = (String) candidateSelectionComboBox.getSelectedItem();
        
        if (selectedCandidate != null) { // if the selected candidate is not null
            String voterData = "ID:123;Candidate " + selectedCandidate; // appending the voterData to the selectedCandidate

            try {
                // byte array to store the voterData and encryptionKey
                byte[] encryptedVote = encryptVote(voterData, encryptionKey);
                // storing the selectedCandidate and encrytpedVote variables in the candidateVotes HashMap
                candidateVotes.put(selectedCandidate, encryptedVote);
                
                // updating the table to display the vote
                updateTable();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }//GEN-LAST:event_voteButtonActionPerformed

    private void copyToClipboard(String text) {
        // method to copy the selected hash to the clipboard using StringSelection, Clipboard, and awt.Toolkit
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); // providing access to the users clipboard
        StringSelection selection = new StringSelection(text); // getting the selected string
        clipboard.setContents(selection, null); // setting the clipboard to the selected string

        // feedback to let the user know they have copied the hash from the table
        JOptionPane.showMessageDialog(this, "Hash Copied", null, JOptionPane.INFORMATION_MESSAGE);
    }


    private void totalVotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalVotesMouseClicked
        CheckVoteWithHashGUI vGUI = new CheckVoteWithHashGUI();
        vGUI.setVotingGUI(this);
        vGUI.setVisible(true);
    }//GEN-LAST:event_totalVotesMouseClicked

    private void candidateVoteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_candidateVoteTableMouseClicked
        // method to allow the user to copy the hash from the table by double clicking
        if (evt.getClickCount() == 2) { // if the user clicks twice
            int selectedRow = candidateVoteTable.getSelectedRow(); // get the selected row
            int hashColumnIndex = 1; // define the index of the hash column

            if (selectedRow >= 0) { // check if a valid row was selected by the user
                // get the hash value from the selected row
                String hash = (String) candidateVoteTable.getValueAt(selectedRow, hashColumnIndex);
                // if the hash column is not empty, copy it to the clipboard
                if (hash != null) {
                    copyToClipboard(hash);
                }
            }
        }
    }//GEN-LAST:event_candidateVoteTableMouseClicked

    public void openTotalVotesWindow() { // opens the refactored CheckVoteWithHashGUI class
        CheckVoteWithHashGUI totalVotesGUI = new CheckVoteWithHashGUI(); // creating the hash checking GUI object
        totalVotesGUI.setVotingGUI(this); // setting the reference to VotingGUI to avoid NullPointerException
        totalVotesGUI.setVisible(true); // displaying the GUI
    }

    private void updateTable() { // method to update the table
        DefaultTableModel model = (DefaultTableModel) candidateVoteTable.getModel(); // getting the tables model
        model.setRowCount(0); // clearing the rows of the table

        for (Map.Entry<String, byte[]> entry : candidateVotes.entrySet()) { // iterating through the candidateVotes hashmap to get votes and hashes
            String candidateName = entry.getKey();
            byte[] encryptedVote = entry.getValue();
            
            // adding a row to the table with the candidates name and related hash, using the key and value from the hashmap
            model.addRow(new Object[]{candidateName, calculateHash(encryptedVote)});
        }
    }

    public HashMap<String, byte[]> getVoteHashes() { // used in CheckVoteWithHashGUI to access the hashmap storing candidate names and hashes
        return candidateVotes;
    }

    private byte[] encryptVote(String voteData, SecretKey key) throws Exception { // byte array method with String and SecretKey to pass to hashmap
        Cipher cipher = Cipher.getInstance("AES"); // creating a cipher object using AES encryption algorithm
        cipher.init(Cipher.ENCRYPT_MODE, key); // initialising the cipher in encryption mode
        return cipher.doFinal(voteData.getBytes()); // convert the vote data to bytes and apply the encryption
    }

    public String calculateHash(byte[] data) { // method to calculate the SHA256 hash
        try {
            // creating a messagedigest object using sha256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // calculating the hash of the input data
            byte[] hash = digest.digest(data);
            // encoding the hash as base64 and returning it
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private SecretKey generateEncryptionKey(String passphrase) {
        try {
            SecureRandom random = new SecureRandom();
            // creating a new 16 byte salt to add randomness to the hash
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            // number of iterations to generate a key
            int iterationCount = 10000;
            // the length of the key in bits
            int keyLength = 128;
            
            // creating a secret key using PBKDF2WithHmacSHA1
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            // creating a PBEKeySpec with the passphrase, salt, iteration count, and key length
            PBEKeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt, iterationCount, keyLength);
            // generating the secret key using the factory and spec
            SecretKey tmp = factory.generateSecret(spec);
            
            // converting the generated key for AES encryption
            return new SecretKeySpec(tmp.getEncoded(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotingGUI().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> candidateSelectionComboBox;
    private javax.swing.JTable candidateVoteTable;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JLabel totalVotes;
    private javax.swing.JButton voteButton;
    // End of variables declaration//GEN-END:variables
}
