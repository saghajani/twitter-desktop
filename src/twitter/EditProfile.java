
package twitter;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Saeed
 */
public class EditProfile extends JFrame {
    JLabel curPassLabel;
    JLabel newPassLabel;
    JLabel conNewPassLabel;
    JPasswordField curPassField;
    JPasswordField newPassField;
    JPasswordField conNewPassField;
    JButton changePass;
    JLabel changeImg;
    JButton browse;
    JButton removeAccount;
    
    public EditProfile(){
        super("Edit Profile");
        
        curPassLabel = new JLabel();      
        newPassLabel = new JLabel();
        conNewPassLabel = new JLabel();
        curPassField = new JPasswordField();
        newPassField = new JPasswordField();
        conNewPassField = new JPasswordField();
        changePass = new JButton();
        changeImg = new JLabel();
        browse = new JButton();
        removeAccount = new JButton();
        
        
        curPassLabel.setText("current Password");

        newPassLabel.setText("new Password");

        conNewPassLabel.setText("Confirm new Password");

        changePass.setText("Change Password");
        changePass.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                if(String.valueOf(curPassField.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(EditProfile.this, "Enter Current Password!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(!(String.valueOf(curPassField.getPassword()).equals(Twitter.user[Twitter.thisUserIndex].password)))
                    JOptionPane.showMessageDialog(EditProfile.this, "Current Password Is Wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(String.valueOf(newPassField.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(EditProfile.this, "Enter New Password!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(String.valueOf(conNewPassField.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(EditProfile.this, "Confirm Your New Password!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(!(String.valueOf(newPassField.getPassword()).equals(String.valueOf(conNewPassField.getPassword()))))
                    JOptionPane.showMessageDialog(EditProfile.this, "Confirmation Was Not Successful!", "Error!", JOptionPane.ERROR_MESSAGE);
                else{
                    Twitter.user[Twitter.thisUserIndex].password = String.valueOf(newPassField.getPassword());
                    JOptionPane.showMessageDialog(EditProfile.this, "Your Password has been Changed.", "change password", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        changeImg.setText("Change Image");

        browse.setText("Browse");
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
               File file = getFile();              
               Twitter.user[Twitter.thisUserIndex].profImage= new ImageIcon(file.getPath());
               JOptionPane.showMessageDialog(EditProfile.this, "Your Profile Image has been Changed.", "change image", JOptionPane.INFORMATION_MESSAGE);
                 
            }
        });
        
        removeAccount.setText("Remove Account");
        removeAccount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
               if(JOptionPane.showConfirmDialog(EditProfile.this, "Are You sure to Remove Your Account?", "remove account!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
                   for(int i=Twitter.thisUserIndex; i<(Twitter.numberOfUsers)-1; i++){
                       Twitter.user[i] = Twitter.user[i+1];
                   }
                   Twitter.numberOfUsers--;
                   setVisible(false);
                   //setVisible(false);
                   SignIn signIn = new SignIn();
                   signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   signIn.setSize(800,600);
                   signIn.setVisible(true);
               }
               
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changePass)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changeImg)
                        .addGap(18, 18, 18)
                        .addComponent(browse))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(curPassLabel)
                            .addComponent(newPassLabel)
                            .addComponent(conNewPassLabel))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(conNewPassField)
                            .addComponent(newPassField)
                            .addComponent(curPassField, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addComponent(removeAccount))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curPassLabel)
                    .addComponent(curPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassLabel)
                    .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conNewPassLabel)
                    .addComponent(conNewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(changePass)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeImg)
                    .addComponent(browse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(removeAccount)
                .addContainerGap())
        );

        pack();        
    }

        public File getFile(){
           // throw new UnsupportedOperationException("Not yet implemented");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
              
         int result = fileChooser.showOpenDialog(EditProfile.this);
                
        if(result == JFileChooser.CANCEL_OPTION) System.exit(1);
                
        File file = fileChooser.getSelectedFile();
        if((file == null)||(file.getName().equals(""))){
              JOptionPane.showMessageDialog(EditProfile.this, "Invalid File Name","Invalid File Name", JOptionPane.ERROR_MESSAGE);
              System.exit(1);
        }
        return file;       
    }    
    
}
