
package twitter;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Saeed
 */
public class SignUp extends JFrame{
    JLabel nameLabel;
    JTextField nameField;
    JLabel userNameLabel;
    JTextField userNameField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JLabel conPassLabel;
    JPasswordField conPassField;
    JLabel genderLabel;
    JComboBox genComboBox;
    JLabel bioLabel;
    JTextArea bioTextArea;
    JButton createAccount;
    private final JScrollPane jScrollPane1;
    
    public SignUp(){
        super("Sign Up");
        setLayout(new FlowLayout());
        
        nameLabel=new JLabel("Full Name");
        nameField = new JTextField();
        nameLabel.setLabelFor(nameField);
        userNameLabel = new JLabel("UserName");
        userNameField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        conPassLabel = new JLabel("Confirm Password");
        conPassField = new JPasswordField();
        conPassLabel.setLabelFor(conPassField);
        genderLabel = new JLabel("Gender");
        genComboBox = new JComboBox(new String[]{"Male","Female"} );
        genComboBox.setBounds(170, 180, 80, 20);
        add(genComboBox);
        bioLabel = new JLabel("Bio");
        bioTextArea = new JTextArea(5, 50);
        bioTextArea.setLineWrap(true);
        jScrollPane1 = new JScrollPane(bioTextArea);
        
        createAccount = new JButton("Create Account");
        createAccount.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                if(nameField.getText().isEmpty())
                    JOptionPane.showMessageDialog(SignUp.this, "Enter Your Name!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(userNameField.getText().isEmpty())
                    JOptionPane.showMessageDialog(SignUp.this, "Enter Your UserName!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(String.valueOf(passwordField.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(SignUp.this, "Enter Your Password!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(String.valueOf(conPassField.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(SignUp.this, "Confirm Your Password!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(!(String.valueOf(passwordField.getPassword()).equals(String.valueOf(conPassField.getPassword()))))
                    JOptionPane.showMessageDialog(SignUp.this, "Confirmation was not successful!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(Twitter.searchUser(userNameField.getText()) != -1)
                    JOptionPane.showMessageDialog(SignUp.this, "This UserName Is Invalid!", "Error!", JOptionPane.ERROR_MESSAGE);
                else{
                    setVisible(false);
                    Twitter.createAccount(nameField.getText(), userNameField.getText(), String.valueOf(passwordField.getPassword()), genComboBox.getSelectedItem().toString() , bioTextArea.getText() );
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
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createAccount)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(userNameLabel)
                            .addComponent(passwordLabel)
                            .addComponent(conPassLabel)
                            .addComponent(genderLabel)
                            .addComponent(bioLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(userNameField)
                                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(conPassField)
                                     .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(genComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addContainerGap(219, Short.MAX_VALUE))
                );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conPassLabel)
                    .addComponent(conPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                   .addComponent(genComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bioLabel)
                    .addComponent(jScrollPane1,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(createAccount)
                .addGap(35, 35, 35))
        );

        pack();
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    
}
