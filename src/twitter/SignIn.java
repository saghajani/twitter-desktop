
package twitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Saeed
 */
public class SignIn extends JFrame {
    private JLabel userNameLabel;
    private JTextField userNameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton signIn;
    private JLabel signUpLabel;
    private JButton signUp;
    //public int[] suggest = new int[3];
    //public int j=-1, t=0;
    public int randIndex;
    
    public SignIn(){
        super("Sign In");
        setLayout(new FlowLayout());
        userNameLabel = new JLabel("UserName");
        userNameField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        
        final Random rand = new Random();
        randIndex = -1;
        
        signIn = new JButton("Sign In");
        signIn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                if(userNameField.getText().isEmpty())
                    JOptionPane.showMessageDialog(SignIn.this, "Enter Your User Name!", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(String.valueOf(passwordField.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(SignIn.this, "Enter Your Password", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(Twitter.searchUser(userNameField.getText(), String.valueOf(passwordField.getPassword())) == -1)
                    JOptionPane.showMessageDialog(SignIn.this, "The UserName And Or The Password Is Invalid!", "Error!", JOptionPane.ERROR_MESSAGE);
                else{
                    setVisible(false);
                    Twitter.thisUserIndex = Twitter.searchUser(userNameField.getText(), String.valueOf(passwordField.getPassword()));
                   
 //Random Suggestion
                    if (Twitter.numberOfUsers > 1){
                        for(int k=0; (randIndex == -1) && (k < Twitter.numberOfUsers); k++){
                        randIndex = rand.nextInt(Twitter.numberOfUsers);
                        if(randIndex != Twitter.thisUserIndex){
                            if(randIndex != -1)
                            for(int i=0; i<Twitter.user[Twitter.thisUserIndex].numOfFollowings; i++){
                                if(Twitter.user[Twitter.thisUserIndex].followings[i].equals(Twitter.user[randIndex].name)){
                                     randIndex = -1;
                                     break;
                                }
                            }
                           if(randIndex != -1)
                               for(int i=0; i<Twitter.user[Twitter.thisUserIndex].numOfFollowers; i++){
                                   if(Twitter.user[Twitter.thisUserIndex].followers[i].equals(Twitter.user[randIndex].name)){
                                       randIndex = -1;
                                       break;
                                }
                               }
                        }
                        else randIndex = -1;
                        
                        }//end of for
                        if(randIndex != -1){
                        Suggestion suggestion = new Suggestion(randIndex);
                        suggestion.setBounds(800, 400, 400, 200);
                        suggestion.setVisible(true);
                    }//end of if
                    }//end of first if
                    
//End of Random Suggestion
                    
//                    if(( Twitter.numberOfUsers > 1) && (Twitter.numberOfUsers < 5)){
//                        for(int i=0; i<Twitter.numberOfUsers; i++){
//                            if(i != Twitter.thisUserIndex){
//                                for( j=0; j<Twitter.user[Twitter.thisUserIndex].numOfFollowings; j++){
//                                    System.out.println("do nothing.");
//                                    if(Twitter.user[Twitter.thisUserIndex].followings[j].equals(Twitter.user[i].name))
//                                        break;
//                                }
//                                if(j > 0){
//                                    System.out.println(j);
//                                if(Twitter.user[Twitter.thisUserIndex].followings[j].equals(Twitter.user[i].name))
//                                    System.out.println("do nothing.");
//                                }
//                                else{
//                                    if(t<3){
//                                    suggest[t] = i;
//                                    t++;
//                                    }
//                                    else break;
//                                }
//                                
//                                for( j=0; j<Twitter.user[Twitter.thisUserIndex].numOfFollowers; j++){
//                                    if(Twitter.user[Twitter.thisUserIndex].followers[j].equals(Twitter.user[i].name))
//                                        break;
//                                }
//                                if(j > 0){
//                                if(Twitter.user[Twitter.thisUserIndex].followers[j].equals(Twitter.user[i].name))
//                                    System.out.println("do nothing.");
//                                }
//                                else{
//                                    if(t<3){
//                                    suggest[t] = i;
//                                    t++;
//                                    }
//                                    else break;
//                                }
//                                
//                            }
//                        }//end of for
//                        if(t > 0){
//                            Suggestion suggestion = new Suggestion(suggest[0], suggest[1], suggest[2]);
//                            suggestion.setBounds(400, 300, 600, 200);
//                            suggestion.setVisible(true);
//                            t = 0;
//                            j = -1;
//                            suggest[0] = -1;
//                            suggest[1] = -1;
//                            suggest[2] = -1;
//                            
//                        }
//                    }//end of if
                    
                    
                    
                    UserAccount userAccount = new UserAccount();
                    //userAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    userAccount.setSize(800, 700);
                    userAccount.setVisible(true);
                }            
            }
        });
        
        signUpLabel = new JLabel("Create Account");
        signUp = new JButton("Sign Up");
        signUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                setVisible(false);
                SignUp signUp = new SignUp();
            }
        });
        
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signUpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signUp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameLabel)
                            .addComponent(passwordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(passwordField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signIn))
                            .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signIn))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpLabel)
                    .addComponent(signUp))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
        
    }
}

